package com.example.shubhamk.sms_test

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.shubhamk.sms_test.Constants.tid
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        var token=getSharedPreferences("user", Context.MODE_PRIVATE)

        if(token.getString("loginuser"," ")!=" "){
            var tosub=Intent(this,subject::class.java)
            startActivity(tosub)
            finish()
        }

        button.setOnClickListener {
            val user = email.text
            val pass = pass.text
            val url = "http://159.65.144.10/emb/user.php?username=" + user + "&password=" + pass
            println(url)
            val que = Volley.newRequestQueue(this@MainActivity)
            val req = StringRequest(Request.Method.GET,url,Response.Listener {
                response ->
                val a = response.toString()
                if(a != "Wrong Username or Password"){
                    Toast.makeText(this,a,Toast.LENGTH_SHORT).show()
                    val i = Intent(this,subject::class.java)
                    intent.putExtra("user",user)
                    var editor=token.edit()
                    editor.putString("loginuser", user.toString())
                    editor.putString("tiddata",a.toString())
                    editor.commit()
                    i.putExtra(tid,a)
                    startActivity(i)
                }else{
                    Toast.makeText(this,"Wrong usernamme or password",Toast.LENGTH_LONG).show()
                }
            },Response.ErrorListener {
                    Toast.makeText(this,"T_T",Toast.LENGTH_SHORT).show()
            })
            que.add(req)
        }
        forget.setOnClickListener {
            val i = Intent(this, forgot::class.java)
            startActivity(i)
        }
    }
}
