package com.example.bdt

import androidx.lifecycle.LiveData
import androidx.room.*

@Dao
interface bddao {
    @Insert
     suspend fun insertDB(db: DB)

    @Query("SELECT * FROM birthday")
      fun  getAllBD(): LiveData<List<DB>>

    @Query( "SELECT * FROM birthday WHERE id = :ID")
      fun  getABD(ID:Int):DB

    @Update
    suspend fun updatebd(bd:DB)

    @Delete
    suspend fun deletebd(bd:DB)

}