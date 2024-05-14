package com.ahmetkartal.dene.ui.fragments

import android.os.Binder
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.appcompat.app.AppCompatActivity
import com.ahmetkartal.dene.R
import com.ahmetkartal.dene.databinding.FragmentFavorilerBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

class FavorilerFragment : Fragment() {
    private lateinit var binding: FragmentFavorilerBinding


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding= FragmentFavorilerBinding.inflate(layoutInflater,container,false)
        return binding.root
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNav).visibility = View.VISIBLE

    }
}