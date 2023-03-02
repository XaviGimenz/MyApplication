package com.example.myapplication.adapters

import android.content.Context
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.TextView
import com.example.myapplication.Models.Person
import com.example.myapplication.R



class PersonAdapter(val context: Context, val list: List<Person>) : BaseAdapter(){

    private val mInflator: LayoutInflater = LayoutInflater.from(context)
    
    override fun getItem(position: Int): Any {
        return list[position]
    }

    override fun getItemId(position: Int): Long {
        return position.toLong()
    }
    
    override fun getCount(): Int {
        return list.size
    }
    
    override fun getView(position: Int, convertView: View?, parent: ViewGroup?): View {
        val view: View
        val vh: PersonViewHolder
        
        if(convertView == null){
            view = mInflator.inflate(R.layout.list_view_person,parent, false)
            vh = PersonViewHolder(view)
            view.tag = vh
        }else{
            view = convertView
            vh = view.tag as PersonViewHolder
        }
        val fullName = "${list[position].firstName}, ${list[position].lastName}"
        vh.fullName.text = fullName
        vh.age.text = "${list[position].age}"
        return view
    }

}

private class PersonViewHolder(view: View){

    val fllName = view.findViewById<TextView>(R.id.textViewName)
    val fage = view.findViewById<TextView>(R.id.textViewAge)
    val fullName: TextView = fllName
    val age: TextView = fage
}