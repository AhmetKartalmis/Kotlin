package com.ahmetkartal.dene.ui.fragments

import android.content.Intent
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.Navigation
import androidx.navigation.fragment.navArgs
import com.ahmetkartal.dene.R
import com.ahmetkartal.dene.databinding.FragmentDetayBinding
import com.bumptech.glide.Glide
import com.google.android.material.bottomnavigation.BottomNavigationView


class DetayFragment : Fragment() {
    private lateinit var binding:FragmentDetayBinding

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View {
        // Inflate the layout for this fragment

        binding = FragmentDetayBinding.inflate(layoutInflater,container,false)
        val bundle: DetayFragmentArgs by navArgs()
        if(bundle.photoUrl!=null){
            Glide.with(requireContext()).load(bundle.photoUrl).into(binding.newsphoto)
        }

        binding.tvAuthor.text=bundle.author
        binding.tvDesc.text=bundle.title
        binding.tvContent.text=bundle.content
        binding.tvTarihDetay.text=bundle.date
        binding.goToSource.setOnClickListener {
            val gecis = DetayFragmentDirections.webeGecis(bundle.url.toString())
            Navigation.findNavController(it).navigate(gecis)
        }
        var isFav=false
        binding.favButton.setOnClickListener {
            isFav=!isFav
            if(isFav){
                binding.favButton.setImageResource(R.drawable.baseline_favorite_24)
            }else{
                binding.favButton.setImageResource(R.drawable.baseline_favorite_border_24)
            }
        }
        binding.share.setOnClickListener {
            shareNews(bundle.url.toString())

        }


        return binding.root

    }
    fun shareNews(url: String) {
        val shareIntent = Intent().apply {
            action = Intent.ACTION_SEND
            putExtra(Intent.EXTRA_TEXT, url) // Haber URL'sini paylaşacak metin
            type = "text/plain"
        }
        startActivity(Intent.createChooser(shareIntent, "Haberi Paylaş")) // Paylaşım için uygun uygulamaları göster
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNav).visibility = View.GONE

    }
}