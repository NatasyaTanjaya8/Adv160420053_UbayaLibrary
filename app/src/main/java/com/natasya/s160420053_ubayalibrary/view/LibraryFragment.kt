package com.natasya.s160420053_ubayalibrary.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.natasya.s160420053_ubayalibrary.R
import com.natasya.s160420053_ubayalibrary.viewmodel.ListViewModel2
import kotlinx.android.synthetic.main.fragment_library.*

class LibraryFragment : Fragment() {
    private lateinit var viewModel2: ListViewModel2
    private var bookListAdapter2 = BookListAdapter2(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_library, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel2 = ViewModelProvider(this).get(ListViewModel2::class.java)
        viewModel2.refresh2()
        recyclerView.layoutManager = LinearLayoutManager(context)
        recyclerView.adapter = bookListAdapter2
        observeViewModel2()
        refLayout.setOnRefreshListener {
            recyclerView.visibility = View.GONE
            textError.visibility = View.GONE
            progLoad.visibility = View.VISIBLE
            viewModel2.refresh2()
            refLayout.isRefreshing = false
        }
    }

    fun observeViewModel2(){
        viewModel2.booksLD2.observe(viewLifecycleOwner, Observer {
            bookListAdapter2.updateBookList2(it)
        })
        viewModel2.bookLoadError2.observe(viewLifecycleOwner, Observer {
            if (it == true){
                textError.visibility = View.VISIBLE
            }
            else{
                textError.visibility = View.GONE
            }
        })
        viewModel2.loadingLD2.observe(viewLifecycleOwner, Observer {
            if (it == true){
                recyclerView.visibility = View.GONE
                progLoad.visibility = View.VISIBLE
            }
            else{
                recyclerView.visibility = View.VISIBLE
                progLoad.visibility = View.GONE
            }
        })
    }
}