package com.example.to_do

import android.content.Intent
import android.os.Bundle
import android.util.Log
import android.view.View
import androidx.appcompat.app.AppCompatActivity
import com.example.to_do.model.AppDatabase
import com.example.to_do.model.SharedPreferences
import com.example.to_do.model.ToDo
import kotlinx.android.synthetic.main.activity_todo_edit.*
import java.text.SimpleDateFormat
import java.util.*
import androidx.core.app.ComponentActivity
import androidx.core.app.ComponentActivity.ExtraData
import androidx.core.content.ContextCompat.getSystemService
import android.icu.lang.UCharacter.GraphemeClusterBreak.T


class ToDoEdit : AppCompatActivity() {

    lateinit var db: AppDatabase
    var id: Int = 0
    lateinit var todo: ToDo

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_todo_edit)
        deleteButton.visibility = View.VISIBLE

        val intent = intent
        id = intent.getIntExtra("ID_TODO", 0)

        db = AppDatabase(this)

        initView()

        saveButton.setOnClickListener {

            todo.todo = todo_Text_et.text.toString()

            try {
                db.todoDao().update(todo)
            } catch (e: Exception) {
                Log.e("error inster ToDo", e.toString())
            } finally {
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }

        }

        deleteButton.setOnClickListener {
            try {
                db.todoDao().delete(todo)
            } catch (e: Exception) {
                Log.e("error insert ToDo", e.toString())
            } finally {
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }
        }

    }

    private fun initView() {
        todo = db.todoDao().geToDoEdit(id)

        current_date_tv.text = todo.date
        current_date_tv.text = todo.date
        todo_Text_et.setText(todo.todo)

    }

}