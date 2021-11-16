package com.example.relationaldb

import android.content.Context
import androidx.room.Database
import androidx.room.Room
import androidx.room.RoomDatabase
import com.example.relationaldb.entities.Director
import com.example.relationaldb.entities.Relation.StudentSubjectCrossReference
import com.example.relationaldb.entities.School
import com.example.relationaldb.entities.Student
import com.example.relationaldb.entities.Subject

@Database(entities = [
    School::class,
    Student::class,
    Director::class,
    Subject::class,
    StudentSubjectCrossReference::class], version = 1)
abstract class SchoolDatabase : RoomDatabase() {

    abstract val schoolDao : SchoolDao

    companion object{
        @Volatile
        private var INSTANACE : SchoolDatabase ?= null

        fun getInstance(context: Context) : SchoolDatabase{
            synchronized(this){
                return INSTANACE ?: Room.databaseBuilder(
                        context,
                        SchoolDatabase::class.java,
                        "school_db")
                        .build().also {
                            INSTANACE = it
                }
            }
        }
    }
}