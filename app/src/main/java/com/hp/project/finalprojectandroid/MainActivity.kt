package com.hp.project.finalprojectandroid

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.google.firebase.auth.FirebaseUser
import com.hp.project.finalprojectandroid.extensions.isValidEmail
import com.hp.project.finalprojectandroid.extensions.isValidPassword
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    override fun onStart() {
        super.onStart()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val auth = Authentication()
        if (auth.isLogged()) {
            navegarTelaPrincipal()
        }

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
