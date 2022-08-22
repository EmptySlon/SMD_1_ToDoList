package com.emptyslon.todolist_smd_1

import android.content.Intent
import android.graphics.Paint
import android.support.v7.widget.RecyclerView
import android.util.Log
import android.view.LayoutInflater
import android.view.ViewGroup
import android.widget.CheckBox
import com.emptyslon.todolist_smd_1.databinding.TaskItemBinding
import com.emptyslon.todolist_smd_1.model.TaskItemsRepository


class AdapterTasks() : RecyclerView.Adapter<AdapterTasks.TasksHolder>() {


    class TasksHolder(val binding: TaskItemBinding) : RecyclerView.ViewHolder(binding.root) {

        fun bind(position: Int) {
            binding.txTaskRecycle.text = TaskItemsRepository.toDoList[position].toDoText
            binding.checkBoxCompletedTaskRecycle.isChecked = TaskItemsRepository.toDoList[position].isMade
            changeFromCheckBox( binding.checkBoxCompletedTaskRecycle)
            Log.d("MyTag", binding.txTaskRecycle.paintFlags.toString() )
            binding.checkBoxCompletedTaskRecycle.setOnClickListener {
                changeFromCheckBox( binding.checkBoxCompletedTaskRecycle)
            }
            binding.imgInfoRecycle.setOnClickListener {
                val myIntent = Intent(it.context, DetailsTaskActivity::class.java)
                myIntent.putExtra("position", position)
                Log.d("MyTag", position.toString() )
                it.context.startActivity(myIntent)

            }


        }

        fun changeFromCheckBox (checkBox: CheckBox) {
            if (checkBox.isChecked) {
                binding.txTaskRecycle.setTextColor(binding.root.context.getColor(R.color.label_secondary))
                binding.txTaskRecycle.paintFlags = Paint.STRIKE_THRU_TEXT_FLAG
            } else {
                binding.txTaskRecycle.setTextColor(binding.root.context.getColor(R.color.label_primary))
                binding.txTaskRecycle.paintFlags = 0
            }
            TaskItemsRepository.toDoList[adapterPosition].isMade = checkBox.isActivated
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