package com.hp.project.finalprojectandroid.featureSobre

import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.hp.project.finalprojectandroid.R
import kotlinx.android.synthetic.main.fragment_about_app.*
import java.net.URI


class AboutAppFragment : Fragment() {

    companion object {

        fun newInstance(): AboutAppFragment {
            val args = Bundle()
            val fragment = AboutAppFragment()
            fragment.arguments = args
            return fragment
        }
    }

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?, savedInstanceState: Bundle?): View? {


        return inflater.inflate(R.layout.fragment_about_app, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        activity?.let {
            val context = it.application.applicationContext
           it.application.applicationContext.packageName
            val pInfo = context.packageManager.getPackageInfo(context.packageName,0)
            val version = pInfo.versionName
            tvVersion.setText("Versao: "+version)
        }

        btLigar.setOnClickListener {
            val tel = "01155879654"
            val intent = Intent(Intent.ACTION_DIAL, Uri.parse("tel:$tel"))
            startActivity(intent)
        }

    }


}
