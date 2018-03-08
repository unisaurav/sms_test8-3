package com.example.shubhamk.sms_test

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_changepassword.*

class changepassword : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_changepassword)
        val u = intent.getStringExtra("u")
        println(u)
        update.setOnClickListener {
            var i = inputpass.text.toString()
            var j = cpass.text.toString()
            if (i == j) {
                val url = "https://unribbed-headers.000webhostapp.com/shubham/update.php?username=" + u + "&password=" + i
                val que = Volley.newRequestQueue(this@changepassword)
                val req = StringRequest(Request.Method.GET, url, Response.Listener { response ->
                    val i = Intent(this, MainActivity::class.java)
                    Toast.makeText(this, "Password Updated!", Toast.LENGTH_LONG).show()
                    startActivity(i)
                }, Response.ErrorListener {
                    println("ERRR")
                })
                que.add(req)
            } else {
                Toast.makeText(this, "Match Error!", Toast.LENGTH_SHORT).show()
            }
        }
    }
}
