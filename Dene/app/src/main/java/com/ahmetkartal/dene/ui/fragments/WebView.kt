package com.ahmetkartal.dene.ui.fragments

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.webkit.WebViewClient
import androidx.appcompat.app.AppCompatActivity
import androidx.navigation.fragment.navArgs
import com.ahmetkartal.dene.R
import com.ahmetkartal.dene.databinding.FragmentWebViewBinding
import com.google.android.material.bottomnavigation.BottomNavigationView

// TODO: Rename parameter arguments, choose names that match
// the fragment initialization parameters, e.g. ARG_ITEM_NUMBER
private const val ARG_PARAM1 = "param1"
private const val ARG_PARAM2 = "param2"

/**
 * A simple [Fragment] subclass.
 * Use the [WebView.newInstance] factory method to
 * create an instance of this fragment.
 */
class WebView : Fragment() {
    private lateinit var binding: FragmentWebViewBinding
    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = FragmentWebViewBinding.inflate(layoutInflater,container,false)
        val webView = binding.webView
        val bundle : WebViewArgs by navArgs()
        webView.webViewClient= WebViewClient()
        webView.loadUrl(bundle.url.toString())
        return binding.root

    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        (activity as AppCompatActivity).findViewById<BottomNavigationView>(R.id.bottomNav).visibility = View.GONE

    }
}