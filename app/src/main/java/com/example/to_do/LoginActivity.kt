package com.example.to_do

import android.app.Activity
import android.content.Intent
import android.os.Bundle
import android.util.Log
import com.example.to_do.model.AppDatabase
import com.example.to_do.model.SharedPreferences
import kotlinx.android.synthetic.main.activity_login.*


class LoginActivity : Activity() {

    lateinit var db : AppDatabase

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_login)

        db = AppDatabase(this)

        login_button.setOnClickListener {
            validateUser()
        }

        register_btn.setOnClickListener {
            val i = Intent(this, RegisterActivity::class.java)
            startActivity(i)
        }
    }

    fun validateUser() {
        val id = db.usersDao().userLogin(username_et.text.toString(), password_et.text.toString())
        Log.e("id", id.toString())
        if (id > 0) {
            val sharedPreference = SharedPreferences()
            sharedPreference.save(this, id)
            val i = Intent(this, MainActivity::class.java)
            startActivity(i)
        }

    }
}
