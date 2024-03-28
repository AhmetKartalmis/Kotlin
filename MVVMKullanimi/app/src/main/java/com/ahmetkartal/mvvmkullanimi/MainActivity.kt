package com.ahmetkartal.mvvmkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.ahmetkartal.mvvmkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding : ActivityMainBinding
    private val viewModel : MainActivityViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding=DataBindingUtil.setContentView(this,R.layout.activity_main)
        binding.nesne = this
        viewModel.sonuc.observe(this){
            binding.sonuc=it
        }
    }

    fun toplama(alinan1:String,alinan2:String){
        viewModel.toplama(alinan1,alinan2)
    }
    fun carpma(alinan1:String,alinan2:String){
        viewModel.carpma(alinan1,alinan2)

    }
}