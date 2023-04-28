package com.natasya.s160420053_ubayalibrary.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.ProgressBar
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.natasya.s160420053_ubayalibrary.R
import com.natasya.s160420053_ubayalibrary.model.Book
import com.natasya.s160420053_ubayalibrary.util.loadImage
import kotlinx.android.synthetic.main.book_list_item.view.*

class BookListAdapter2(var bookList2:ArrayList<Book>): RecyclerView.Adapter<BookListAdapter2.BookViewHolder2>() {
    class BookViewHolder2(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder2 {
        var inflater2 = LayoutInflater.from(parent.context)
        var view = inflater2.inflate(R.layout.book_list_item, parent, false)
        return BookViewHolder2(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder2, position: Int) {
        holder.view.txtID.text = bookList2[position].id
        holder.view.txtJudul.text = bookList2[position].judul
        var imageView = holder.view.findViewById<ImageView>(R.id.imageView2)
        var progressBar = holder.view.findViewById<ProgressBar>(R.id.progressBar)
        imageView.loadImage(bookList2[position].url, progressBar)
        holder.view.btnDetail.setOnClickListener {
            var action = LibraryFragmentDirections.actionBookDetailFragment2(bookList2[position].id.toString(), bookList2[position].judul.toString(), bookList2[position].deskripsi.toString(), bookList2[position].penulis.toString(), bookList2[position].penerbit.toString(), bookList2[position].tanggal_rilis.toString(), bookList2[position].url.toString(), "Library")
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return bookList2.size
    }

    fun updateBookList2(newBookList2: ArrayList<Book>){
        bookList2.clear()
        bookList2.addAll(newBookList2)
        notifyDataSetChanged()
    }
}