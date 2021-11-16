package com.example.relationaldb.entities.Relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.relationaldb.entities.Student
import com.example.relationaldb.entities.Subject

data class StudentWithSubjects (
    @Embedded val student: Student,
    @Relation(entityColumn = "subject",
        parentColumn = "studentName",
        associateBy = Junction(StudentSubjectCrossReference::class))
    val subjects : List<Subject>)