package com.hp.project.finalprojectandroid

import com.google.firebase.auth.FirebaseAuth
import com.google.firebase.auth.FirebaseUser

class Authentication() {

    private val mAuth: FirebaseAuth = FirebaseAuth.getInstance()

    fun getCurrenteUser(): FirebaseUser?{
        return mAuth.currentUser

    }


}