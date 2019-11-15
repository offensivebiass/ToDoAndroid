package com.example.to_do

import android.content.Context
import android.content.Intent
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.TextView
import androidx.cardview.widget.CardView
import androidx.recyclerview.widget.RecyclerView
import com.example.to_do.model.ToDo

class ToDoAdapter(val context : Context, val todoList: List<ToDo>): RecyclerView.Adapter<ToDoAdapter.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val v = LayoutInflater.from(parent.context).inflate(R.layout.item_todo, parent, false)
        return ViewHolder(v)
    }

    override fun getItemCount(): Int {
        return todoList.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        holder.bind(context, todoList[position])
    }

    class ViewHolder(itemView: View): RecyclerView.ViewHolder(itemView) {
        fun bind (context: Context, todo: ToDo){
            val tvDate = itemView.findViewById(R.id.date_tv) as TextView
            val tvToDO = itemView.findViewById(R.id.todo_text_tv) as TextView
            val cardItem = itemView.findViewById(R.id.card_item) as CardView
            tvDate.text = todo.date
            tvToDO.text = todo.todo
            cardItem.setOnClickListener {
                val intent = Intent(context, ToDoEdit::class.java)
                intent.putExtra("ID_TODO",todo.id)
                context.startActivity(intent)
            }
        }
    }


}