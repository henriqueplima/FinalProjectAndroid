package com.hp.project.finalprojectandroid.featureCadastroGames

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import com.hp.project.finalprojectandroid.R
import com.hp.project.finalprojectandroid.featureHome.MyGamesViewModel
import com.hp.project.finalprojectandroid.mappers.GameMapper
import com.hp.project.finalprojectandroid.models.Game
import com.hp.project.finalprojectandroid.models.vo.GameVO
import kotlinx.android.synthetic.main.activity_cadastro_game.*

class CadastroGameActivity : AppCompatActivity() {

    var isNewGame : Boolean = true

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro_game)

        var game = intent?.extras?.getParcelable<GameVO>("game")
        game?.let {
            isNewGame = false
            tvTitulo.setText(game.titulo)
            tvDescricao.setText(game.descricao)
        }

        btCadastrar.setOnClickListener {

            val title = tvTitulo.text.toString()
            val gameDescription = tvDescricao.text.toString()

            if (isNewGame) {
                val newGame = Game(title,gameDescription)
                MyGamesViewModel(this.application).insertGame(newGame)
            } else {
                game?.titulo = title
                game?.descricao = gameDescription
                val newGame = GameMapper.mapToRoomObject(game!!)
                MyGamesViewModel(this.application).updateGame(newGame)
            }

        }
    }
}
