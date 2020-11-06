package com.example.youtubeclone.adapter

import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeclone.R
import com.example.youtubeclone.model.CourseLesson
import com.example.youtubeclone.ui.CourseLessonActivity
import com.squareup.picasso.Picasso
import kotlinx.android.synthetic.main.course_detail_row.view.*

class CourseDetailAdapter(val courseLesson: Array<CourseLesson>) : RecyclerView.Adapter<CourseDetailViewHolder>(){

    override fun getItemCount(): Int {
        return courseLesson.size
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseDetailViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val customView = layoutInflater.inflate(R.layout.course_detail_row, parent, false)

        return CourseDetailViewHolder(customView)

    }

    override fun onBindViewHolder(holder: CourseDetailViewHolder, position: Int) {
        val courseLesson = courseLesson.get(position)

        holder.customView.course_lesson_title.text = courseLesson.name
        holder.customView.course_duration.text = courseLesson.duration

        val imageView = holder.customView.course_lesson_image
        Picasso.with(holder.customView.context).load(courseLesson.imageUrl).into(imageView)

        holder.courseLesson = courseLesson
    }
}

public class CourseDetailViewHolder(val customView: View, var courseLesson: CourseLesson? = null): RecyclerView.ViewHolder(customView){

    companion object{
        const val COURSE_LESSON_LINK_KEY = "COURSE_LESSON_LINK"
    }

    init {
        customView.setOnClickListener{
                val intent = Intent(customView.context, CourseLessonActivity::class.java)

                intent.putExtra(COURSE_LESSON_LINK_KEY, courseLesson?.link)
                customView.context.startActivity(intent)
        }
    }
}