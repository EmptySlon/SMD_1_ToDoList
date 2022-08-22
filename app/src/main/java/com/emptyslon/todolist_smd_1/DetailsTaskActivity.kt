package com.emptyslon.todolist_smd_1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.emptyslon.todolist_smd_1.databinding.ActivityDetailsTaskBinding
import com.emptyslon.todolist_smd_1.model.TaskItemsRepository

class DetailsTaskActivity : AppCompatActivity() {
    lateinit var binding: ActivityDetailsTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val position = savedInstanceState?.getInt("position") ?: intent.extras?.getInt("position")
//        Log.d("MyTag", position?.toString() ?: "null")
        if (position != null) {
            val task = TaskItemsRepository.toDoList[position]
            binding.edNewTask.setText(task.toDoText, TextView.BufferType.EDITABLE)
            task.importance
        }


    }
}