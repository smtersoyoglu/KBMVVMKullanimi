package com.sametersoyoglu.kbmvvmkullanimi

import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.withContext

class MatematikDataSource {
    // suspend demek bunun asekron çalışan bir fonksiyon olduğunu gösteriyor. yani coroutine lerle çalıştığı anlamına geliyor. asekron da veritabanları ile daha performanslı çalışan bir fonksiyon olduğunu belirtiyoruz.
    suspend fun toplamaYap(alinanSayi1:String, alinanSayi2:String) : String =
        // return edeceksek bu şekilde yazarız.
        withContext(Dispatchers.IO) {
            // IO veritabanı ile ilgili işlemlerde kullanırız.

            val sayi1 = alinanSayi1.toInt()
            val sayi2 = alinanSayi2.toInt()

            val toplam = sayi1 + sayi2

            return@withContext toplam.toString()
        }




    suspend fun carpmaYap(alinanSayi1:String, alinanSayi2:String) : String =
        // return edeceksek bu şekilde yazarız.
        withContext(Dispatchers.IO) {

            val sayi1 = alinanSayi1.toInt()
            val sayi2 = alinanSayi2.toInt()

            val carpma = sayi1 * sayi2

            return@withContext carpma.toString()
        }
}