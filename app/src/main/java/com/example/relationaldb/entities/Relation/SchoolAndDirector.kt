package com.example.relationaldb.entities.Relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.relationaldb.entities.Director
import com.example.relationaldb.entities.School


data class SchoolAndDirector (
    @Embedded val school : School,
    @Relation(parentColumn = "schoolName", entityColumn = "schoolName")
    val director : Director
)