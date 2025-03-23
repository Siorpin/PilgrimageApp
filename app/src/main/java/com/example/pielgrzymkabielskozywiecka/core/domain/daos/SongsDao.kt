package com.example.pielgrzymkabielskozywiecka.core.domain.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Songs

@Dao
interface SongsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSong(song: Songs)

    @Query("SELECT id, title, lyrics FROM Songs")
    suspend fun getSong(): List<Songs>

    @Query("DELETE FROM Songs WHERE title = :title AND lyrics = :lyrics")
    suspend fun deleteSong(title: String, lyrics: String)
}