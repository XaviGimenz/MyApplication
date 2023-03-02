package com.example.myapplication.activities

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.ListView
import com.example.myapplication.Models.Person
import com.example.myapplication.R
import com.example.myapplication.adapters.PersonAdapter
import com.example.myapplication.databinding.ActivityListViewBinding

class ListViewActivity : AppCompatActivity() {

    private lateinit var binding: ActivityListViewBinding
    private lateinit var adapter: PersonAdapter
    private lateinit var personList: List<Person>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityListViewBinding.inflate(layoutInflater)
        setContentView(binding.root)

        personList = getPersons()
        adapter = PersonAdapter(this, personList)
        val listen = findViewById<ListView>(R.id.listView)
        listen.adapter = adapter
    }
    private fun getPersons(): List<Person>{
        val listOfPeople = listOf(
            Person("alejandro", "Lora", 27),
            Person("Fernando","Vega", 37),
            Person("Alicia", "Gomez", 19),
            Person("Paula", "Escobar", 33),
            Person("Alberto", "Parada", 22),
            Person("Cristian","Romero", 44),
            Person("Octavio", "Hernadez", 30),
            Person("Yaiza", "Costi", 32),
            Person("Naomi", "Fernandez", 27),
            Person("Jason", "Otah", 16)
        )
        return listOfPeople
    }
}