package com.example.pielgrzymkabielskozywiecka.core.data.database

import androidx.room.Database
import androidx.room.RoomDatabase
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Prayers
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Announcements
import com.example.pielgrzymkabielskozywiecka.core.data.database.tables.Songs
import com.example.pielgrzymkabielskozywiecka.core.domain.daos.AnnouncementsDao
import com.example.pielgrzymkabielskozywiecka.core.domain.daos.PrayersDao
import com.example.pielgrzymkabielskozywiecka.core.domain.daos.SongsDao

@Database(entities = [Prayers::class, Announcements::class, Songs::class], version = 1)
abstract class Database: RoomDatabase() {
    abstract fun PrayersDao(): PrayersDao
    abstract fun AnnouncementsDao(): AnnouncementsDao
    abstract fun SongsDao(): SongsDao
}