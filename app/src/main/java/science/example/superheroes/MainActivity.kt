package science.example.superheroes

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import androidx.recyclerview.widget.LinearLayoutManager
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import science.example.superheroes.adapter.SuperheroesAdapter
import science.example.superheroes.data.ApiInterface
import science.example.superheroes.databinding.ActivityMainBinding
import science.example.superheroes.model.ModelSuperheroesItem

class MainActivity : AppCompatActivity(){

    private lateinit var binding: ActivityMainBinding
    private lateinit var adapter: SuperheroesAdapter

    val layoutManager = LinearLayoutManager(this)

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        adapter = SuperheroesAdapter()
        adapter.setOnItemClickListener(object : SuperheroesAdapter.onItemClickListener{
            override fun onItemClick(img: String, name: String, nickname: String, birthday: String, status: String, portrayed: String) {
                val intent = Intent(this@MainActivity, SecondActivity::class.java)
                intent.putExtra("img", img)
                intent.putExtra("name", name)
                intent.putExtra("nickname", nickname)
                intent.putExtra("birthday", birthday)
                intent.putExtra("status", status)
                intent.putExtra("portrayed", portrayed)
                startActivity(intent)
            }


        })

        val apiInterface = ApiInterface.create().getSuperheroes()

        binding.recyclerview.layoutManager = layoutManager
        binding.recyclerview.adapter = adapter

        apiInterface.enqueue(object : Callback<List<ModelSuperheroesItem>> {
            override fun onResponse(
                call: Call<List<ModelSuperheroesItem>>,
                response: Response<List<ModelSuperheroesItem>>
            ) {
                if(response.body() != null)
                adapter.setSuperheroesListItems(response.body()!!)
            }

            override fun onFailure(call: Call<List<ModelSuperheroesItem>>, t: Throwable) {

            }

        } )

    }

}