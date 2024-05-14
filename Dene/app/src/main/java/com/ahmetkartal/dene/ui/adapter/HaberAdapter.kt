package com.ahmetkartal.dene.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.ahmetkartal.dene.data.entity.Article
import com.ahmetkartal.dene.databinding.CardTasarimBinding
import com.ahmetkartal.dene.ui.fragments.AnasayfaFragDirections
import com.bumptech.glide.Glide

class HaberAdapter(var mContext: Context, var haberListesi:ArrayList<Article>):RecyclerView.Adapter<HaberAdapter.CardTasarimTutucu>() {
    inner class CardTasarimTutucu(var tasarim : CardTasarimBinding ) : RecyclerView.ViewHolder(tasarim.root)



    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
            val layoutInflater= LayoutInflater.from(mContext)
            val tasarim = CardTasarimBinding.inflate(layoutInflater,parent,false)
            return CardTasarimTutucu(tasarim)
        }

    override fun getItemCount(): Int {
       return haberListesi.size
    }

    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {

        val t = holder.tasarim
        val guncelHaber = haberListesi.get(position)
        t.newContent.text=guncelHaber.description
        val photoUrl = guncelHaber.urlToImage
        Glide.with(mContext).load(photoUrl).override(116,75).into(t.cardImageView)
        t.tvTarih.text=guncelHaber.publishedAt
        t.tvKaynak.text=guncelHaber.author
        t.newTitle.text=guncelHaber.title


        t.cardTasarim.setOnClickListener {
            val gecis = AnasayfaFragDirections.detaya(guncelHaber.urlToImage,guncelHaber.url,guncelHaber.title,guncelHaber.content,guncelHaber.author,guncelHaber.publishedAt)
            Navigation.findNavController(it).navigate(gecis)

        }


    }
    }



