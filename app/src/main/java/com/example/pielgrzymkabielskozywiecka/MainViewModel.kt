package com.example.pielgrzymkabielskozywiecka

import android.content.Context
import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import androidx.room.Room
import com.example.pielgrzymkabielskozywiecka.core.data.DataHolder
import com.example.pielgrzymkabielskozywiecka.core.data.database.Database
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Announcements
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Prayers
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Songs
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.BuildApiResponse
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.responses.ModlitwyResponse
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.responses.SongsResponse
import com.example.pielgrzymkabielskozywiecka.core.presentation.UIModels.AnnouncementUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.UIModels.PrayerUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.UIModels.SongUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.mappers.toAnnouncementUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.mappers.toPrayerUI
import com.example.pielgrzymkabielskozywiecka.core.presentation.mappers.toSongUI
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class MainViewModel(context: Context): ViewModel() {
    val database by lazy {
        Room.databaseBuilder(
            context = context,
            klass = Database::class.java,
            name = "local_database.db"
        ).build()
    }
    private val _isAppLoading = MutableStateFlow(true)
    val isAppLoading = _isAppLoading.stateIn(
        scope = viewModelScope,
        started = SharingStarted.WhileSubscribed(5000),
        initialValue = true
    )

    init {
        updateData()
    }

    fun updateData() {
        viewModelScope.launch {
            var songs: List<SongUI>
            var prayers: List<PrayerUI>
            var announcement: AnnouncementUI

            try {
                songs = updateSongs()
                prayers = updatePrayers()
                announcement = updateAnnouncements()
            } catch (e: UnknownHostException) {
                Log.d("error", e.toString())
                songs = database.SongsDao().getSong().map { el -> el.toSongUI() }
                prayers = database.PrayersDao().getPrayers().map { el -> el.toPrayerUI() }

                val localAnnouncements = database.AnnouncementsDao().getAnnouncements()
                announcement = if (localAnnouncements.isNotEmpty()) {
                    localAnnouncements[0].toAnnouncementUI()
                } else {
                    AnnouncementUI(
                        title = "Brak połączenia z internetem",
                        text = "Połącz się z internetem, żeby móc sprawdzić najnowsze ogłoszenia!"
                    )
                }
            }

            DataHolder.announcement = announcement
            DataHolder.songs = songs
            DataHolder.prayers = prayers
            _isAppLoading.update { false }
            Log.d("check", database.AnnouncementsDao().getAnnouncements().toString())
        }
    }

    private suspend fun updateSongs(): List<SongUI> {
        val response = BuildApiResponse.api.getSongs()
        val localSongs = database.SongsDao().getSong().map { el ->
            SongsResponse(el.title, el.lyrics)
        }.toMutableList()
        localSongs.forEach{ el ->
            if(!response.songsList.contains(el)) {
                deleteSong(Songs(0, el.title, el.lyrics))
            }
        }
        response.songsList.forEach{ el ->
            if (!localSongs.contains(el)) {
                addSong(Songs(0, el.title, el.lyrics))
            }
        }
        val songsList = database.SongsDao().getSong().map { el -> el.toSongUI() }
        return songsList
    }

    private suspend fun updatePrayers(): List<PrayerUI> {

        val response = BuildApiResponse.api.getPrayers()
        val localPrayers = database.PrayersDao().getPrayers().map { el ->
            ModlitwyResponse(el.title, el.lyrics)
        }.toMutableList()
        localPrayers.forEach{ el ->
            if(!response.modlitwy.contains(el)) {
                deletePrayer(Prayers(0, el.title, el.lyrics))
            }
        }
        response.modlitwy.forEach{ el ->
            if (!localPrayers.contains(el)) {
                addPrayer(Prayers(0, el.title, el.lyrics))
            }
        }
        val prayerList = database.PrayersDao().getPrayers().map { el -> el.toPrayerUI() }
        return prayerList
    }

    private suspend fun updateAnnouncements(): AnnouncementUI {
        val response = BuildApiResponse.api.getOgloszenia(false)
        val lastResponseItem = response.results[response.results.lastIndex]
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