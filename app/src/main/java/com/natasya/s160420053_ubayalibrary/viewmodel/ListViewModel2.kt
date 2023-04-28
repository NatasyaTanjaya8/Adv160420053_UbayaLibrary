package com.natasya.s160420053_ubayalibrary.viewmodel

import android.app.Application
import androidx.lifecycle.AndroidViewModel
import androidx.lifecycle.MutableLiveData
import com.google.gson.GsonBuilder
import com.google.gson.reflect.TypeToken
import com.natasya.s160420053_ubayalibrary.model.Book

class ListViewModel2(application: Application): AndroidViewModel(application) {
    var booksLD2 = MutableLiveData<ArrayList<Book>>()
    var bookLoadError2 = MutableLiveData<Boolean>()
    var loadingLD2 = MutableLiveData<Boolean>()

    fun refresh2(){
        bookLoadError2.value = false
        var json2 = "[{'id':'9780618397747', 'judul':'Academic Word Power', 'deskripsi':'Setiap buku di Academic Word Power 1-4 berfokus pada 140 kelompok kata dari Academic Word List, yang memungkinkan instruktur untuk tidak menebak-nebak dalam memilih kosakata mana yang paling diperlukan untuk mendorong ESL, Developmental English, dan siswa sekolah menengah menuju perguruan tinggi membaca yang sukses buku teks', 'penulis':'Pat Bull', 'penerbit':'Boston : Heinle-Cengage', 'tanggal_rilis':'20 Juli 2003', 'url':'https://digilib.ubaya.ac.id/img_link/pustaka/216438.jpg'}," +
                "{'id':'9789792914542', 'judul':'Panduan Lengkap Adobe Illustrator CS4', 'deskripsi':'Adobe Illustrator CS4 merupakan salah satu software untuk membuat desain grafis', 'penulis':'MADCOMS', 'penerbit':'Yogyakarta : Andi', 'tanggal_rilis':'1 Maret 2010', 'url':'https://digilib.ubaya.ac.id/img_link/pustaka/232310.jpg'}," +
                "{'id':'9781786940346', 'judul':'In the Balance', 'deskripsi':'Dari Pearl Harbor ke panzer yang bergulir melalui Paris ke Pengepungan Leningrad dan Pertempuran Midway, perang berkobar di seluruh planet saat api kehancuran semakin tinggi dan semakin panas', 'penulis':'J.D. Phillipson', 'penerbit':'Liverpool : Liverpool University Press', 'tanggal_rilis':'28 Desember 2017', 'url':'https://digilib.ubaya.ac.id/img_link/pustaka/254945.jpg'}]"
        var gson2 = GsonBuilder().create()
        var result2 = gson2.fromJson<ArrayList<Book>>(json2, object: TypeToken<ArrayList<Book>>(){}.type)
        booksLD2.value = result2
        loadingLD2.value = false
    }
}