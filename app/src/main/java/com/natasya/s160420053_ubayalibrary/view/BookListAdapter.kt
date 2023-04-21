package com.natasya.s160420053_ubayalibrary.view

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.navigation.Navigation
import androidx.recyclerview.widget.RecyclerView
import com.natasya.s160420053_ubayalibrary.R
import com.natasya.s160420053_ubayalibrary.model.Book
import kotlinx.android.synthetic.main.book_list_item.view.*

class BookListAdapter(var bookList:ArrayList<Book>):RecyclerView.Adapter<BookListAdapter.BookViewHolder>() {
    class BookViewHolder(var view: View) : RecyclerView.ViewHolder(view)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): BookViewHolder {
        var inflater = LayoutInflater.from(parent.context)
        var view = inflater.inflate(R.layout.book_list_item, parent, false)
        return BookViewHolder(view)
    }

    override fun onBindViewHolder(holder: BookViewHolder, position: Int) {
        holder.view.txtID.text = bookList[position].id
        holder.view.txtJudul.text = bookList[position].judul
        holder.view.btnDetail.setOnClickListener {
            var action = HomeFragmentDirections.actionBookDetailFragment(bookList[position].id.toString(), bookList[position].judul.toString(), bookList[position].deskripsi.toString(), bookList[position].penulis.toString(), bookList[position].penerbit.toString(), bookList[position].tanggal_rilis.toString(), bookList[position].url.toString())
            Navigation.findNavController(it).navigate(action)
        }
    }

    override fun getItemCount(): Int {
        return bookList.size
    }

    fun updateBookList(newBookList: ArrayList<Book>){
        bookList.clear()
        bookList.addAll(newBookList)
        notifyDataSetChanged()
    }
}