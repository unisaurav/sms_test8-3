package com.example.shubhamk.sms_test

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import kotlinx.android.synthetic.main.activity_enterotp.*

class enterotp : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_enterotp)
        val user = intent.getStringExtra("fu")
        var otp = ""
        var inp:String
        val url = "http://159.65.144.10/emb/opt.php"
        val que = Volley.newRequestQueue(this@enterotp)
        val req = StringRequest(Request.Method.GET,url,Response.Listener {
            response ->
            println(response.toString())
            otp = response.toString()
        },Response.ErrorListener {
        })
        que.add(req)
        verify.setOnClickListener {
            inp = otpin.text.toString()
            if(otp == inp){
                Toast.makeText(this,"Wrong",Toast.LENGTH_SHORT).show()
            }else{
                val i = Intent(this,changepassword::class.java)
                println(user)
                i.putExtra("u",user)
                startActivity(i)
            }
        }
    }
}
