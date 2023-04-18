package com.ompava.p2_master_detail_series.Adapter


import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.RatingBar
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.ompava.p2_master_detail_series.Extension.toBitmap
import com.ompava.p2_master_detail_series.Interface.OnItemClick
import com.ompava.p2_master_detail_series.Model.SerieModel
import com.ompava.p2_master_detail_series.databinding.ListItemBinding


class MyItemRecyclerViewAdapter(
    private val serieList: List<SerieModel>,
    private val listener: OnItemClick?
) : RecyclerView.Adapter<MyItemRecyclerViewAdapter.ViewHolder>() {

    //Creates a ViewHolder for every item of the list (superHeroList)
    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {


        return ViewHolder(
            ListItemBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )

    }

    //In this function customize our ViewHolder with its data depending on the position
    override fun onBindViewHolder(holder: ViewHolder, position: Int) {

        val serie = serieList[position]
        holder.tvListName.text = serie.name
        holder.tvListLanguage.text = serie.language
        holder.rbListRatingBar.rating = serie.rating


        //We are using an extension toBipmap
        holder.ivListImage.setImageBitmap(serie.image.toBitmap(holder.ivListImage.context))

        //We set the tag with superhero data, in order to obtain its data in the listener
        holder.itemView.tag = serie

        holder.itemView.setOnClickListener(holder) //Our ViewHolder implements OnClickListener
    }

    //We need to know the length of the list. It will be the size of out data list
    override fun getItemCount(): Int = serieList.size

    //This inner class contains all view of each item on list_item.xml
    inner class ViewHolder(binding: ListItemBinding) : RecyclerView.ViewHolder(binding.root), View.OnClickListener {
        val tvListName: TextView = binding.tvListName
        val tvListLanguage: TextView = binding.tvListLanguage
        val rbListRatingBar: RatingBar = binding.rbRating
        val ivListImage: ImageView = binding.ivListImage

        override fun toString(): String {
            return super.toString() + " ${tvListName.text}"
        }

        override fun onClick(v: View?) {

            //First we recovery de superHero through the tag. Remember we have set it before (onBindViewHolder)
            val serie = v?.tag as SerieModel

            //later we call our callback with the SuperHero param to inform ListFragment, and then MainActivity
            listener?.onItemClick(serie)
        }
    }

}