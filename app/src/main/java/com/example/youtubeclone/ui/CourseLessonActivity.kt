package com.example.youtubeclone.ui

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.example.youtubeclone.R
import com.example.youtubeclone.adapter.CourseDetailAdapter
import com.example.youtubeclone.adapter.CourseDetailViewHolder
import kotlinx.android.synthetic.main.activity_course_lesson.*

class CourseLessonActivity : AppCompatActivity() {

    @SuppressLint("SetJavaScriptEnabled")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_course_lesson)

        val course_link = intent.getStringExtra(CourseDetailViewHolder.COURSE_LESSON_LINK_KEY)

        web_view_course_lesson.settings.javaScriptEnabled = (true)
        web_view_course_lesson.settings.loadWithOverviewMode = (true)
        web_view_course_lesson.settings.useWideViewPort = (true)




        if (course_link != null) {
            web_view_course_lesson.loadUrl(course_link)
        }
    }


}