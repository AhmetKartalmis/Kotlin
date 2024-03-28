package com.ahmetkartal.mvvmkullanimi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatemakitRepository {
    var mds = MatematikDataSource()

    suspend fun toplama(alinan1:String,alinan2:String) : String = mds.toplama(alinan1,alinan2)
    suspend fun carpma(alinan1:String,alinan2:String) : String = mds.carpma(alinan1,alinan2)
}


