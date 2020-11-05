package com.example.youtubeclone.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.youtubeclone.R

class CourseDetailAdapter : RecyclerView.Adapter<CourseDetailViewHolder>{
    override fun getItemCount(): Int {
        return 1
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): CourseDetailViewHolder {

        val layoutInflater = LayoutInflater.from(parent.context)
        val customView = layoutInflater.inflate(R.layout.course_detail_row, parent, false)

        return CourseDetailViewHolder(customView)

    }

    override fun onBindViewHolder(holder: CourseDetailViewHolder, position: Int) {

    }
}

class CourseDetailViewHolder(val customView: View): RecyclerView.ViewHolder(customView)