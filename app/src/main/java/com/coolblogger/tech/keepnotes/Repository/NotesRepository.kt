package com.coolblogger.tech.keepnotes.Repository

import androidx.lifecycle.LiveData
import com.coolblogger.tech.keepnotes.Dao.NotesDao
import com.coolblogger.tech.keepnotes.Models.notes

class NotesRepository(val dao: NotesDao) {

    fun getAllNotes(): LiveData<List<notes>> =  dao.getNotes()
    fun getLowNotes(): LiveData<List<notes>> =  dao.getLowNotes()
    fun getMediumNotes(): LiveData<List<notes>> =  dao.getMediumNotes()
    fun getHighNotes(): LiveData<List<notes>> =  dao.getHighNotes()


    fun insertNOtes(notes: notes){
        dao.insertNotes(notes)
    }

    fun deleteNotes(id:Int){
        dao.deleteNotes(id)
    }

    fun updateNotes(notes: notes){
        dao.updateNotes(notes)
    }
}