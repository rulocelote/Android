package com.example.minitwitter.modules.tweet.view


import android.annotation.SuppressLint
import android.content.Context
import android.graphics.Typeface
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.example.minitwitter.R
import com.example.minitwitter.retrofit.api.data.response.Tweet
import com.example.minitwitter.utils.Constantes
import kotlinx.android.synthetic.main.item_list_tweet.view.*

class AdapterTweet(val lista:List<Tweet>,val context:Context): RecyclerView.Adapter<AdapterTweet.MiViewHolder>(){

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): MiViewHolder {
        return MiViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_list_tweet,
                parent,
                false
            )
        )
    }

    override fun getItemCount(): Int = lista.size

    @SuppressLint("ResourceAsColor")
    override fun onBindViewHolder(holder: MiViewHolder, position: Int) {
        holder.tvUsername.text = lista[position].user.username
        holder.tvMessage.text = lista[position].mensaje
        holder.tvLikeCount.text = lista[position].likes.size.toString()

        val photo = lista[position].user.photoUrl
        if(photo != ""){
            Glide.with(context)
                .load(Constantes.URL_PHOTO + photo)
                .into(holder.imgAvatar)
        }

        for(like in lista[position].likes){
            if(like.username.equals(lista[position].user.username)){
                Glide.with(context)
                    .load(R.drawable.ic_like)
                    .into(holder.imgLike)
                holder.tvLikeCount.setTextColor(R.color.pink)
                holder.tvLikeCount.setTypeface(null,Typeface.BOLD)
            }
        }

    }

    class MiViewHolder(itemView: View):RecyclerView.ViewHolder(itemView) {
        var imgAvatar = itemView.imageViewAvatar
        var tvUsername = itemView.textViewUsername
        var tvMessage = itemView.textViewMessage
        var imgLike = itemView.imgLike
        var tvLikeCount = itemView.textViewLike
    }
}