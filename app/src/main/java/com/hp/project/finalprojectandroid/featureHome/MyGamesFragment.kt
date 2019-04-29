package com.hp.project.finalprojectandroid.featureHome

import android.content.Context
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hp.project.finalprojectandroid.R
import com.hp.project.finalprojectandroid.models.Game
import kotlinx.android.synthetic.main.fragment_meus_games.*

class MyGamesFragment(): Fragment() {

    companion object {

        fun newInstance(): MyGamesFragment {
            val args = Bundle()
            val fragment = MyGamesFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {

        rvGamesList.adapter = MyGamesAdapter(listOf(Game("Resident Evil"),
            Game("Fifa 17"),
            Game("Need For Speed"),
            Game("Naruto"),
            Game("Call of Dutty"),
            Game("Pes 2019"),
            Game("Uncharted 4")),this)
        return inflater.inflate(R.layout.fragment_meus_games, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)


    }
}