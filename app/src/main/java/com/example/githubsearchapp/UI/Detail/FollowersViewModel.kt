package com.example.githubsearchapp.UI.Detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubsearchapp.Api.RetrofitClient
import com.example.githubsearchapp.Data.Model.User
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class FollowersViewModel : ViewModel() {
    val listFollower = MutableLiveData<ArrayList<User>>()

    fun setListUser(username : String){
        RetrofitClient.apiInstance
            .getFollowers(username)
            .enqueue(object : Callback<ArrayList<User>>{
                override fun onResponse(
                    call: Call<ArrayList<User>>,
                    response: Response<ArrayList<User>>
                ) {
                    if (response.isSuccessful){
                        listFollower.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<ArrayList<User>>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })

    }
    fun getListFollower(): LiveData<ArrayList<User>>{
        return listFollower
    }
}