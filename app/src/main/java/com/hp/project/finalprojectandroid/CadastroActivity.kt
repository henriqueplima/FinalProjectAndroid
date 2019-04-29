package com.hp.project.finalprojectandroid

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.Toast
import com.hp.project.finalprojectandroid.extensions.isValidEmail
import com.hp.project.finalprojectandroid.extensions.isValidPassword
import kotlinx.android.synthetic.main.activity_cadastro.*

class CadastroActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_cadastro)

        btCadastrar.setOnClickListener {

            val email = etEmail.text.toString().trim()
            val senha = etSenha.text.toString().trim()
            val nome = etNome.text.toString().trim()
            val sobrenome = etSobrenome.text.toString()

            if (email.isValidEmail() && senha.isValidPassword() && nome.length > 0 && sobrenome.length > 0) {
                var auth = Authentication()
                auth.createUser(email, senha, nome, sobrenome, {
                    exibirAlerta("usuario criado com sucesso")
                    finish()
                },{
                    exibirAlerta(it)
                })
            }

        }

    }

    fun exibirAlerta(mensagem:String) {
        Toast.makeText(this,mensagem, Toast.LENGTH_SHORT).show()
    }
}
