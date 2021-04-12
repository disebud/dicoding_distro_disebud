package com.disebud.disebuddistro.model

import android.os.Parcelable
import kotlinx.android.parcel.Parcelize

@Parcelize
data class DistroModel (
    var id: String ?="",
    var judul: String ?="",
    var desc: String ?="",
    var price: String ?="",
    var thumbnail_potrait: Int ?=0,
    var thumbnail_landscape: Int ?=0,
    var rating: Float
): Parcelable