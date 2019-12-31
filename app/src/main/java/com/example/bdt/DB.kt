package com.example.bdt

import androidx.room.ColumnInfo
import androidx.room.Entity
import androidx.room.PrimaryKey
import java.util.*

@Entity(tableName = "birthday")
data class DB (
    @PrimaryKey(autoGenerate = true) val id: Int,
    @ColumnInfo(name = "name")
    val name:String,
    @ColumnInfo(name = "dob")
    val dob: Long

)