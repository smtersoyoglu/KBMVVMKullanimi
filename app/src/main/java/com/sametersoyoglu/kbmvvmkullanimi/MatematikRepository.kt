package com.sametersoyoglu.kbmvvmkullanimi

class MatematikRepository {
    // mds MatematikDataSource nesnesini oluşturduk
    var mds = MatematikDataSource()

    suspend fun toplamaYap(alinanSayi1:String, alinanSayi2:String) : String = mds.toplamaYap(alinanSayi1,alinanSayi2) // return'u bu şekilde de tek satırda yapabiliriz.

    suspend fun carpmaYap(alinanSayi1:String, alinanSayi2:String) : String {
        return mds.carpmaYap(alinanSayi1,alinanSayi2)
    }
}