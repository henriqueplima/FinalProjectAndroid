package com.hp.project.finalprojectandroid.featureHome

import android.app.Application
import android.arch.lifecycle.AndroidViewModel
import android.arch.lifecycle.LiveData
import android.os.AsyncTask
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

    fun insertGame(game: Game) {

        InsertAsyncTaskAdd().execute(game)

    }

    fun updateGame(game:Game) {
        InsertAsyncTaskUpdate().execute(game)
    }

    fun deleteGames(game:Game) {
        DeleteAsyncTaskUpdate().execute(game)
    }

    private inner class DeleteAsyncTaskUpdate : AsyncTask<Game, Void, String>() {

        override fun doInBackground(vararg params: Game): String {
            bd.gameDao().remove(params[0])
            return ""
        }
    }

    private inner class InsertAsyncTaskUpdate : AsyncTask<Game, Void, String>() {

        override fun doInBackground(vararg params: Game): String {
            bd.gameDao().updateGame(params[0])
            return ""
        }
    }



    private inner class InsertAsyncTaskAdd : AsyncTask<Game, Void, String>() {

        override fun doInBackground(vararg params: Game): String {
            bd.gameDao().insertGames(params[0])
            return ""
        }
    }

}