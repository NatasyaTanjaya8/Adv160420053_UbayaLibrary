package com.natasya.s160420053_ubayalibrary.viewmodel

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.natasya.s160420053_ubayalibrary.model.Book

class ListViewModel:ViewModel() {
    var booksLD = MutableLiveData<ArrayList<Book>>()
    var bookLoadError = MutableLiveData<Boolean>()
    var loadingLD = MutableLiveData<Boolean>()

    fun refresh(){
        var book1 = Book("9781592536382", "1000 Products Designs : Forms, Function, and Technology from Around the World", "Desain produk telah berubah secara dramatis dalam beberapa tahun terakhir karena semuanya, mulai dari komputer hingga microwave hingga pemutar MP3, menjadi lebih ringkas dan lebih bertenaga", "Eric Chan", "Massachusetts : Rockport", "1 November 2010", "https://digilib.ubaya.ac.id/img_link/pustaka/227502.jpg")
        var book2 = Book("9780618397747", "Academic Word Power", "Setiap buku di Academic Word Power 1-4 berfokus pada 140 kelompok kata dari Academic Word List, yang memungkinkan instruktur untuk tidak menebak-nebak dalam memilih kosakata mana yang paling diperlukan untuk mendorong ESL, Developmental English, dan siswa sekolah menengah menuju perguruan tinggi membaca yang sukses buku teks", "Pat Bull", "Boston : Heinle-Cengage", "20 Juli 2003", "https://digilib.ubaya.ac.id/img_link/pustaka/216438.jpg")
        var book3 = Book("9786027624801", "Amazing NLP : Neuro Linguistic Programming : Dari Konsep Hingga Teknik", "Sejak kemunculannya di era 70-an, NLP telah mengalami banyak perkembangan. NLP mampu menjadi seperangkat alat jitu yang berfungsi untuk memprogram pikiran supaya dapat berkembang dan sukses", "Annie Sailendra", "Yogyakarta : Bhanafa Publ", "15 Mei 2017", "https://digilib.ubaya.ac.id/img_link/pustaka/251658.jpg")
        var bookList:ArrayList<Book> = arrayListOf<Book>(book1, book2, book3)
        booksLD.value = bookList
        bookLoadError.value = false
        loadingLD.value = false
    }
}