package com.example.githubsearchapp.UI.Detail

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubsearchapp.Data.Model.User

class FollowersViewModel : ViewModel() {
    val listFollower = MutableLiveData<ArrayList<User>>()

}