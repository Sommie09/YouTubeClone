package com.example.youtubeclone.ui

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.youtubeclone.R
import com.example.youtubeclone.adapter.CourseDetailAdapter
import com.example.youtubeclone.adapter.CustomViewHolder
import com.example.youtubeclone.model.CourseLesson
import com.google.gson.GsonBuilder
import kotlinx.android.synthetic.main.activity_course_detail.*
import okhttp3.*
import java.io.IOException

class CourseDetailActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_detail)

        val navBarTitle = intent.getStringExtra(CustomViewHolder.VIDEO_TITLE_KEY)
        supportActionBar?.title= navBarTitle

        fetchJSON()

        recycler_view_course_detail.layoutManager = LinearLayoutManager(this)


    }

    private fun fetchJSON() {
        val video_id = intent.getIntExtra(CustomViewHolder.VIDEO_ID_KEY, -1)

        val course_detail_url = "https://api.letsbuildthatapp.com/youtube/course_detail?id=$video_id"

        val client = OkHttpClient()
        val request = Request.Builder().url(course_detail_url).build()

        client.newCall(request).enqueue(object : Callback{
            override fun onResponse(call: Call, response: Response) {
                val body = response.body?.string()

                val gson = GsonBuilder().create()

                val course_lessons = gson.fromJson(body, Array<CourseLesson>::class.java)

                runOnUiThread {  recycler_view_course_detail.adapter = CourseDetailAdapter(course_lessons) }

            }

            override fun onFailure(call: Call, e: IOException) {

            }
        })
    }
}