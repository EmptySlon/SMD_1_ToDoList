package com.emptyslon.todolist_smd_1

import android.icu.text.SimpleDateFormat
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.widget.TextView
import com.emptyslon.todolist_smd_1.databinding.ActivityDetailsTaskBinding
import com.emptyslon.todolist_smd_1.model.TaskItemsRepository
import java.lang.Exception

class DetailsTaskActivity : AppCompatActivity() {
    private val listStatus = listOf("Нет", "Низкий", "Средний", "!! Высокий", )
    lateinit var binding: ActivityDetailsTaskBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailsTaskBinding.inflate(layoutInflater)
        setContentView(binding.root)
        binding.btClose.setOnClickListener {
            finish()
        }

        val position = savedInstanceState?.getInt("position") ?: intent.extras?.getInt("position")

//        Log.d("MyTag", position?.toString() ?: "null")
        if (position != null) {
            openTaskFromReposiroty(position)
        } else {

        }


    }

    private fun openTaskFromReposiroty(position: Int) {
        val dataFormat = SimpleDateFormat("dd.mm.yyyy")
        val task = TaskItemsRepository.toDoList[position]
        binding.edNewTask.setText(task.toDoText, TextView.BufferType.EDITABLE)
        try {
            binding.txImportanceValue.text = listStatus[task.importance]
        } catch (e: Exception) {
            binding.txImportanceValue.text = listStatus.first()
        }
        if (task.importance == 3) {
            binding.txImportanceValue.setTextColor(getColor(R.color.red))
        }
        if (task.dataCreation != null) {
            binding.txDateValue.text = dataFormat.format(task.dataCreation)
        }
    }
}