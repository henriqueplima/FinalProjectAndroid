package com.hp.project.finalprojectandroid.extensions

fun String.isValidEmail():Boolean {

    var emailPattern = "[a-zA-Z0-9._-]+@[a-z]+\\.+[a-z]+"
    if (this.matches(emailPattern.toRegex())) {
        return true
    }

    return false

}

fun String.isValidPassword(): Boolean {

    if (this.length >= 6 ) {
        return true
    }

    return false

}

