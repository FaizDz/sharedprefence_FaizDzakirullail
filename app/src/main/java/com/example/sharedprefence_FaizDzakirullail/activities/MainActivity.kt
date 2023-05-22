package com.example.sharedprefence_FaizDzakirullail.activities

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast


import com.example.sharedprefence_FaizDzakirullail.R
import com.example.sharedprefence_FaizDzakirullail.helper.Constant
import com.example.sharedprefence_FaizDzakirullail.helper.PreferenceHelper
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    lateinit var sharedPref: PreferenceHelper

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        sharedPref = PreferenceHelper(this)

        btn_login.setOnClickListener {
            if (editUsername.text.isNotEmpty() && editUsername.text.isNotEmpty()){
                sharedPref.put(Constant.PREF_USERNAME, editUsername.text.toString())
                sharedPref.put(Constant.PREF_PASSWORD, editPassword.text.toString())
                sharedPref.put(Constant.PREF_IS_LOGIN, true)
                Toast.makeText(applicationContext, "berhasil login",Toast.LENGTH_SHORT).show()
                moveIntent()

            }
        }

    }

    override fun onStart() {
        super.onStart()
        if (sharedPref.getBoolean(Constant.PREF_IS_LOGIN)){
            moveIntent()
        }
    }

    private fun moveIntent() {
        startActivity(Intent(this, NoteActivity::class.java))
        finish()
    }

}