package com.sametersoyoglu.kbmvvmkullanimi

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.activity.viewModels
import androidx.databinding.DataBindingUtil
import com.sametersoyoglu.kbmvvmkullanimi.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val viewModel : MainActivityViewModel by viewModels()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = DataBindingUtil.setContentView(this,R.layout.activity_main) // dataBinding kurulumu

        binding.mainActitivtyNesnesi = this // xml de <variable> içerisinde yaptığımız mainActitivtyNesnesi adını verdiğimiz ve bununla fonksiyonlara eriştiğimiz nesnemizi tanımlıyoruz.

        // MVVM mimarisinde DataBinding kullanarak tasarımsal kodlamaları xml içerisinde yaparız.
        // textview, button, edittext için kodlamalarımız var amacımız bu kodları burdan çıkarıp xml içerisinde yapmak.

        viewModel.sonuc.observe(this) {
            binding.hesaplamaSonucu = it //  binding.hesaplamaSonucu = viewModel.sonuc bunun yerine LiveData kullanarak daha basit şekilde yaptık. 3 kere tekrarlıyordu bu kod LiveData ile tek parametrede yaptık.
        }

        //binding.textViewSonuc.text = "0"  - viewmodel de ki sonucu oku dedik aşşağıda viewmodel sınıfımızda tanımladığımız fonksiyon üzerinden.
        //binding.hesaplamaSonucu = viewModel.sonuc // xml de <variable> ile nesne oluşturup 3 yerde textview e sonuç yazdırdığımız için xmlde textview üzerinden kolayca erişmek için nesnesini tanımlıyoruz.

        /* butona tıklama işlemini fonksiyon da yaptık  Event Handle yapısı ile dataBinding deki amac tasarımsal kodları mümkün olduğu kadar tasarim üzerinde yapmaya yarıyor
        tasarim.buttonToplama.setOnClickListener {

        }
        tasarim.buttonCarpma.setOnClickListener {

        }
         */

    }

    //Event Handle Kullanimi --- butona tıklama gibi işlemleri daha pratik hale getirme oluşturacağımız metodla butona tıklama olayını gerçekleştirme
    fun buttonToplamaTikla(alinanSayi1:String, alinanSayi2:String) {
        // editText i tanımlama işlemini kod olarak değilde dataBinding kullandığımız için xml de de yapabiliriz ve fonksiyona parametre olarak atayabiliriz kodlamayı azaltmak için kullanabiliriz.
        //val alinanSayi1 = binding.editTextSayi1.text.toString()
        //val alinanSayi2 = binding.editTextSayi2.text.toString()

        /*
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val toplam = sayi1 + sayi2
                    Burdaki işlemsel kodları ViewModel de yaptırıyoruz.
         */
        //binding.textViewSonuc.text = toplam.toString() // direk toplam olarak alamayız sayısal değer string e çevirmemiz lazım.
        // yukarıda ki işlemsel kodları ViewModel de yaptık ve burada viewmodel den çektik.
        viewModel.toplamaYap(alinanSayi1,alinanSayi2)
        //binding.hesaplamaSonucu = viewModel.sonuc bunun yerine yukarıda LiveData ile tek parametrede bu işlemi yani 3 kere tekrarladığımız bu işlemi tek seferde yaptık.
    }

    fun buttonCarpmaTikla(alinanSayi1:String, alinanSayi2:String) {
        //val alinanSayi1 = binding.editTextSayi1.text.toString()
        //val alinanSayi2 = binding.editTextSayi2.text.toString()

        viewModel.carpmaYap(alinanSayi1,alinanSayi2)

        //binding.textViewSonuc.text = "$carpma"
        //binding.hesaplamaSonucu = viewModel.sonuc

    }

}