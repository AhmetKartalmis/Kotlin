package com.ahmetkartal.hiltkullanimi

import android.util.Log
import javax.inject.Inject

class Internet @Inject constructor(var adres: Adres) {
    fun basvur(){
        Log.e("Sonuc","${adres.adres} için başvuru yapıldı")
    }
}