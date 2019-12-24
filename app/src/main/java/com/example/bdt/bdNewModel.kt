package com.example.bdt

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.LiveData
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.launch

class bdNewModel(application: Application) : AndroidViewModel(application) {

    private val bdRepository: bdRepository
    val allDB: LiveData<List<DB>>

    init {
        val bddao = bdDatabase.getInstance(application).bdDao()
        bdRepository = bdRepository(bddao)
        allDB = bdRepository.alldb
    }
    fun insertBD(db: DB) = viewModelScope.launch {
        bdRepository.insertBD((db))
    }
}