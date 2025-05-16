package com.example.pielgrzymkabielskozywiecka

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.data.database.Database
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Announcements
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Conferences
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Prayers
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Songs
import com.example.pielgrzymkabielskozywiecka.core.data.networking.ConferencesResponse
import com.example.pielgrzymkabielskozywiecka.core.data.networking.ModlitwyResponse
import com.example.pielgrzymkabielskozywiecka.core.data.networking.SongsResponse
import com.example.pielgrzymkabielskozywiecka.core.presentation.mappers.toAnnouncementUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.mappers.toConferencesUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.mappers.toPrayerUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.mappers.toSongUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.AnnouncementUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.ConferencesUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.PrayerUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.uiModels.SongUI
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.dataSync.AnnouncementsRepository
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.dataSync.ConferencesRepository
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.dataSync.PrayersRepository
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.dataSync.SongsRepository
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.DataError
import com.example.pielgrzymkabielskozywiecka.pielgrzymka.domain.errorHandling.Result
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch

    class MainViewModel(context: Context): ViewModel() {
    val database by lazy {
        Room.databaseBuilder(
            context = context,
            klass = Database::class.java,
            name = "local_database.db"
        ).build()
    }
    private val _state = MutableStateFlow(AppState())
    val state = _state.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = AppState()
    )

    private var toastMessage: String? = null

    init {
        DataHolder.refreshDataFunction = { updateData() }
        updateData() // help
    }

    private fun updateData() {
        _state.update { it.copy(isAppLoading = true) }
        viewModelScope.launch {

            val songs: HashMap<Int, SongUI> = updateSongs()
            val prayers: List<PrayerUI> = updatePrayers()
            val conferences: List<ConferencesUI> = updateConferences()
            val announcement: AnnouncementUI = updateAnnouncements()

            DataHolder.announcement = announcement
            DataHolder.songs = songs
            DataHolder.prayers = prayers
            DataHolder.conferences = conferences

            _state.update { it.copy(isAppLoading = false, toastMessage = toastMessage) }
            DataHolder.isAppLoaded = true
        }
    }

    private suspend fun updateSongs(): HashMap<Int, SongUI> {
        val repository = SongsRepository()
        when(val response = repository.getData()) {
            is Result.Error -> {
                val toastText = when(response.error){
                    DataError.Network.REQUEST_TIMEOUT -> "Brak połączenia z internetem!"
                    DataError.Network.TOO_MANY_REQUESTS -> "Za dużo zapytań jednocześnie!"
                    DataError.Network.NO_CONNECTION -> "Błąd połączenia z internetem!"
                    DataError.Network.SERVER_ERROR -> "Wystąpił problem z serwerem, przepraszamy!"
                    DataError.Network.UNKNOWN -> "Błąd połączenia z internetem!"
                    DataError.Network.UNKNOWN_HOST -> "Błąd pobierania danych!"
                }
                toastMessage = toastText
            }
            is Result.Success -> {
                val localSongs = database.SongsDao().getSong().map { el ->
                    SongsResponse(el.title, el.lyrics)
                }.toMutableList()
                localSongs.forEach{ el ->
                    if(!response.data.songsList.contains(el)) {
                        deleteSong(Songs(0, el.title, el.lyrics))
                    }
                }
                response.data.songsList.forEach{ el ->
                    if (!localSongs.contains(el)) {
                        addSong(Songs(0, el.title, el.lyrics))
                    }
                }
                toastMessage = null
            }
        }

        val songsMap = hashMapOf<Int, SongUI>()
        var index = 0
        database.SongsDao().getSong().forEach { el ->
            index = when(index) {
                5 -> 21
                51 -> 101
                270 -> 301
                else -> index + 1
            }
            songsMap.put(index, el.toSongUI())
        }
        return songsMap
    }

    private suspend fun updatePrayers(): List<PrayerUI> {
        val repository = PrayersRepository()
        when(val response = repository.getData()) {
            is Result.Error -> {
                val toastText = when(response.error){
                    DataError.Network.REQUEST_TIMEOUT -> "Błąd połączenia z internetem!"
                    DataError.Network.TOO_MANY_REQUESTS -> "Za dużo zapytań jednocześnie!"
                    DataError.Network.NO_CONNECTION -> "Błąd połączenia z internetem!"
                    DataError.Network.SERVER_ERROR -> "Wystąpił problem z serwerem, przepraszamy!"
                    DataError.Network.UNKNOWN -> "Błąd połączenia z internetem!"
                    DataError.Network.UNKNOWN_HOST -> "Błąd pobierania danych!"
                }
                toastMessage = toastText
            }

            is Result.Success -> {
                _state.update { it.copy(toastMessage = null) }
                val localPrayers = database.PrayersDao().getPrayers().map { el ->
                    ModlitwyResponse(el.title, el.lyrics)
                }.toMutableList()
                localPrayers.forEach{ el ->
                    if(!response.data.modlitwy.contains(el)) {
                        deletePrayer(Prayers(0, el.title, el.lyrics))
                    }
                }
                response.data.modlitwy.forEach{ el ->
                    if (!localPrayers.contains(el)) {
                        addPrayer(Prayers(0, el.title, el.lyrics))
                    }
                }
                toastMessage = null
            }
        }
        var index = 1
        val prayerList = database.PrayersDao().getPrayers().map { el -> el.toPrayerUI(index++) }
        return prayerList
    }

    private suspend fun updateConferences(): List<ConferencesUI> {
        val repository = ConferencesRepository()
        when(val response = repository.getData()) {
            is Result.Error -> {
                val toastText = when(response.error){
                    DataError.Network.REQUEST_TIMEOUT -> "Błąd połączenia z internetem!"
                    DataError.Network.TOO_MANY_REQUESTS -> "Za dużo zapytań jednocześnie!"
                    DataError.Network.NO_CONNECTION -> "Błąd połączenia z internetem!"
                    DataError.Network.SERVER_ERROR -> "Wystąpił problem z serwerem, przepraszamy!"
                    DataError.Network.UNKNOWN -> "Błąd połączenia z internetem!"
                    DataError.Network.UNKNOWN_HOST -> "Błąd pobierania danych!"
                }
                toastMessage = toastText
            }

            is Result.Success -> {
                _state.update { it.copy(toastMessage = null) }
                val localConferences = database.ConferencesDao().getConference().map { el ->
                    ConferencesResponse(el.title, el.text)
                }.toMutableList()
                localConferences.forEach{ el ->
                    if(!response.data.conferences.contains(el)) {
                        deleteConference(Conferences(0, el.title, el.text))
                    }
                }
                response.data.conferences.forEach{ el ->
                    if (!localConferences.contains(el)) {
                        adConference(Conferences(0, el.title, el.text))
                    }
                }
                toastMessage = null
            }
        }
        var index = 1
        val conferencesList = database.ConferencesDao().getConference().map { el -> el.toConferencesUI(index++) }
        return conferencesList
    }


    private suspend fun updateAnnouncements(): AnnouncementUI {
        val repository = AnnouncementsRepository()

        when(val response = repository.getData()) {
            is Result.Error -> {
                val toastText = when(response.error){
                    DataError.Network.REQUEST_TIMEOUT -> "Błąd połączenia z internetem!"
                    DataError.Network.TOO_MANY_REQUESTS -> "Za dużo zapytań jednocześnie!"
                    DataError.Network.NO_CONNECTION -> "Błąd połączenia z internetem!"
                    DataError.Network.SERVER_ERROR -> "Wystąpił problem z serwerem, przepraszamy!"
                    DataError.Network.UNKNOWN -> "Błąd połączenia z internetem!"
                    DataError.Network.UNKNOWN_HOST -> "Błąd pobierania danych"
                }
                toastMessage = toastText
            }
            is Result.Success -> {
                val lastResponseItem = response.data.results[response.data.results.lastIndex]
                val localAnnouncements = database.AnnouncementsDao().getAnnouncements()

                if (localAnnouncements.isNotEmpty()) {
                    if (localAnnouncements[0].text != lastResponseItem.text ||
                        localAnnouncements[0].title != lastResponseItem.title) {
                        deleteAnnouncement()
                        addAnnouncement(Announcements(0, lastResponseItem.title, lastResponseItem.text))
                    }
                } else {
                    addAnnouncement(Announcements(0, lastResponseItem.title, lastResponseItem.text))
                }
                toastMessage = null
            }
        }
        val announcement = database.AnnouncementsDao().getAnnouncements()
        if (announcement.isNotEmpty()) {
            return announcement[0].toAnnouncementUI()
        }
        return AnnouncementUI(
            title = "Brak połączenia z internetem",
            text = "Połącz się z internetem, żeby móc sprawdzić najnowsze ogłoszenia!"
        )
    }

    private suspend fun addPrayer(prayer: Prayers) {
        database.PrayersDao().insertPrayer(prayer)
    }

    private suspend fun deletePrayer(prayer: Prayers) {
        database.PrayersDao().deletePrayers(prayer.title, prayer.lyrics)
    }

    private suspend fun adConference(conference: Conferences) {
        database.ConferencesDao().insertConference(conference)
    }

    private suspend fun deleteConference(conference: Conferences) {
        database.ConferencesDao().deleteConference(conference.title, conference.text)
    }

    private suspend fun addSong(song: Songs) {
        database.SongsDao().insertSong(song)
    }

    private suspend fun deleteSong(song: Songs) {
        database.SongsDao().deleteSong(song.title, song.lyrics)
    }

    private suspend fun addAnnouncement(announcement: Announcements) {
        database.AnnouncementsDao().insertAnnouncement(announcement)
    }

    private suspend fun deleteAnnouncement() {
        database.AnnouncementsDao().deleteAnnouncements()
    }
}