package science.example.superheroes

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ImageView
import android.widget.TextView
import com.squareup.picasso.Picasso
import science.example.superheroes.databinding.ActivitySecondBinding


class SecondActivity : AppCompatActivity() {

    private lateinit var binding: ActivitySecondBinding

    private lateinit var imageViewDetails: ImageView
    private lateinit var textNameDetails: TextView
    private lateinit var textNicknameDetails: TextView
    private lateinit var textBirthday: TextView
    private lateinit var textStatus: TextView
    private lateinit var textPortrayed: TextView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.activity_second)
        binding = ActivitySecondBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val img = intent.getStringExtra("img")
        val name = intent.getStringExtra("name")
        val nickname = intent.getStringExtra("nickname")
        val birthday = intent.getStringExtra("birthday")
        val status = intent.getStringExtra("status")
        val portrayed = intent.getStringExtra("portrayed")

        imageViewDetails = findViewById(R.id.image_superheroes_detail)
        textNameDetails = findViewById(R.id.text_name)
        textNicknameDetails = findViewById(R.id.text_nickname)
        textBirthday = findViewById(R.id.text_birthday)
        textStatus = findViewById(R.id.text_status)
        textPortrayed = findViewById(R.id.text_portrayed)

        Picasso.get().load(img)
            .placeholder(R.drawable.ic_launcher_foreground)
            .error(R.drawable.ic_launcher_foreground)
            .into(imageViewDetails)
        textNameDetails.text = name
        textNicknameDetails.text = nickname
        textBirthday.text = birthday
        textStatus.text = status
        textPortrayed.text = portrayed


    }
}