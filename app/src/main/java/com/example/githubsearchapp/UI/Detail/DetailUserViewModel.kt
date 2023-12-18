package com.example.githubsearchapp.UI.Detail

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.githubsearchapp.Api.RetrofitClient
import com.example.githubsearchapp.Data.Model.DetailResponse
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response

class DetailUserViewModel : ViewModel() {
    val user = MutableLiveData<DetailResponse>()

    fun setUserDetail(username : String){
        RetrofitClient.apiInstance
            .getDetailUser(username)
            .enqueue(object  : Callback<DetailResponse>{
                override fun onResponse(
                    call: Call<DetailResponse>,
                    response: Response<DetailResponse>
                ) {
                    if (response.isSuccessful){
                        user.postValue(response.body())
                    }
                }

                override fun onFailure(call: Call<DetailResponse>, t: Throwable) {
                    TODO("Not yet implemented")
                }

            })
    }
    fun getUserDetail(): LiveData<DetailResponse>{
        return user
    }
}