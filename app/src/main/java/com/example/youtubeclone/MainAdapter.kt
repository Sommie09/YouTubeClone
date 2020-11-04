package com.example.youtubeclone

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.video_row.view.*

class MainAdapter(val homeFeed: HomeFeed): RecyclerView.Adapter<CustomViewHolder>(){

    private val videoTitles = listOf("First", "Second", "Third")

    //NumberOfItems
    override fun getItemCount(): Int {
        return homeFeed.videos.count()
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CustomViewHolder {
        val layoutInflater = LayoutInflater.from(parent?.context)
        val cellForRow = layoutInflater.inflate(R.layout.video_row, parent, false)
        return CustomViewHolder(cellForRow)

    }

    override fun onBindViewHolder(holder: CustomViewHolder, position: Int) {
       val video = homeFeed.videos.get(position)
        holder.view.video_title_text_view?.text = video.name
        holder.view.channel_name.text = video.channel.name + " . " + "20K Views\n 4 Days ago"

        val imageView = holder.view.thumb_nail

        Picasso.with(holder.view.context).load(video.imageUrl).into(imageView)

        val profileView = holder.view.profile_view

        Picasso.with(holder.view.context).load(video.channel.profileImageUrl).into(profileView)

    }

}

class CustomViewHolder(val view : View): RecyclerView.ViewHolder(view){

}