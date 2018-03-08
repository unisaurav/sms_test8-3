package com.example.shubhamk.sms_test

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_select.*

class select : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_select)
        theory.setOnClickListener {
            val i = Intent(this,subject::class.java)
            i.putExtra("select","t")
            startActivity(i)
        }
        tutorial.setOnClickListener {
            val i = Intent(this,subject::class.java)
            i.putExtra("select","t")
            startActivity(i)
        }
        practical.setOnClickListener {
            val i = Intent(this,subject::class.java)
            i.putExtra("select","p")
            startActivity(i)
        }
    }
}
