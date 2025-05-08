package com.example.pielgrzymkabielskozywiecka.core.domain.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Conferences

@Dao
interface ConferencesDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertConference(conference: Conferences)

    @Query("SELECT id, title, text FROM Conferences")
    suspend fun getConference(): List<Conferences>

    @Query("DELETE FROM Conferences WHERE title = :title AND text = :text")
    suspend fun deleteConference(title: String, text: String)
}