package science.example.superheroes.data


import retrofit2.Call
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.http.GET
import science.example.superheroes.model.ModelSuperheroesItem

interface ApiInterface {

    @GET("characters")
    fun getSuperheroes() : Call<List<ModelSuperheroesItem>>

    companion object {
        var BASE_URL = "https://www.breakingbadapi.com/api/"
        fun create(): ApiInterface {

            val retrofit = Retrofit.Builder()
                .addConverterFactory(GsonConverterFactory.create())
                .baseUrl(BASE_URL)
                .build()
            return retrofit.create(ApiInterface::class.java)

        }
    }
}
