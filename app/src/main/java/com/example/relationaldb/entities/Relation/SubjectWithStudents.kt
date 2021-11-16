package com.example.relationaldb.entities.Relation

import androidx.room.Embedded
import androidx.room.Junction
import androidx.room.Relation
import com.example.relationaldb.entities.Student
import com.example.relationaldb.entities.Subject

data class SubjectWithStudents(
    @Embedded val subject: Subject,
    @Relation(parentColumn = "subject",
        entityColumn = "schoolName",
        associateBy = Junction(StudentSubjectCrossReference::class)) val students : List<Student>
)