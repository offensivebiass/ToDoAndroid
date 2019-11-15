package com.example.to_do

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_main.*
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do.model.AppDatabase
import com.example.to_do.model.SharedPreferences
import com.example.to_do.model.ToDo


class MainActivity : AppCompatActivity() {

    lateinit var todos : List<ToDo>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val db = AppDatabase(this)

        val sharedPreference = SharedPreferences()
        val id = sharedPreference.getId(this)!!

        todos = db.todoDao().getToDo(id)

        fab_add_new.setOnClickListener { addNewToDo() }

        setRecycler()
    }

    private fun setRecycler() {
        val recyclerView = findViewById<RecyclerView>(R.id.recyclerTodo)
        recyclerView.layoutManager = LinearLayoutManager(this, RecyclerView.VERTICAL, false)
        val adapter = ToDoAdapter(this, todos)
        recyclerView.adapter = adapter
    }

    fun addNewToDo() {
        val i = Intent(this, ToDoCreate::class.java)

        startActivity(i)
    }

    override fun onRestart() {
        super.onRestart()
        setRecycler()
    }
}
