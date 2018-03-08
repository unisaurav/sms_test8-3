package com.example.shubhamk.sms_test

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.support.v7.widget.LinearLayoutManager
import android.widget.ArrayAdapter
import com.android.volley.Request
import com.android.volley.Response
import com.android.volley.toolbox.StringRequest
import com.android.volley.toolbox.Volley
import com.example.shubhamk.sms_test.R.layout.customadapter
import kotlinx.android.synthetic.main.activity_student.*

class student : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_student)
        val url = "https://unribbed-headers.000webhostapp.com/shubham/student.php"
        val que = Volley.newRequestQueue(this@student)
        val req = StringRequest(Request.Method.GET,url,Response.Listener {
            response ->
            val a = response.toString()
            val reg = Regex("(?<=[ ?])")
            var list = a.split(reg)
            var listitem = arrayOfNulls<String>(list.size - 1)
            var checked = arrayOfNulls<String>(list.size - 1)
            var i = 0
            for(l in list){
                if(l != ""){
                    listitem[i] = list[i]
                    checked[i] = "0"
                }
                i += 1
            }
            var custadapter = adapter(this,listitem)
            roll.adapter = custadapter
        },Response.ErrorListener {

        })
        que.add(req)
    }
}
