package com.example.rv

import android.annotation.SuppressLint
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.core.widget.addTextChangedListener
import com.example.rv.databinding.ActivityMainBinding
import kotlin.text.indices

class MainActivity : AppCompatActivity() {

    private val binding by lazy { ActivityMainBinding.inflate(layoutInflater) }

    @SuppressLint("SetTextI18n")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(binding.root)

        binding.edtText1.addTextChangedListener {
            val text = binding.edtText1.text.toString()
            binding.tv1.text = text
            binding.tv2.text = text.reversed()
            val teskari1 = text.substring(0,text.length/2)
            val teskari2 = text.substring(text.length/2,text.length)
            binding.tv3.text = "$teskari2$teskari1"
            var yangiSoz = ""
            for (i in text) {
                yangiSoz += i.toString().repeat(2)
            }
            binding.tv4.text = yangiSoz
            ds()
            da()
        }
    }

    @SuppressLint("SetTextI18n")
    private fun ds(){
        val text = binding.edtText1.text.toString()
        if (text.length > 1) {
            val bosh = text.substring(0, text.length - 2)
            val a = text.substring(text.length - 2, text.length - 1)
            val b = text.substring(text.length - 1, text.length)
            binding.tv5.text = "$bosh$b$a"
        }
        if (text.length-1 < 2){
            binding.tv5.text = ""
        }
    }
    @SuppressLint("SetTextI18n")
    private fun da(){
        val text = binding.edtText1.text.toString()
        if (text.length > 4) {
            val bosh = text.substring(0,2)
            val a = text.substring(2,text.length-2)
            val b = text.substring(text.length - 2, text.length)
            val g1 = bosh.reversed()
            val g2 = b.reversed()
            binding.tv6.text = "$g1$a$g2"
        }
        if (text.length-1 < 4){
            binding.tv6.text = ""
        }
    }
}