package com.example.marcosvinicius.demopersistencia.dao

import android.arch.persistence.room.Database
import android.arch.persistence.room.Room
import android.arch.persistence.room.RoomDatabase
import android.content.Context
import com.example.marcosvinicius.demopersistencia.model.Game

@Database(entities = arrayOf(Game::class), version = 1)
abstract class BancoDeDados: RoomDatabase() {

    abstract fun gameDAO():GameDAO

    companion object {
         var INSTACE: BancoDeDados? = null

        fun getDatabase(context: Context): BancoDeDados ?{
            if(INSTACE == null) {
                INSTACE = Room.databaseBuilder(context.applicationContext, BancoDeDados::class.java, "gamesdb").build()
            }

            return INSTACE
        }
    }

}