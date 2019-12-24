package com.example.bdt

import android.app.Application
import androidx.lifecycle.LiveData

class bdRepository (private val bddao: bddao){

    val alldb : LiveData<List<DB>> = bddao.getAllBD()

    suspend fun insertBD(bd:DB){
        bddao.insertDB(bd)
    }
}