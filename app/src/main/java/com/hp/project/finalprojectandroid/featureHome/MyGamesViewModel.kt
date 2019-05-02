package com.hp.project.finalprojectandroid.featureHome

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import com.hp.project.finalprojectandroid.database.AppDataBase
import com.hp.project.finalprojectandroid.models.Game

class MyGamesViewModel(application: Application) : AndroidViewModel(application) {

    lateinit var games : LiveData<List<Game>>

    private val bd : AppDataBase = AppDataBase.getDatabase(application.applicationContext)!!

    init {
        fetchGames()
    }

    fun fetchGames() {
        games = bd.gameDao().selectGames()
    }

}