package com.hp.project.finalprojectandroid.models

import android.arch.persistence.room.Entity
import android.arch.persistence.room.PrimaryKey

@Entity
class Game() {

    @PrimaryKey(autoGenerate = true)
    var id: Long = 0
    var titulo: String = ""
    var descricao: String = ""

    constructor(titulo: String, descricao: String) : this() {
        this.titulo = titulo
        this.descricao = descricao
    }

}