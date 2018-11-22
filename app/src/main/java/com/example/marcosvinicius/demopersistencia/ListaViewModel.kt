package com.example.marcosvinicius.demopersistencia

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.arch.lifecycle.ViewModel
import com.example.marcosvinicius.demopersistencia.dao.BancoDeDados
import com.example.marcosvinicius.demopersistencia.model.Game

class ListaViewModel(appication: Application): AndroidViewModel(appication) {

    private val bd = BancoDeDados.getDatabase(appication.applicationContext)
    var games: LiveData<List<Game>>? = null

    fun carregarGame(){
        games = bd?.gameDAO()?.lerGames()
    }

}