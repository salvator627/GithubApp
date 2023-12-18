package com.example.githubsearchapp.UI.Main

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.KeyEvent
import android.view.View
import androidx.lifecycle.ViewModelProvider
import androidx.lifecycle.get
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubsearchapp.Data.Model.User
import com.example.githubsearchapp.UI.Detail.DetailUserActivity
import com.example.githubsearchapp.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private lateinit var viewModel : MainViewModel
    private lateinit var adapter : MainAdapter

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = MainAdapter()
        adapter.notifyDataSetChanged()

        adapter.setOnItemClickCallback(object : MainAdapter.onItemClickCallback{
            override fun onItemclick(data: User) {
                Intent(this@MainActivity,DetailUserActivity::class.java).also {
                    it.putExtra(DetailUserActivity.EXTRA_USERNAME,data.login)
                    startActivity(it)
                }
            }

        })
        viewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(MainViewModel::class.java)

        binding.apply {
            rvUser.layoutManager = LinearLayoutManager(this@MainActivity)
            rvUser.setHasFixedSize(true)
            rvUser.adapter = adapter

            btnSearch.setOnClickListener {
                searchUser()
            }

            etQuery.setOnKeyListener { view, i, keyEvent ->
                if (keyEvent.action == KeyEvent.ACTION_DOWN && i == KeyEvent.KEYCODE_ENTER){
                    searchUser()
                    return@setOnKeyListener true
                }
                return@setOnKeyListener false
            }
        }

        viewModel.getUser().observe(this,{
            if (it!=null){
                adapter.setList(it)
                showLoading(false)
            }
        })

    }

    private fun searchUser(){
        binding.apply {
            val query = etQuery.text.toString()
            if (query.isEmpty()) return
            showLoading(true)
            viewModel.setUser(query)
        }
    }

    private fun showLoading(state:Boolean){
        if (state){
            binding.progressbar.visibility = View.VISIBLE
        }else{
            binding.progressbar.visibility = View.GONE
        }
    }

}