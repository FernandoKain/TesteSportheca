package br.com.dio.testesportheca.api

import br.com.dio.testesportheca.Player
import retrofit2.http.GET



interface Endpoint2 {
    @GET("teste/teste.json")
    fun getPlayer() : retrofit2.Call<List<Player>>
}
