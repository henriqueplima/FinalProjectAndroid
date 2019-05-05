package com.hp.project.finalprojectandroid.featureHome


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hp.project.finalprojectandroid.R
import com.hp.project.finalprojectandroid.featureCadastroGames.CadastroGameActivity
import com.hp.project.finalprojectandroid.mappers.GameMapper
import com.hp.project.finalprojectandroid.models.Game
import kotlinx.android.synthetic.main.fragment_meus_games.*

class MyGamesFragment: Fragment() {

    private var  adapter: MyGamesAdapter? = null
    private var games : List<Game> = listOf()

    companion object {

        fun newInstance(): MyGamesFragment {
            val args = Bundle()
            val fragment = MyGamesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_meus_games, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {

            adapter = MyGamesAdapter(games, { gameSelected ->
                navigationToAddGameActivity(it, gameSelected)
            }, {
                val appli = this.activity!!.application
                MyGamesViewModel(appli).deleteGames(it)
            })
            rvGamesList.adapter = adapter

            rvGamesList.layoutManager = LinearLayoutManager(it)


            btnAdicionar.setOnClickListener { view ->
                navigationToAddGameActivity(it, null)
            }

            ViewModelProviders.of(it)
                .get(MyGamesViewModel::class.java)
            .games
            .observe(it, Observer<List<Game>> { games ->
                adapter?.setList(games!!)
                rvGamesList.adapter?.notifyDataSetChanged()
            })


        }


    }

    fun navigationToAddGameActivity(context: Context, game: Game?) {
        val intent = Intent(context, CadastroGameActivity::class.java)
        game?.let {
            intent.putExtra("game", GameMapper.mapToViewObject(it))
        }
        startActivity(intent)
    }

}