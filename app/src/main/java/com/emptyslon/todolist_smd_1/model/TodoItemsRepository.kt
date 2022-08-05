package com.emptyslon.todolist_smd_1.model

import android.graphics.Insets.add
import android.icu.text.SimpleDateFormat
import java.text.DateFormat.getDateInstance
import java.util.*
import kotlin.random.Random

class TodoItemsRepository {


    companion object {
        var toDoList: MutableList<TodoItem> = mutableListOf<TodoItem>()

        fun addToDO() {
        }
    }

    init {
        this.addFakeTasks()
    }


    fun addFakeTasks() {
        val dataFormat = SimpleDateFormat("dd.mm.yyyy")
        val random = Random(123)
        var fakeList = listOf(
            TodoItem(
                random.nextInt().toString(),
                "Постирать футболку",
                1,
                false,
                dataFormat.parse("05.07.2022")
            ),
            TodoItem(
                random.nextInt().toString(),
                "Постирать носки",
                2,
                false,
                dataFormat.parse("06.07.2022")
            ),
            TodoItem(
                random.nextInt().toString(),
                "Постирать трусы",
                3,
                false,
                dataFormat.parse("07.07.2022")
            ),
        )

        fakeList.forEach {
            toDoList.add(it)
        }

    }


}