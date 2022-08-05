package com.emptyslon.todolist_smd_1

import android.content.Intent
import android.support.v7.widget.RecyclerView
import android.view.LayoutInflater
import android.view.ViewGroup
import com.emptyslon.todolist_smd_1.databinding.TaskItemBinding
import com.emptyslon.todolist_smd_1.model.TaskItemsRepository


class AdapterTasks() : RecyclerView.Adapter<AdapterTasks.TasksHolder>() {


    class TasksHolder(val binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.txTaskRecycle.text = TaskItemsRepository.toDoList[position].toDoText
            binding.checkBoxCompletedTaskRecycle.setOnClickListener {
                TaskItemsRepository.toDoList[position].isMade = it.isActivated
            }
            binding.imgInfoRecycle.setOnClickListener {
                val myIntent = Intent(it.context, DetailsTaskActivity::class.java)
                myIntent.putExtra("position", position)
                it.context.startActivity(myIntent)

            }


        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): AdapterTasks.TasksHolder {
        val binding = TaskItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return AdapterTasks.TasksHolder(binding)
    }

    override fun onBindViewHolder(holder: TasksHolder, position: Int) {
        holder.bind(position)
    }

    override fun getItemCount(): Int = TaskItemsRepository.toDoList.size

}