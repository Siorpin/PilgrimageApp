package com.example.pielgrzymkabielskozywiecka.core.domain.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Prayers

@Dao
interface PrayersDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertPrayer(prayer: Prayers)

    @Query("SELECT id, title, lyrics FROM Prayers")
    suspend fun getPrayers(): List<Prayers>

    @Query("DELETE FROM Prayers WHERE title = :title AND lyrics = :lyrics")
    suspend fun deletePrayers(title: String, lyrics: String)
}