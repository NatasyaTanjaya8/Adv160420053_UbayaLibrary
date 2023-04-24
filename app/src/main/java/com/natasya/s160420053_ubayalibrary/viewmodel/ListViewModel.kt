package com.natasya.s160420053_ubayalibrary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.android.volley.Request
import com.android.volley.RequestQueue
import com.android.volley.toolbox.StringRequest
import com.google.gson.Gson
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.natasya.s160420053_ubayalibrary.model.Book
import java.lang.reflect.Type

class ListViewModel(application: Application):AndroidViewModel(application) {
    var booksLD = MutableLiveData<ArrayList<Book>>()
    var bookLoadError = MutableLiveData<Boolean>()
    var loadingLD = MutableLiveData<Boolean>()
    var TAG = "volleyTag"
    private var queue: RequestQueue? = null

    fun refresh(){
        /*
        var book1 = Book("9781592536382", "1000 Products Designs : Forms, Function, and Technology from Around the World", "Desain produk telah berubah secara dramatis dalam beberapa tahun terakhir karena semuanya, mulai dari komputer hingga microwave hingga pemutar MP3, menjadi lebih ringkas dan lebih bertenaga", "Eric Chan", "Massachusetts : Rockport", "1 November 2010", "https://digilib.ubaya.ac.id/img_link/pustaka/227502.jpg")
        var book2 = Book("9780618397747", "Academic Word Power", "Setiap buku di Academic Word Power 1-4 berfokus pada 140 kelompok kata dari Academic Word List, yang memungkinkan instruktur untuk tidak menebak-nebak dalam memilih kosakata mana yang paling diperlukan untuk mendorong ESL, Developmental English, dan siswa sekolah menengah menuju perguruan tinggi membaca yang sukses buku teks", "Pat Bull", "Boston : Heinle-Cengage", "20 Juli 2003", "https://digilib.ubaya.ac.id/img_link/pustaka/216438.jpg")
        var book3 = Book("9786027624801", "Amazing NLP : Neuro Linguistic Programming : Dari Konsep Hingga Teknik", "Sejak kemunculannya di era 70-an, NLP telah mengalami banyak perkembangan. NLP mampu menjadi seperangkat alat jitu yang berfungsi untuk memprogram pikiran supaya dapat berkembang dan sukses", "Annie Sailendra", "Yogyakarta : Bhanafa Publ", "15 Mei 2017", "https://digilib.ubaya.ac.id/img_link/pustaka/251658.jpg")
        var bookList:ArrayList<Book> = arrayListOf<Book>(book1, book2, book3)
        booksLD.value = bookList
        bookLoadError.value = false
        loadingLD.value = false
        */
        bookLoadError.value = false
        var json = "[{'id':'9781592536382', 'judul':'1000 Products Designs : Forms, Function, and Technology from Around the World', 'deskripsi':'Desain produk telah berubah secara dramatis dalam beberapa tahun terakhir karena semuanya, mulai dari komputer hingga microwave hingga pemutar MP3, menjadi lebih ringkas dan lebih bertenaga', 'penulis':'Eric Chan', 'penerbit':'Massachusetts : Rockport', 'tanggal_rilis':'1 November 2010', 'url':'https://digilib.ubaya.ac.id/img_link/pustaka/227502.jpg'}," +
                     "{'id':'9780618397747', 'judul':'Academic Word Power', 'deskripsi':'Setiap buku di Academic Word Power 1-4 berfokus pada 140 kelompok kata dari Academic Word List, yang memungkinkan instruktur untuk tidak menebak-nebak dalam memilih kosakata mana yang paling diperlukan untuk mendorong ESL, Developmental English, dan siswa sekolah menengah menuju perguruan tinggi membaca yang sukses buku teks', 'penulis':'Pat Bull', 'penerbit':'Boston : Heinle-Cengage', 'tanggal_rilis':'20 Juli 2003', 'url':'https://digilib.ubaya.ac.id/img_link/pustaka/216438.jpg'}," +
                     "{'id':'9786027624801', 'judul':'Amazing NLP : Neuro Linguistic Programming : Dari Konsep Hingga Teknik', 'deskripsi':'Sejak kemunculannya di era 70-an, NLP telah mengalami banyak perkembangan. NLP mampu menjadi seperangkat alat jitu yang berfungsi untuk memprogram pikiran supaya dapat berkembang dan sukses', 'penulis':'Annie Sailendra', 'penerbit':'Yogyakarta : Bhanafa Publ', 'tanggal_rilis':'15 Mei 2017', 'url':'https://digilib.ubaya.ac.id/img_link/pustaka/251658.jpg'}]"
        var gson = GsonBuilder().create()
        var result = gson.fromJson<ArrayList<Book>>(json, object: TypeToken<ArrayList<Book>>(){}.type)
        booksLD.value = result
        loadingLD.value = false
    }
}