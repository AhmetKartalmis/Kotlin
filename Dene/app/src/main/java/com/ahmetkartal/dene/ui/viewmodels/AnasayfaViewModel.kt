package com.ahmetkartal.dene.ui.viewmodels

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.ahmetkartal.dene.data.entity.Article
import com.ahmetkartal.dene.data.entity.ArticleModel
import com.ahmetkartal.dene.retrofit.ArticleAPI
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory


class AnasayfaViewModel(BASE_URL: String):ViewModel() {
    init {
        dataYukle(BASE_URL)
    }
    var haberListesi = MutableLiveData<ArrayList<Article>>()
    fun dataYukle(BASE_URL : String){
        //datanın çekilmesi
         val retrofit = Retrofit.Builder()
             .baseUrl(BASE_URL)
             .addConverterFactory(GsonConverterFactory.create())
             .build()

         val service = retrofit.create(ArticleAPI::class.java)
         val call = service.getData()
         call.enqueue(object : Callback<ArticleModel> {
             override fun onResponse(call: Call<ArticleModel>, response: Response<ArticleModel>) {
                 if (response.isSuccessful) {
                     response.body()?.let {
                         haberListesi.value = ArrayList(it.articles)

                     }
                 }
             }
             override fun onFailure(call: Call<ArticleModel>, t: Throwable) {
                 t.printStackTrace()
             }
         })
     }
    fun aramaYap(serach:String){
        val retrofit = Retrofit.Builder()
            .baseUrl("https://newsapi.org/v2/")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val service = retrofit.create(ArticleAPI::class.java)

        val call = service.getSearchData(serach, 2, "0a55fe607c5f4d72ad63413ca61c50af")
        call.enqueue(object : Callback<ArticleModel> {
            override fun onResponse(call: Call<ArticleModel>, response: Response<ArticleModel>) {
                if (response.isSuccessful) {
                    response.body()?.let {
                        haberListesi.value= ArrayList(it.articles)


                    }
                }
            }

            override fun onFailure(call: Call<ArticleModel>, t: Throwable) {
                t.printStackTrace()
            }
        })
    }
    }


