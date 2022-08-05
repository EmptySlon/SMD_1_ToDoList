package com.emptyslon.todolist_smd_1.model

import android.icu.text.SimpleDateFormat
import java.util.*


data class TaskItem(
    val id: String,
    var toDoText: String,
    var importance: Int = 1,
    var isMade: Boolean,
    var dataCreation : Date,
) {
}


