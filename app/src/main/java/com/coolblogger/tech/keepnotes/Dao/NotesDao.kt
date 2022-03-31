package com.coolblogger.tech.keepnotes.Dao

import androidx.lifecycle.LiveData
import androidx.room.*
import com.coolblogger.tech.keepnotes.Models.notes

@Dao
interface NotesDao {

    @Query("SELECT * FROM Notes")
    fun getNotes():LiveData<List<notes>>

    @Query("SELECT * FROM Notes WHERE priority=3 ")
    fun getHighNotes():LiveData<List<notes>>

    @Query("SELECT * FROM Notes WHERE priority=2")
    fun getMediumNotes():LiveData<List<notes>>

    @Query("SELECT * FROM Notes WHERE priority=1")
    fun getLowNotes():LiveData<List<notes>>

    @Insert(onConflict = OnConflictStrategy.REPLACE)
    fun insertNotes(notes: notes)

    @Query("DELETE FROM Notes WHERE id=:id")
    fun deleteNotes(id:Int)

@Update
fun  updateNotes(notes: notes)

}