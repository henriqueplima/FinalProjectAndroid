package com.hp.project.finalprojectandroid.featureHome

import android.content.Context
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hp.project.finalprojectandroid.R
import com.hp.project.finalprojectandroid.models.Game
import kotlinx.android.synthetic.main.game_item.view.*

class MyGamesAdapter(val gamesList:List<Game>,
                     val context: Context) :
    RecyclerView.Adapter<MyGamesAdapter.ViewHolder>() {

    override fun onCreateViewHolder(p0: ViewGroup, p1: Int): ViewHolder {
       val view = LayoutInflater.from(context).inflate(R.layout.game_item,p0,false)
        return ViewHolder(view)
    }

    override fun getItemCount(): Int {
        return gamesList.count()
    }

    override fun onBindViewHolder(p0: ViewHolder, p1: Int) {
        val game = gamesList[p1]
        p0.bindView(game)
    }

    class ViewHolder(itemView:View):RecyclerView.ViewHolder(itemView){
        val title = itemView.tvTitle

        fun bindView(game:Game) {
            itemView.tvTitle.text = game.titulo
            itemView.setOnClickListener {
                Log.e("meu log",game.titulo)
            }
        }

    }

}