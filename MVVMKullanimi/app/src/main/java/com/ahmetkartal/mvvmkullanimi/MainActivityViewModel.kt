package com.ahmetkartal.mvvmkullanimi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {
    var sonuc = MutableLiveData("0")
    var mRepo = MatemakitRepository()
    fun toplama(alinan1:String,alinan2:String){
        CoroutineScope(Dispatchers.Main).launch{
            sonuc.value=mRepo.toplama(alinan1,alinan2)
        }
    }
    fun carpma(alinan1:String,alinan2:String){
        CoroutineScope(Dispatchers.Main).launch {
            sonuc.value=mRepo.carpma(alinan1,alinan2)
        }

    }



}