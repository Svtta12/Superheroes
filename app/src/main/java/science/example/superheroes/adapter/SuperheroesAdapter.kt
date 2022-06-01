package science.example.superheroes.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.ImageView
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import science.example.superheroes.R
import science.example.superheroes.model.ModelSuperheroesItem
import science.example.superheroes.databinding.ItemActivityBinding


class SuperheroesAdapter()
    : RecyclerView.Adapter<SuperheroesAdapter.SuperheroesViewHolder>(){

    private lateinit var mListener: onItemClickListener

    interface onItemClickListener {
        fun onItemClick(img: String, name: String, nickname: String, birthday: String, status: String, portrayed: String)
    }

    fun setOnItemClickListener(listener: onItemClickListener) {
        mListener = listener
    }

    var superheroesList : List<ModelSuperheroesItem> = listOf()

    override fun onCreateViewHolder(parent: ViewGroup,viewType: Int): SuperheroesViewHolder {
        val inflater = LayoutInflater.from(parent.context)
        val binding = ItemActivityBinding.inflate(inflater, parent, false)

        return SuperheroesViewHolder(binding, mListener)
    }

    override fun onBindViewHolder(holder: SuperheroesViewHolder, position: Int) {
        val superhero = superheroesList[position]
        with(holder.binding) {
            holder.itemView.tag = superhero

            textNameSuperheroes.text = superhero.name
            textTeamSuperheroes.text = superhero.nickname
            if (superhero.img.isNotBlank()) {
                Picasso.get()
                    .load(superhero.img)
                    .placeholder(R.drawable.ic_launcher_foreground)
                    .error(R.drawable.ic_launcher_foreground)
                    .into(imageSuperheroes)
            }
            else {
                imageSuperheroes.setImageResource(R.drawable.ic_launcher_foreground)
            }
        }
    }


    override fun getItemCount(): Int = superheroesList.size

   inner class SuperheroesViewHolder (val binding: ItemActivityBinding, listener: onItemClickListener)
        : RecyclerView.ViewHolder(binding.root){
        init {
            itemView.setOnClickListener {
                superheroesList?.get(position)?.let { it -> mListener.onItemClick(it.img, it.name,
                it.nickname, it.birthday, it.status, it.portrayed)
                }
            }
        }
    }

    @SuppressLint("NotifyDataSetChanged")
    fun setSuperheroesListItems(superList: List<ModelSuperheroesItem>){
        this.superheroesList = superList;
        notifyDataSetChanged()
    }

}