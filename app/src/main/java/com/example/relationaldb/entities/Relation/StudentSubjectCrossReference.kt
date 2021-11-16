package com.example.relationaldb.entities.Relation

import androidx.room.Entity

@Entity(primaryKeys = ["studentName" , "subject"])
data class StudentSubjectCrossReference (
    val studentName : String,
    val subjectName : String
        )