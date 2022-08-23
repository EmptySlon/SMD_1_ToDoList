package com.emptyslon.todolist_smd_1.model

import android.icu.text.SimpleDateFormat
import kotlin.random.Random

class TaskItemsRepository {

    companion object {
        var toDoList: MutableList<TaskItem> = mutableListOf<TaskItem>()

        fun addFakeTasks() {
            val dataFormat = SimpleDateFormat("dd.mm.yyyy")
            val random = Random(123)
            var fakeList = listOf(
                TaskItem(
                    random.nextInt().toString(),
                    "Постирать футболку",
                    1 ,
                    false,
                    dataFormat.parse("05.07.2022")
                ),
                TaskItem(
                    random.nextInt().toString(),
                    "Постирать носки",
                    2,
                    true,
                    dataFormat.parse("06.07.2022")
                ),
                TaskItem(
                    random.nextInt().toString(),
                    "Постирать трусы",
                    3,
                    false,
                    dataFormat.parse("07.07.2022")
                ),
                TaskItem(
                    random.nextInt().toString(),
                    "Постирать кепку",
                    3,
                    false,
                    null
                ),
            )

            fakeList.forEach {
                toDoList.add(it)
            }

        }

        init {
            addFakeTasks()
        }


    }

//    init {
//        this.addFakeTasks()
//    }





}