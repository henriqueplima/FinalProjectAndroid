package com.hp.project.finalprojectandroid.mappers

import com.hp.project.finalprojectandroid.models.Game
import com.hp.project.finalprojectandroid.models.vo.GameVO

object GameMapper {

    fun mapToViewObject(game: Game): GameVO {
        return GameVO(id = game.id, titulo = game.titulo, descricao = game.descricao)
    }

    fun mapToRoomObject(gameVO: GameVO): Game {
        var game  = Game(gameVO.titulo, gameVO.descricao)
        game.id = gameVO.id
        return game
    }
}