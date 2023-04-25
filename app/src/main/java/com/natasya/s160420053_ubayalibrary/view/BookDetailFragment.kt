package com.natasya.s160420053_ubayalibrary.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.lifecycle.ViewModelProvider
import androidx.navigation.Navigation
import com.natasya.s160420053_ubayalibrary.R
import com.natasya.s160420053_ubayalibrary.util.loadImage
import com.natasya.s160420053_ubayalibrary.viewmodel.DetailViewModel
import kotlinx.android.synthetic.main.fragment_book_detail.*

class BookDetailFragment : Fragment() {
    private lateinit var viewModel: DetailViewModel
    var id = ""
    var judul = ""
    var deskripsi = ""
    var penulis = ""
    var penerbit = ""
    var tanggal_rilis = ""
    var url = ""

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_book_detail, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        if(arguments != null){
            id = BookDetailFragmentArgs.fromBundle(requireArguments()).id
            judul = BookDetailFragmentArgs.fromBundle(requireArguments()).judul
            deskripsi = BookDetailFragmentArgs.fromBundle(requireArguments()).deskripsi
            penulis = BookDetailFragmentArgs.fromBundle(requireArguments()).penulis
            penerbit = BookDetailFragmentArgs.fromBundle(requireArguments()).penerbit
            tanggal_rilis = BookDetailFragmentArgs.fromBundle(requireArguments()).tanggalRilis
            url = BookDetailFragmentArgs.fromBundle(requireArguments()).url
            imageView3.loadImage(url, progressBar2)
            textID.text = "ID: $id"
            textJudul.text = "Judul: $judul"
            textDeskripsi.text = "Deskripsi: $deskripsi"
            textPenulis.text = "Penulis: $penulis"
            textPenerbit.text = "Penerbit: $penerbit"
            textTanggalRilis.text = "Tanggal Rilis: $tanggal_rilis"
        }
        buttonOrder.setOnClickListener {
            var action = BookDetailFragmentDirections.actionOrderFragment()
            Navigation.findNavController(it).navigate(action)
        }
    }
}