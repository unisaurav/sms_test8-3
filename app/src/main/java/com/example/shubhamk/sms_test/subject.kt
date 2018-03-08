package com.example.shubhamk.sms_test

import android.content.Context
import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.ViewGroup
import android.widget.Button
import android.widget.LinearLayout
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.shubhamk.sms_test.Constants.tid
import kotlinx.android.synthetic.main.activity_subject.*
import android.util.SparseBooleanArray



class subject : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_subject)
        var token=getSharedPreferences("user", Context.MODE_PRIVATE)

        tvuser.text=token.getString("loginuser"," ")
        var newtid=token.getString("tiddata"," ")
        btnlogout.setOnClickListener{
                var editor=token.edit()
                editor.putString("loginuser"," ")
                editor.commit()
                var tomain=Intent(this,MainActivity::class.java)
                startActivity(tomain)
                finish()
        }




        val tid = newtid
        val s = intent.getStringExtra("select")
        val url = "http://159.65.144.10/emb/subject.php?tid=" + tid
        val que = Volley.newRequestQueue(this@subject)
        val req = StringRequest(Request.Method.GET,url,Response.Listener {
            response ->
            val a = response.toString()
            val reg = Regex("(?<=[ ?])")
            var list = a.split(reg)
            list.forEach {
                if(it.toString() != "" ){
                    val btnShow = Button(this)
                    btnShow.setText(it)
                    btnShow.layoutParams = LinearLayout.LayoutParams(ViewGroup.LayoutParams.WRAP_CONTENT, ViewGroup.LayoutParams.WRAP_CONTENT)
                    linearlayout.addView(btnShow)
                    btnShow.setOnClickListener {
                        val i = Intent(this,student::class.java)
                        startActivity(i)
                    }
                }
            }
            println(list)
        },Response.ErrorListener {

        })
        que.add(req)
    }
}
