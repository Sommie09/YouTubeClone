package com.example.youtubeclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeclone.model.HomeFeed
import com.example.youtubeclone.adapter.MainAdapter
import com.example.youtubeclone.R
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_video_feed.*
import okhttp3.*
import java.io.IOException

class VideoFeedActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_video_feed)

        recycler_view_video_feed.layoutManager = LinearLayoutManager(this)


        fetchJson()
    }

    fun fetchJson(){
        //Val is a string that does'nt change
        val url = "https://api.letsbuildthatapp.com/youtube/home_feed"

        val request = Request.Builder().url(url).build()

        val client = OkHttpClient()
        client.newCall(request).enqueue(object : Callback{
            override fun onFailure(call: Call, e: IOException) {
                println("Failed To Execute")
            }

            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()
                println(body)

                val gson = GsonBuilder().create()
                val homeFeed = gson.fromJson(body, HomeFeed::class.java)

                runOnUiThread{
                    recycler_view_video_feed.adapter =
                        MainAdapter(homeFeed)
                }

            }
        })
    }
}

