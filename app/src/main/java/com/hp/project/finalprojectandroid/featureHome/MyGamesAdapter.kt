package com.hp.project.finalprojectandroid.featureHome

import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hp.project.finalprojectandroid.R
import com.hp.project.finalprojectandroid.models.Game
import kotlinx.android.synthetic.main.game_item.view.*

class MyGamesAdapter(var gamesList:List<Game>, val selectedAction:(Game) -> Unit, val removeAction:(Game) -> Unit) :
    RecyclerView.Adapter<MyGamesAdapter.ViewHolder>() {

    fun setList(newList: List<Game>) {
        gamesList = newList

    }

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
       val view = LayoutInflater.from(p0.context).inflate(R.layout.game_item,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gamesList.count()
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val game = gamesList[p1]
        p0.bindView(game, selectedAction, removeAction)
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val title = itemView.tvTitle

        fun bindView(game:Game, selectedAction: (Game) -> Unit, removeAction: (Game) -> Unit) {
            itemView.tvTitle.text = game.titulo
            itemView.setOnClickListener {
                selectedAction(game)

            }
            itemView.btRemove.setOnClickListener {
               removeAction(game)
            }
        }

    }

}