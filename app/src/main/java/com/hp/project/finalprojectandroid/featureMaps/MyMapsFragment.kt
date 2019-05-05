package com.hp.project.finalprojectandroid.featureMaps

import android.Manifest
import android.content.Context
import android.content.Intent
import android.net.Uri
import android.os.Bundle
import android.support.v4.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.google.android.gms.maps.CameraUpdateFactory
import com.google.android.gms.maps.GoogleMap
import com.google.android.gms.maps.OnMapReadyCallback
import com.google.android.gms.maps.SupportMapFragment
import com.google.android.gms.maps.model.LatLng
import com.google.android.gms.maps.model.MarkerOptions

import com.hp.project.finalprojectandroid.R
import com.hp.project.finalprojectandroid.utils.PermissionUtils
import kotlinx.android.synthetic.main.fragment_my_maps.*



class MyMapsFragment : Fragment(), OnMapReadyCallback {

    private lateinit var mMap:GoogleMap

    companion object {

        fun newInstance(): MyMapsFragment {
            val args = Bundle()
            val fragment = MyMapsFragment()
            fragment.arguments = args
            return fragment
        }
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_my_maps, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        btOpenMaps.setOnClickListener {
            val query = "games"
            val geo = "geo:0,0?q=$query"
            exibirNoMapa(geo)
        }


        activity?.supportFragmentManager?.let {

            PermissionUtils.validarPermissoes(
                listOf(Manifest.permission.ACCESS_FINE_LOCATION),
                activity!!, 1
            )

            val mapFragment = it.findFragmentById(R.id.map) as SupportMapFragment?
                mapFragment?.getMapAsync(this)
        }
        //= activity?.supportFragmentManager?.findFragmentById(R.id.map) as SupportMapFragment
       // mapFragment.getMapAsync(this)
    }

    fun exibirNoMapa(geo: String){
        val geoURI = Uri.parse(geo)
        val intent = Intent(Intent.ACTION_VIEW, geoURI)
        intent.setPackage("com.google.android.apps.maps")
        startActivity(intent)
    }


    override fun onMapReady(googleMap: GoogleMap?) {
        googleMap?.let {
            mMap = it
            val teste = LatLng(-23.5606927,-46.6588602)
            mMap.addMarker(MarkerOptions().position(teste).title("Testando essa posicao"))
            mMap.moveCamera(CameraUpdateFactory.newLatLng(teste))
        }
    }


}
