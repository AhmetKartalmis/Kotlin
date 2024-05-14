package com.ahmetkartal.dene.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.ahmetkartal.dene.R
import com.ahmetkartal.dene.databinding.FragmentAnasayfaBinding
import com.ahmetkartal.dene.ui.adapter.HaberAdapter
import com.ahmetkartal.dene.ui.viewmodels.AnasayfaViewModel
import com.google.android.material.bottomnavigation.BottomNavigationView


class AnasayfaFrag : Fragment() {
    private lateinit var binding: FragmentAnasayfaBinding
    private val BASE_URL ="https://newsapi.org/v2/"
    private var viewModel = AnasayfaViewModel(BASE_URL)
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        binding = FragmentAnasayfaBinding.inflate(layoutInflater,container,false)
        //listeleme işlemleri
        viewModel.haberListesi.observe(viewLifecycleOwner){
            binding.rv.adapter = HaberAdapter(requireContext(),it)
        }
        //Arama işlemleri
        binding.searchView.setOnQueryTextListener(object :android.widget.SearchView.OnQueryTextListener{
            //arama işlemleri
            override fun onQueryTextSubmit(p0: String): Boolean {
                loadDataWithSearch(p0)
                return true
            }
            override fun onQueryTextChange(p0: String): Boolean {
                loadDataWithSearch(p0)
                return true
            }
        })
        return binding.root

    }
    override fun onResume() {
        super.onResume()
        loadData()
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        // Başka fragmenttan geçiş olduğunda bottom nav. bar görünür olsun diye
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNav).visibility = View.VISIBLE

    }
    private fun loadData(){
        viewModel.dataYukle(BASE_URL)
    }
    private fun loadDataWithSearch(search : String){
        //arama yapılırken datanın çekilmesi
        viewModel.aramaYap(search)
    }


    }


