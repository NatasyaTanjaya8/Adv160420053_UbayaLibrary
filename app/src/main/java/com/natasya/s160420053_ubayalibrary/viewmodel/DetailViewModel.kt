package com.natasya.s160420053_ubayalibrary.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natasya.s160420053_ubayalibrary.model.Book

class DetailViewModel:ViewModel() {
    var bookLD = MutableLiveData<Book>()
    fun fetch(){
        var book1 = Book("9781592536382", "1000 Products Designs : Forms, Function, and Technology from Around the World", "Desain produk telah berubah secara dramatis dalam beberapa tahun terakhir karena semuanya, mulai dari komputer hingga microwave hingga pemutar MP3, menjadi lebih ringkas dan lebih bertenaga", "Eric Chan", "Massachusetts : Rockport", "1 November 2010", "https://digilib.ubaya.ac.id/img_link/pustaka/227502.jpg")
        bookLD.value = book1
    }
}