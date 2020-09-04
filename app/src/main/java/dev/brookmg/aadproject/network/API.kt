package dev.brookmg.aadproject.network

import android.util.Log
import dev.brookmg.aadproject.model.LearningLeaderItem
import dev.brookmg.aadproject.model.SkillIQItem
import okhttp3.OkHttpClient
import okhttp3.internal.Internal.instance
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {

    private var okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
    private var retrofit: Retrofit
    private var GADSApiService: GADSApi

    init {
        retrofit = Retrofit
            .Builder().baseUrl("https://gadsapi.herokuapp.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()
        GADSApiService = retrofit.create(GADSApi::class.java)
    }

    fun getLearnerLeaderList(callback: (List<LearningLeaderItem>) -> Unit) {
        val gadsBinding = GADSApiService.listLearningLeaders()
        gadsBinding.enqueue(object: Callback<List<LearningLeaderItem>> {
            override fun onResponse(call: Call<List<LearningLeaderItem>>, response: Response<List<LearningLeaderItem>>) {
                callback.invoke(response.body() ?: listOf())
            }

            override fun onFailure(call: Call<List<LearningLeaderItem>>, t: Throwable) {
                Log.e("NetworkError" , t.toString())
            }
        })
    }

    fun getSkillIQLeaderList(callback: (List<SkillIQItem>) -> Unit) {
        val gadsBinding = GADSApiService.listSkillIQToppers()
        gadsBinding.enqueue(object: Callback<List<SkillIQItem>> {
            override fun onResponse(call: Call<List<SkillIQItem>>, response: Response<List<SkillIQItem>>) {
                callback.invoke(response.body() ?: listOf())
            }

            override fun onFailure(call: Call<List<SkillIQItem>>, t: Throwable) {
                Log.e("NetworkError" , t.toString())
            }
        })
    }

}