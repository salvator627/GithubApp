package com.example.githubsearchapp.UI.Detail

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.githubsearchapp.R
import com.example.githubsearchapp.UI.Main.MainAdapter
import com.example.githubsearchapp.databinding.FragmentFollowBinding

class FollowersFragment : Fragment(R.layout.fragment_follow) {

    private var _binding : FragmentFollowBinding? = null
    private val binding get() = _binding!!
    private lateinit var followersViewModel: FollowersViewModel
    private lateinit var adapter : MainAdapter
    private lateinit var username : String
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val args = arguments
        username = args?.getString(DetailUserActivity.EXTRA_USERNAME).toString()
        _binding = FragmentFollowBinding.bind(view)

        adapter = MainAdapter()
        adapter.notifyDataSetChanged()

        binding.apply {
            rvFollower.setHasFixedSize(true)
            rvFollower.layoutManager = LinearLayoutManager(activity)
            rvFollower.adapter = adapter
        }
        showLoading(state = true)
        followersViewModel = ViewModelProvider(this,ViewModelProvider.NewInstanceFactory()).get(FollowersViewModel::class.java)
        followersViewModel.setListUser(username)
        followersViewModel.getListFollower().observe(viewLifecycleOwner, {
            if (it!=null){
                adapter.setList(it)
                showLoading(false)
            }
        })
    }
    private fun showLoading(state:Boolean){
        if (state){
            binding.progressbar.visibility = View.VISIBLE
        }else{
            binding.progressbar.visibility = View.GONE
        }
    }
}