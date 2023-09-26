package com.sametersoyoglu.kbmvvmkullanimi

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class MainActivityViewModel : ViewModel() {

    //var sonuc = "0" bunu yani değiştirdiğimiz ortak değeri LiveData yapıcaz.
    var sonuc = MutableLiveData("0") // varsayılan değeri 0 olan bir LiveData oldu.

    var matematikRepository = MatematikRepository()

    fun toplamaYap(alinanSayi1:String, alinanSayi2:String) {
        /* BURDAKİ İŞLEMİ DataSource da yapıyoruz Repository üzerinden buraya aktarıcaz.
        val sayi1 = alinanSayi1.toInt()
        val sayi2 = alinanSayi2.toInt()
        val toplam = sayi1 + sayi2
        sonuc.value = toplam.toString() // LiveData kullandığımız zaman .value dememiz lazım .value ben bir LiveDatayım benim değerim değiştirildi beni dinleyen beni gözlemleyen yeri tetikleyi oraya veri gönder demek.
         */
        CoroutineScope(Dispatchers.Main).launch {
            //
            sonuc.value = matematikRepository.toplamaYap(alinanSayi1,alinanSayi2)
        }

    }

    fun carpmaYap(alinanSayi1:String, alinanSayi2:String) {

        CoroutineScope(Dispatchers.Main).launch {
            sonuc.value = matematikRepository.carpmaYap(alinanSayi1,alinanSayi2)
        }
    }
}