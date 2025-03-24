package com.example.pielgrzymkabielskozywiecka.core.domain.daos

import androidx.room.Dao
import androidx.room.Insert
import androidx.room.OnConflictStrategy
import androidx.room.Query
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Announcements

@Dao
interface AnnouncementsDao {
    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertAnnouncement(annoucement: Announcements)

    @Query("SELECT id, title, text FROM Announcements")
    suspend fun getAnnouncements(): List<Announcements>

    @Query("DELETE FROM Announcements")
    suspend fun deleteAnnouncements()
}