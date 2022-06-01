package science.example.superheroes.model

import com.google.gson.annotations.SerializedName

data class ModelSuperheroesItem(
    val appearance: List<Any>,
    val better_call_saul_appearance: List<Int>,
    val birthday: String,
    val category: String,
    @SerializedName("char_id")
    val charId: Int,
    val img: String,
    val name: String,
    val nickname: String,
    val occupation: List<String>,
    val portrayed: String,
    val status: String
)

