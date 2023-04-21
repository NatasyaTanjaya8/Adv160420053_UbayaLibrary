package com.natasya.s160420053_ubayalibrary.view

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.lifecycle.Observer
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.natasya.s160420053_ubayalibrary.R
import com.natasya.s160420053_ubayalibrary.viewmodel.ListViewModel
import kotlinx.android.synthetic.main.fragment_home.*

class HomeFragment : Fragment() {
    private lateinit var viewModel:ListViewModel
    private var bookListAdapter = BookListAdapter(arrayListOf())

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        return inflater.inflate(R.layout.fragment_home, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        viewModel = ViewModelProvider(this).get(ListViewModel::class.java)
        viewModel.refresh()
        recView.layoutManager = LinearLayoutManager(context)
        recView.adapter = bookListAdapter
        observeViewModel()
    }

    fun observeViewModel(){
        viewModel.booksLD.observe(viewLifecycleOwner, Observer {
            bookListAdapter.updateBookList(it)
        })
        viewModel.bookLoadError.observe(viewLifecycleOwner, Observer {
            if (it == true){
                txtError.visibility = View.VISIBLE
            }
            else{
                txtError.visibility = View.GONE
            }
        })
        viewModel.loadingLD.observe(viewLifecycleOwner, Observer {
            if (it == true){
                recView.visibility = View.GONE
                progressLoad.visibility = View.VISIBLE
            }
            else{
                recView.visibility = View.VISIBLE
                progressLoad.visibility = View.GONE
            }
        })
    }
}