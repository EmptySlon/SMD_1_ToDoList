package com.emptyslon.todolist_smd_1

import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.support.v7.widget.LinearLayoutManager
import com.emptyslon.todolist_smd_1.databinding.ActivityMainBinding
import java.util.*

class MainActivity : AppCompatActivity() {

    lateinit var binding:ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        supportActionBar?.hide()

        binding.recycleTasks.layoutManager = LinearLayoutManager(this)
        val adapterTasks = AdapterTasks()
        binding.recycleTasks.adapter =adapterTasks





    }
}