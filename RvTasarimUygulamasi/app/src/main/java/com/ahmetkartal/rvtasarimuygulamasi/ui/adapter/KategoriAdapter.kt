package com.ahmetkartal.rvtasarimuygulamasi.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.ahmetkartal.rvtasarimuygulamasi.data.entity.Kategoriler
import com.ahmetkartal.rvtasarimuygulamasi.databinding.KategoriCardBinding

 class KategoriAdapter(var mContext: Context, var kategoriListesi:List<Kategoriler>)
    :RecyclerView.Adapter<KategoriAdapter.CardTasarimTutucu>()
{
    inner class CardTasarimTutucu(var tasarim:KategoriCardBinding):RecyclerView.ViewHolder(tasarim.root){
    }
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CardTasarimTutucu {
        val binding = KategoriCardBinding.inflate(LayoutInflater.from(mContext),parent,false)
        return CardTasarimTutucu(binding)
    }
    override fun onBindViewHolder(holder: CardTasarimTutucu, position: Int) {
        val kategori =kategoriListesi.get(position)
        val t = holder.tasarim
        t.kategoriFoto.setImageResource(mContext.resources.getIdentifier(kategori.resim,"drawable",mContext.packageName))
        t.tvKategoriName.text=kategori.kategori
        t.tvKategoriAciklama.text=kategori.aciklama
    }
    override fun getItemCount(): Int {
        return kategoriListesi.size
    }
}
