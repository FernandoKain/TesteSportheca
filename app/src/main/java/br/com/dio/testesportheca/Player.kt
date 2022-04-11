package br.com.dio.testesportheca
import com.google.gson.annotations.SerializedName

data class Player(

    @SerializedName("img")
    var img: String,
    @SerializedName("name")
    var name: String,
    @SerializedName("percentual")
    var percentual: Int,
    @SerializedName("pos")
    var pos: String,
    @SerializedName("country")
    var country: String,

)
