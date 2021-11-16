package com.example.relationaldb.entities

import androidx.room.Entity
import androidx.room.PrimaryKey

@Entity
class School(
    @PrimaryKey(autoGenerate = false)
    private val schoolName : String
)