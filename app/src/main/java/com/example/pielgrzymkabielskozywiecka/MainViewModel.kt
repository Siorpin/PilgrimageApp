package com.example.pielgrzymkabielskozywiecka

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
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.responses.OgloszeniaResponse
import com.example.pielgrzymkabielskozywiecka.core.domain.networking.responses.SongsResponse
import kotlinx.coroutines.launch
import java.net.UnknownHostException

class MainViewModel(private val database: Database): ViewModel() {
    fun updateSongs() {
        viewModelScope.launch {
            try {
                val response = BuildApiResponse.api.getSongs()
                val localAnnouncements = database.SongsDao().getSong().map { el ->
                    SongsResponse(el.title, el.lyrics)
                }.toMutableList()

                localAnnouncements.forEach{ el ->
                    if(!response.songsList.contains(el)) {
                        deleteSong(Songs(0, el.title, el.lyrics))
                    }
                }

                response.songsList.forEach{ el ->
                    if (!localAnnouncements.contains(el)) {
                        addSong(Songs(0, el.title, el.lyrics))
                    }
                }

                DataHolder.songs = database.SongsDao().getSong().map { el -> SongsResponse(el.title, el.lyrics) }
            } catch (e: UnknownHostException) {
                Log.d("error", e.toString())
            }
        }
    }

    fun updatePrayers() {
        viewModelScope.launch {
            try {
                val response = BuildApiResponse.api.getPrayers()
                val localAnnouncements = database.PrayersDao().getPrayers().map { el ->
                    ModlitwyResponse(el.title, el.lyrics)
                }.toMutableList()

                localAnnouncements.forEach{ el ->
                    if(!response.modlitwy.contains(el)) {
                        deletePrayer(Prayers(0, el.title, el.lyrics))
                    }
                }

                response.modlitwy.forEach{ el ->
                    if (!localAnnouncements.contains(el)) {
                        addPrayer(Prayers(0, el.title, el.lyrics))
                    }
                }
                val p = database.PrayersDao().getPrayers()
            } catch (e: UnknownHostException) {
                Log.d("error", e.toString())
            }
            DataHolder.prayers = database.PrayersDao().getPrayers().map { el -> ModlitwyResponse(el.title, el.lyrics) }
        }
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
}