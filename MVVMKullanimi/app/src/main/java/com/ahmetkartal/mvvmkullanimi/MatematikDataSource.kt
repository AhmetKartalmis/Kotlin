package com.ahmetkartal.mvvmkullanimi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatematikDataSource {
    suspend fun toplama(alinan1:String,alinan2:String) : String= withContext(Dispatchers.IO){
            val sayi1 = alinan1.toInt()
            val sayi2 = alinan2.toInt()
            val toplam = sayi1 + sayi2
            return@withContext toplam.toString()
    }
    suspend fun carpma(alinan1:String,alinan2:String) : String= withContext(Dispatchers.IO){
        val sayi1 = alinan1.toInt()
        val sayi2 = alinan2.toInt()
        val toplam = sayi1 * sayi2
        return@withContext toplam.toString()
    }



}