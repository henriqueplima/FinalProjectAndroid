package com.hp.project.finalprojectandroid

import android.content.Intent
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.Toast
import com.google.firebase.iid.FirebaseInstanceId
import com.hp.project.finalprojectandroid.api.Api
import com.hp.project.finalprojectandroid.api.RetrofitBuilder
import com.hp.project.finalprojectandroid.extensions.isValidEmail
import com.hp.project.finalprojectandroid.extensions.isValidPassword
import com.hp.project.finalprojectandroid.featureHome.HomeActivity
import com.hp.project.finalprojectandroid.models.LucaoResponse
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainActivity : AppCompatActivity() {

    val auth = Authentication()

    override fun onResume() {
        super.onResume()

        if (auth.isLogged()) {
            navegarTelaPrincipal()
        }


//        val api = RetrofitBuilder.createRetrofit().create(Api::class.java)
//
//        api.buscarApiLucao().enqueue(object: Callback<LucaoResponse> {
//
//
//            override fun onFailure(call: Call<LucaoResponse>, t: Throwable) {
//                Log.e("TAG", "deu ruim", t)
//            }
//
//            override fun onResponse(call: Call<LucaoResponse>, response: Response<LucaoResponse>) {
//                Log.e("TAG", response.body().toString())
//            }
//
//        })
    }

    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnAcessar.setOnClickListener {

            val email = etEmail.text.toString().trim()
            val senha = etSenha.text.toString().trim()

            if (email.isValidEmail() && senha.isValidPassword()) {

                auth.doAuthentication(email,senha,{
                    navegarTelaPrincipal()
                },{
                    falhouAutenticao(it)
                })

            }else {
                Toast.makeText(this,"Email ou senha inválido",Toast.LENGTH_LONG).show()
            }


        }


        btnCadastrar.setOnClickListener {
            val intent = Intent(this, CadastroActivity::class.java)
            startActivity(intent)
        }

        var token = FirebaseInstanceId.getInstance().token
        Log.d("teste","Token : "+token)
        var bodyMessage= intent.getStringExtra("Notification")
        if(bodyMessage != null){
            Log.d("teste","foi")
        }
    }

    fun falhouAutenticao(mensagem:String) {
        Toast.makeText(this,mensagem,Toast.LENGTH_SHORT).show()
    }

    fun navegarTelaPrincipal() {
        val intent = Intent(this, HomeActivity::class.java)
        startActivity(intent)
        finish()
    }


}
