package com.sametersoyoglu.kbmvvmkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.sametersoyoglu.kbmvvmkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {
    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.textViewSonuc.text = "0"

        binding.buttonToplama.setOnClickListener {
            val alinanSayi1 = binding.editTextSayi1.text.toString()
            val alinanSayi2 = binding.editTextSayi2.text.toString()

            val sayi1 = alinanSayi1.toInt()
            val sayi2 = alinanSayi2.toInt()

            val toplam = sayi1 + sayi2

            binding.textViewSonuc.text = toplam.toString() //"$toplam" direk toplam olarak alamayız sayısal değer string e çevirmemiz lazım.
        }

        binding.buttonCarpma.setOnClickListener {
            val alinanSayi1 = binding.editTextSayi1.text.toString()
            val alinanSayi2 = binding.editTextSayi2.text.toString()

            val sayi1 = alinanSayi1.toInt()
            val sayi2 = alinanSayi2.toInt()

            val carpma = sayi1 * sayi2

            binding.textViewSonuc.text = "$carpma"
        }
    }
}