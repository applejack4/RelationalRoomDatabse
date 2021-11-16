package com.example.relationaldb

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.lifecycle.lifecycleScope
import com.example.relationaldb.entities.Director
import com.example.relationaldb.entities.Relation.StudentSubjectCrossReference
import com.example.relationaldb.entities.School
import com.example.relationaldb.entities.Student
import com.example.relationaldb.entities.Subject
import kotlinx.coroutines.launch

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val dao = SchoolDatabase.getInstance(this).schoolDao

        val directors = listOf(
                Director("Mike Litoris", "Jake Wharton School"),
                Director("Jack Goff", "Kotlin School"),
                Director("Chris P. Chicken", "JetBrains School")
        )
        val schools = listOf(
                School("Jake Wharton School"),
                School("Kotlin School"),
                School("JetBrains School")
        )
        val subjects = listOf(
                Subject("Dating for programmers"),
                Subject("Avoiding depression"),
                Subject("Bug Fix Meditation"),
                Subject("Logcat for Newbies"),
                Subject("How to use Google")
        )
        val students = listOf(
                Student("Beff Jezos", 2, "Kotlin School"),
                Student("Mark Suckerberg", 5, "Jake Wharton School"),
                Student("Gill Bates", 8, "Kotlin School"),
                Student("Donny Jepp", 1, "Kotlin School"),
                Student("Hom Tanks", 2, "JetBrains School")
        )
        val studentSubjectRelations = listOf(
                StudentSubjectCrossReference("Beff Jezos", "Dating for programmers"),
                StudentSubjectCrossReference("Beff Jezos", "Avoiding depression"),
                StudentSubjectCrossReference("Beff Jezos", "Bug Fix Meditation"),
                StudentSubjectCrossReference("Beff Jezos", "Logcat for Newbies"),
                StudentSubjectCrossReference("Mark Suckerberg", "Dating for programmers"),
                StudentSubjectCrossReference("Gill Bates", "How to use Google"),
                StudentSubjectCrossReference("Donny Jepp", "Logcat for Newbies"),
                StudentSubjectCrossReference("Hom Tanks", "Avoiding depression"),
                StudentSubjectCrossReference("Hom Tanks", "Dating for programmers")
        )
        lifecycleScope.launch {
            directors.forEach { dao.insertDirector(it) }
            schools.forEach { dao.insertSchool(it) }
            subjects.forEach { dao.insertSubject(it) }
            students.forEach { dao.insertStudents(it) }
            studentSubjectRelations.forEach { dao.insertStudentSubjectCrossRef(it) }

            val schoolWithDirector = dao.getSchoolAndDirectorWithSchoolNames("Kotlin School")

            val schoolWithStudents = dao.getStudentsWithSchoolName("Kotlin School")
        }
    }
}