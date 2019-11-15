package com.example.to_do

import android.os.Bundle
import android.util.Log
import androidx.appcompat.app.AppCompatActivity
import com.example.to_do.model.AppDatabase
import com.example.to_do.model.ToDo
import kotlinx.android.synthetic.main.activity_todo_edit.*
import java.text.SimpleDateFormat
import java.util.*
import android.content.Intent
import com.example.to_do.model.SharedPreferences


class ToDoCreate : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_edit)

        val db = AppDatabase(this)

        current_date_tv.text = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())

        initView()

        saveButton.setOnClickListener {
            val sharedPreference = SharedPreferences()

            var todo = ToDo()
            todo.userId = sharedPreference.getId(this)!!
            todo.todo = todo_Text_et.text.toString()
            todo.date = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault()).format(Date())

            try {
                db.todoDao().insert(todo)
            } catch (e: Exception) {
                Log.e("error inster ToDo", e.toString())
            } finally {
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }

        }
    }

    private fun initView() {

    }
}
