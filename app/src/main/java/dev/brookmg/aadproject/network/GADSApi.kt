package dev.brookmg.aadproject.network

import dev.brookmg.aadproject.model.LearningLeaderItem
import dev.brookmg.aadproject.model.SkillIQItem
import retrofit2.Call
import retrofit2.http.GET

interface GADSApi {

    @GET("api/hours")
    fun listLearningLeaders() : Call<List<LearningLeaderItem>>

    @GET("api/skilliq")
    fun listSkillIQToppers() : Call<List<SkillIQItem>>

}