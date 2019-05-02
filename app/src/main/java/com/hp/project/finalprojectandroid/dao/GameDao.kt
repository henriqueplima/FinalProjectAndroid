package com.hp.project.finalprojectandroid.dao

import android.arch.lifecycle.LiveData
import android.arch.persistence.room.Dao
import android.arch.persistence.room.Insert
import android.arch.persistence.room.Query
import android.arch.persistence.room.Update
import com.hp.project.finalprojectandroid.models.Game

@Dao
interface GameDao {

    @Insert
    fun insertGames(game: Game)

    @Query("SELECT * FROM Game")
    fun selectGames():LiveData<List<Game>>

    @Update
    fun updateGame(game: Game)


}