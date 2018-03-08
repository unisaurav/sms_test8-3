package com.example.shubhamk.sms_test

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.CheckBox
import android.widget.TextView
import com.example.shubhamk.sms_test.R.layout.customadapter

class adapter(context:Context?, roll: Array<String?>): BaseAdapter()  {
    val context = context
    var roll = roll
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        var rview: View = LayoutInflater.from(context).inflate(R.layout.customadapter, null)
        val rollno:TextView = rview.findViewById(R.id.rollno)
        val box:CheckBox = rview.findViewById(R.id.checkbox)
        val t = roll[position]
        rollno.text = t.toString()
        return rview
    }

    override fun getItem(position: Int): String? {
        return roll[position]
    }

    override fun getItemId(position: Int): Long {
        return 0
    }

    override fun getCount(): Int {
        return roll.count()
    }

//    private class viewholder{
//        var rollnumber:TextView? = null
//        var box:CheckBox? = null
//    }
}
//RecyclerView
//class adapter(val context: Context, val rollnumber: Array<String?>) : RecyclerView.Adapter<adapter.holder>()
//{
//    override fun onBindViewHolder(holder: holder?, position: Int) {
//        holder?.bind(rollnumber[position], context )
//    }
//
//    override fun onCreateViewHolder(parent: ViewGroup?, viewType: Int): holder {
//        val view = LayoutInflater.from(parent?.context)
//                .inflate(R.layout.customadapter,parent,false)
//        return holder(view)
//    }
//
//    override fun getItemCount(): Int {
//        return rollnumber.count()
//    }
//
//    inner class holder(itemView: View?) : RecyclerView.ViewHolder(itemView) {
//        val rno = itemView?.findViewById<TextView>(R.id.rollno )
//        val box = itemView?.findViewById<CheckBox>(R.id.checkBox)
//
//        fun bind(trno: String?, context: Context) {
//            rno?.text = trno
//        }
//    }
//}


