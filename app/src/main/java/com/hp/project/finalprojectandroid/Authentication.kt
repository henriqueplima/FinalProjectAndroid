package com.hp.project.finalprojectandroid

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser
import com.google.firebase.database.FirebaseDatabase
import com.hp.project.finalprojectandroid.models.Usuario

class Authentication() {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun getCurrenteUser(): FirebaseUser?{
        return mAuth.currentUser
    }

    fun isLogged():Boolean {
        if (mAuth.currentUser != null) {
            return  true
        }

        return false
    }

    fun doAuthentication(email:String, senha:String, callBackSucesso:() -> Unit, callbackFalha:(String) -> Unit) {

        mAuth.signInWithEmailAndPassword(email,senha).addOnCompleteListener{

            if (it.isSuccessful) {
                callBackSucesso()

            } else {

                var mensagem = R.string.mensagemErroLogin.toString()
                it.exception?.message?.let {
                   mensagem = it
                }

                callbackFalha(mensagem)

            }

        }

    }

    fun createUser(email:String, senha:String, nome:String, sobrenome:String, callBackSucesso: (Usuario) -> Unit, callbackFalha:(String) -> Unit) {

        mAuth.createUserWithEmailAndPassword(email,senha).addOnCompleteListener {
            if (it.isSuccessful) {
                var user = Usuario(nome,  sobrenome, email)
                saveUserData(user, callBackSucesso,callbackFalha)
            }else {
                print(it.exception?.message)
                callbackFalha("Falha na autenticacao")
            }
        }

    }

    fun saveUserData(usuario: Usuario, callBackSucesso: (Usuario) -> Unit, callbackFalha:(String) -> Unit) {

        FirebaseDatabase.getInstance().getReference("Users")
            .child(FirebaseAuth.getInstance().currentUser!!.uid)
            .setValue(usuario)
            .addOnCompleteListener {
                if (it.isSuccessful) {
                    callBackSucesso(usuario)
                } else {
                    print(it.exception?.message)
                    callbackFalha("erro ao criar usuario")
                }
            }

    }


}