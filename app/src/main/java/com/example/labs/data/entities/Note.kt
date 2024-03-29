package com.example.labs.data.entities

import android.os.Parcelable
import androidx.annotation.NonNull
import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import kotlinx.parcelize.Parcelize
import java.util.Date

@Parcelize
@Entity(tableName = "notes")
data class Note(
    @PrimaryKey(autoGenerate = true) var id: Int = 0,
    @NonNull @ColumnInfo(name = "title") var title: String = "",
    @NonNull @ColumnInfo(name = "description") var description: String ="",
    @NonNull @ColumnInfo(name = "data") var data: Date = Date()
) : Parcelable