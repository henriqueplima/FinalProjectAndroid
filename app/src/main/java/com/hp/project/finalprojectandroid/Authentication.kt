package com.hp.project.finalprojectandroid

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

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


}