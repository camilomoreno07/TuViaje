package com.example.tuviaje

import android.content.Intent
import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.tuviaje.adapter.InformeAdapter
import com.google.android.material.floatingactionbutton.FloatingActionButton

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val button = findViewById<FloatingActionButton>(R.id.button_add)

        button.setOnClickListener {
            // Call a function to handle the button click
            val intent = Intent(this, InformeActivity::class.java)
            startActivity(intent)
        }

        initRecyclerView()

    }

    fun initRecyclerView(){
        val recyclerView = findViewById<RecyclerView>(R.id.informes_view)
        recyclerView.layoutManager = LinearLayoutManager(this)
        recyclerView.adapter = InformeAdapter(InformesSingleton.informesList)
    }

}
