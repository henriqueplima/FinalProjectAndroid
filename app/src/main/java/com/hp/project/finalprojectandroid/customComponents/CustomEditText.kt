package com.hp.project.finalprojectandroid.customComponents

import android.content.Context
import android.util.AttributeSet
import android.widget.EditText

enum class CustomTypeEditText {
    DEFAULT, EMAIL, SENHA
}

class CustomEditText  : EditText  {

    constructor(context: Context, attrs: AttributeSet? = null) : super(context, attrs) {
        this.init(context, attrs, 0)
    }

    constructor(context: Context, attrs: AttributeSet, defStyleAttr: Int) : super(context, attrs, defStyleAttr) {
        this.init(context, attrs, defStyleAttr)
    }


    private fun init(context: Context, attrs: AttributeSet?, defStyleAttr: Int) {


    }

    var tipo = CustomTypeEditText.DEFAULT



}