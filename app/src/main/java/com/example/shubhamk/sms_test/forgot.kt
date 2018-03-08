package com.example.shubhamk.sms_test

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_forgot.*

class forgot : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_forgot)
        generate.setOnClickListener {
            val username = email.text.toString()
            println(username)
            val url = "http://159.65.144.10/emb/email.php?username="+ username
            val que = Volley.newRequestQueue(this@forgot)
            val req = StringRequest(Request.Method.GET,url,Response.Listener {
                response ->
                val i = Intent(this,enterotp::class.java)
                i.putExtra("fu",username)
                startActivity(i)
            },Response.ErrorListener {

            })
            que.add(req)

        }

    }
}
