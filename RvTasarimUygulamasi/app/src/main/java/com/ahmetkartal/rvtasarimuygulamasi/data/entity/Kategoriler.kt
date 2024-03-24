package com.ahmetkartal.rvtasarimuygulamasi.data.entity

import java.io.Serializable

data class Kategoriler(var id:Int,
                       var kategori:String,
                       var aciklama:String,
                       var resim:String,) : Serializable {
}