package com.hp.project.finalprojectandroid.models.vo

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class GameVO(
    var id: Long,
    var titulo: String,
    var descricao: String
) : Parcelable