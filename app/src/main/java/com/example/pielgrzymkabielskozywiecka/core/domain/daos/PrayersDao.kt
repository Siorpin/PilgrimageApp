package com.example.pielgrzymkabielskozywiecka.core.domain.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Prayers

@Dao
interface PrayersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSong(prayer: Prayers)

    @Query("SELECT title, lyrics FROM Prayers")
    suspend fun getPrayers(): Prayers
}