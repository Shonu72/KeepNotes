package com.coolblogger.tech.keepnotes.ViewModels

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import com.coolblogger.tech.keepnotes.Database.NotesDatabase
import com.coolblogger.tech.keepnotes.Models.notes
import com.coolblogger.tech.keepnotes.Repository.NotesRepository

class NotesViewModel(application: Application) : AndroidViewModel(application) {

    val repository : NotesRepository

    init{
        val dao = NotesDatabase.getDatabaseInstance(application).myNotesDao()
        repository = NotesRepository(dao)
    }

    fun addNotes(notes:notes){
        repository.insertNOtes(notes)
    }

    fun getNotes():LiveData<List<notes>> = repository.getAllNotes()
    fun getLowNotes(): LiveData<List<notes>> =  repository.getLowNotes()
    fun getMediumNotes(): LiveData<List<notes>> =  repository.getMediumNotes()
    fun getHighNotes(): LiveData<List<notes>> =  repository.getHighNotes()

    fun deleteNotes(id:Int ){
        repository.deleteNotes(id)
    }

    fun updateNotes(notes: notes){
        repository.updateNotes(notes)
    }


}