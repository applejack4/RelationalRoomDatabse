package com.example.relationaldb.entities.Relation

import androidx.room.Embedded
import androidx.room.Relation
import com.example.relationaldb.entities.School
import com.example.relationaldb.entities.Student

data class SchoolWithStudents (
    @Embedded val school: School,
    @Relation(parentColumn = "schoolName", entityColumn = "schoolName")
    val studentList : List<Student>)