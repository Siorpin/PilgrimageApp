package com.example.pielgrzymkabielskozywiecka.core.data.database.tables

import androidx.room.Entity
import androidx.room.PrimaryKey
import com.google.gson.annotations.SerializedName

@Entity(tableName = "Songs")
data class Songs(
    @PrimaryKey(autoGenerate = true)
    @SerializedName("id") val id: Int,
    @SerializedName("title") val title: String,
    @SerializedName("lyrics") val lyrics: String
)
