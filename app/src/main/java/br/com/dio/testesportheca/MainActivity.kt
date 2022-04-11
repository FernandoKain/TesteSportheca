package br.com.dio.testesportheca

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import br.com.dio.testesportheca.api.Endpoint
import br.com.dio.testesportheca.api.Endpoint2
import br.com.dio.testesportheca.util.NetworkUtils
import br.com.dio.testesportheca.util.NetworkUtils2
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlinx.android.synthetic.main.activity_main.*
import retrofit2.create


class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        getData()
        getDataPlayer()

    }

    fun getDataPlayer(){
        val retrofitClient2 = NetworkUtils2
            .getRetrofitInstance2("http://sportsmatch.com.br")

        val endpoint2 = retrofitClient2.create(Endpoint2::class.java)
        val callback2 = endpoint2.getPlayer()

        callback2.enqueue(object : Callback<List<Player>> {
            override fun onResponse(call: Call<List<Player>>, response: Response<List<Player>>) {
                response.body()?.forEach {
                    id_pos.text = id_pos.text.toString().plus(it.pos)
                }
            }

            override fun onFailure(call: Call<List<Player>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }
        })

    }

    fun getData() {
        val retrofitClient = NetworkUtils
            .getRetrofitInstance("https://jsonplaceholder.typicode.com")

        val endpoint = retrofitClient.create(Endpoint::class.java)
        val callback = endpoint.getPosts()

        callback.enqueue(object : Callback<List<Posts>> {
            override fun onFailure(call: Call<List<Posts>>, t: Throwable) {
                Toast.makeText(baseContext, t.message, Toast.LENGTH_SHORT).show()
            }

            override fun onResponse(call: Call<List<Posts>>, response: Response<List<Posts>>) {
                response.body()?.forEach {
                    id_texto.text = id_texto.text.toString().plus(it.body)
                }
            }
        })

    }
}