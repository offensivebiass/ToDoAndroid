package com.example.to_do

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.to_do.model.AppDatabase
import com.example.to_do.model.ToDo
import com.example.to_do.model.Users
import kotlinx.android.synthetic.main.activity_register.*

class RegisterActivity : Activity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_register)

        val db = AppDatabase(this)

        register_button.setOnClickListener {
            var user = Users()
            user.username = usernamer_et.text.toString()
            user.password = passwordr_et.text.toString()

            try {
                db.usersDao().insert(user)
            }catch (e : Exception) {
                Log.e("error inster ToDo", e.toString())
            } finally {
                val intent = Intent(this, MainActivity::class.java)
                intent.flags = Intent.FLAG_ACTIVITY_CLEAR_TOP
                startActivity(intent)
                finish()
            }

        }
    }

}
