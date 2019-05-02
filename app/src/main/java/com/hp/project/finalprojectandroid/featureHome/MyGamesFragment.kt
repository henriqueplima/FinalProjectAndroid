package com.hp.project.finalprojectandroid.featureHome


import android.arch.lifecycle.Observer
import android.arch.lifecycle.ViewModelProviders
import android.os.Bundle
import android.support.v4.app.Fragment
import android.support.v7.widget.LinearLayoutManager
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hp.project.finalprojectandroid.R
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

            adapter = MyGamesAdapter(games)
            rvGamesList.adapter = adapter

//            rvGamesList.adapter = MyGamesAdapter(listOf())


//            rvGamesList.adapter = MyGamesAdapter(listOf(
//                Game("Resident Evil", "T"),
//                Game("Fifa 17","t"),
//                Game("Need For Speed","t"),
//                Game("Naruto","t"),
//                Game("Call of Dutty","t"),
//                Game("Pes 2019","t"),
//                Game("Uncharted 4","t")
//            ))
            rvGamesList.layoutManager = LinearLayoutManager(it)

//            val bd : AppDataBase = AppDataBase.getDatabase(it.applicationContext)!!
//
//
//           val gameLiveData = bd.gameDao().selectGames()
//            gameLiveData.observe(it, Observer { games ->
//                games?.let {
//                    adapter?.setList(games)
//                    rvGamesList.adapter?.notifyDataSetChanged()
//                }
//            })



            ViewModelProviders.of(it)
                .get(MyGamesViewModel::class.java)
            .games
            .observe(it, Observer<List<Game>> { games ->
                adapter?.setList(games!!)
                rvGamesList.adapter?.notifyDataSetChanged()
            })


        }


    }
}