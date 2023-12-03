package com.example.tuviaje2

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import com.example.tuviaje2.controller.BackupActivity
import com.example.tuviaje2.controller.InformeActivity
import com.example.tuviaje2.controller.NewActivity

class MainActivity : AppCompatActivity() {

    private lateinit var btnNoticias: Button;
    private lateinit var btnInformes: Button;
    private lateinit var btnBackUp: Button;

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        btnNoticias = findViewById(R.id.noticiasBtn)
        btnInformes = findViewById(R.id.informesBtn)
        btnBackUp = findViewById(R.id.backUpBtn)

        btnNoticias.setOnClickListener(){
            val intent = Intent(this, NewActivity::class.java)
            startActivity(intent)
        }

        btnInformes.setOnClickListener(){
            val intent = Intent(this, InformeActivity::class.java)
            startActivity(intent)
        }

        btnBackUp.setOnClickListener(){
            val intent = Intent(this, BackupActivity::class.java)
            startActivity(intent)
        }

    }
}