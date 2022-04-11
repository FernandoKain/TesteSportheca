package br.com.dio.testesportheca.api

import br.com.dio.testesportheca.Posts
import retrofit2.http.GET



interface Endpoint {
    @GET("posts")
    fun getPosts() : retrofit2.Call<List<Posts>>
}