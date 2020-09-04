package dev.brookmg.aadproject.network

import android.util.Log
import dev.brookmg.aadproject.model.LearningLeaderItem
import dev.brookmg.aadproject.model.SkillIQItem
import okhttp3.OkHttpClient
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class API {

    private var okHttpClient: OkHttpClient = OkHttpClient.Builder().build()
    private var gadsApiService: GADSApi
    private var googleFormAPI: GoogleFormAPI

    init {
        val retrofit = Retrofit
            .Builder().baseUrl("https://gadsapi.herokuapp.com/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val retrofitGoogleForm = Retrofit
            .Builder().baseUrl("https://docs.google.com/forms/d/e/")
            .client(okHttpClient)
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        gadsApiService = retrofit.create(GADSApi::class.java)
        googleFormAPI = retrofitGoogleForm.create(GoogleFormAPI::class.java)
    }

    fun getLearnerLeaderList(callback: (List<LearningLeaderItem>) -> Unit) {
        val gadsBinding = gadsApiService.listLearningLeaders()
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
        val gadsBinding = gadsApiService.listSkillIQToppers()
        gadsBinding.enqueue(object: Callback<List<SkillIQItem>> {
            override fun onResponse(call: Call<List<SkillIQItem>>, response: Response<List<SkillIQItem>>) {
                callback.invoke(response.body() ?: listOf())
            }

            override fun onFailure(call: Call<List<SkillIQItem>>, t: Throwable) {
                Log.e("NetworkError" , t.toString())
            }
        })
    }

    fun sendFormResponse(firstName: String, lastName: String, email: String,
                         githubProjectLink: String, cb: (Pair<String, String>) -> Unit) {
        val formResponse = googleFormAPI.formResponseSender(
            email, firstName, lastName, githubProjectLink
        )
        formResponse.enqueue(object: Callback<Unit> {
            override fun onResponse(call: Call<Unit>, response: Response<Unit>) {
                cb.invoke("complete" to "")
            }

            override fun onFailure(call: Call<Unit>, t: Throwable) {
                cb.invoke("" to t.message.toString())
            }
        })
    }

}