package br.com.dio.testesportheca.api

import android.telecom.Call
import br.com.dio.testesportheca.Posts
import com.google.gson.JsonObject
import org.json.JSONObject
import retrofit2.http.GET



interface Endpoint {
    @GET("posts")
    fun getPosts() : retrofit2.Call<List<Posts>>
}