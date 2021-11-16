package com.example.relationaldb

import androidx.room.*
import com.example.relationaldb.entities.Director
import com.example.relationaldb.entities.Relation.*
import com.example.relationaldb.entities.School
import com.example.relationaldb.entities.Student
import com.example.relationaldb.entities.Subject

@Dao
interface SchoolDao {

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSchool(school: School)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertDirector(director: Director)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudents(student: Student)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertSubject(subject: Subject)

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    suspend fun insertStudentSubjectCrossRef(crossReference : StudentSubjectCrossReference)

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getSchoolAndDirectorWithSchoolNames(schoolName : String) : List<SchoolAndDirector>

    @Transaction
    @Query("SELECT * FROM school WHERE schoolName = :schoolName")
    suspend fun getStudentsWithSchoolName(schoolName : String) : List<SchoolWithStudents>

    @Transaction
    @Query("SELECT * FROM subject WHERE subject = :subjectName")
    suspend fun getStudentsWithSubjectName(subjectName : String) : List<StudentWithSubjects>

    @Transaction
    @Query("SELECT * FROM student WHERE studentName = :studName")
    suspend fun getSubjectWithStudentName(studName : String) : List<SubjectWithStudents>
}