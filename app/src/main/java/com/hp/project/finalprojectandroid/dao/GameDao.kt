package com.hp.project.finalprojectandroid.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.*
import com.hp.project.finalprojectandroid.models.Game

@Dao
interface GameDao {

    @Insert
    fun insertGames(game: Game)

    @Query("SELECT * FROM Game")
    fun selectGames():LiveData<List<Game>>

    @Update
    fun updateGame(game: Game)

    @Delete
    fun remove(game:Game)


}