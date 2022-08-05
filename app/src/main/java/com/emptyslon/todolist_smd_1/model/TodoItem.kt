package com.emptyslon.todolist_smd_1.model

import android.icu.text.SimpleDateFormat
import java.util.*


data class TodoItem(
    val id: String,
    val toDoText: String,
    val importance: Int = 1,
    val isMade: Boolean,
    val dataCreation : Date,
) {
}


