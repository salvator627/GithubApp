package com.example.githubsearchapp.UI.Main

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubsearchapp.Api.RetrofitClient
import com.example.githubsearchapp.Data.Model.User
import com.example.githubsearchapp.Data.Model.UserResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class MainViewModel : ViewModel(){

    val listuser = MutableLiveData<ArrayList<User>>()

    fun setUser(query : String){
        RetrofitClient.apiInstance
            .getSearchUsers(query)
            .enqueue(object : Callback<UserResponse>{
                override fun onResponse(
                    call: Call<UserResponse>,
                    response: Response<UserResponse>
                ) {
                    if (response.isSuccessful){
                        listuser.postValue(response.body()?.items)
                    }
                }

                override fun onFailure(call: Call<UserResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
    fun getUser(): LiveData<ArrayList<User>>{
        return listuser
    }
}