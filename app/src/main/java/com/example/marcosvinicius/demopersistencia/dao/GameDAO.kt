package com.example.marcosvinicius.demopersistencia.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.example.marcosvinicius.demopersistencia.model.Game

@Dao
interface GameDAO {

    @Insert
    fun inserir(game: Game)

    @Delete
    fun apagar(game: Game)

    @Update
    fun atualizar(game: Game)

    @Query("SELECT * FROM Game")
    fun lerGames() : LiveData<List<Game>>

    @Query("SELECT * FROM Game WHERE id = :id")
    fun buscarPorId(id: Int): Game
}