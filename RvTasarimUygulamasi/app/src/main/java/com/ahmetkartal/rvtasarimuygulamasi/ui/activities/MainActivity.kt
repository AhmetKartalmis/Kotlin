package com.ahmetkartal.rvtasarimuygulamasi.ui.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.StaggeredGridLayoutManager
import com.ahmetkartal.rvtasarimuygulamasi.data.entity.Kategoriler
import com.ahmetkartal.rvtasarimuygulamasi.databinding.ActivityMainBinding
import com.ahmetkartal.rvtasarimuygulamasi.ui.adapter.KategoriAdapter

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding= ActivityMainBinding.inflate(layoutInflater)
        binding.rv.layoutManager=StaggeredGridLayoutManager(1,StaggeredGridLayoutManager.VERTICAL)
        val kategoriler = ArrayList<Kategoriler>()

        val emlak = Kategoriler(1,"Emlak","Konut, İş Yeri, Arsa, Konut Projeleri, Bina,...","emlak_logo")
        val ikinciEl = Kategoriler(2,"İkinci El Ve Sıfır Alışveriş","Param Güvende Bilgisayar, Cep Telefon...","ikinci_el")
        val ozel_ders = Kategoriler(3,"Özel Ders Verenler","Lise & Üniversite, İlokul & Ortaokul,Yaba...","ozel_ders")
        val is_ilanlari = Kategoriler(4,"İş İlanları","İş Makinesi Yazıları","ilanlar")
        val ustalar = Kategoriler(5,"Ustalar Ve Hizmetler","Ev Tadilat & Dekorasyon, Nakliye, Araç Ser...","ustalar")
        val yardimci = Kategoriler(6,"Yardımcı Arayanlar","İş Makinesi Yazıları","yardimci")
        val yedek_parca = Kategoriler(7,"Yedek Parça,Aksesuar,Donanı...","Otomotiv Ekipmanları,Motosiklet Ekipma...","yedek_parca")
        val is_makinesi = Kategoriler(8,"İş Makineleri Ve Sanayi","İş Makineleri, Tarım Makineleri,Sanayi,Ele...","is_makinesi")
        val hayvanlar = Kategoriler(9,"Hayvanlar Alemi","Evcil Hayvanlar, Akvaryum Balıkları,Akses...","hayvanlar")
        val vasita = Kategoriler(10,"Vasıta","Otomobil, Arazi, SUV & Pickup,Motosikle...","arac")



        kategoriler.add(emlak)
        kategoriler.add(vasita)
        kategoriler.add(yedek_parca)
        kategoriler.add(ikinciEl)
        kategoriler.add(is_makinesi)
        kategoriler.add(ustalar)
        kategoriler.add(ozel_ders)
        kategoriler.add(is_ilanlari)
        kategoriler.add(yardimci)
        kategoriler.add(hayvanlar)








        val kategoriAdapter = KategoriAdapter(this@MainActivity, kategoriListesi = kategoriler)
        binding.rv.adapter= kategoriAdapter
        setContentView(binding.root)
    }
}