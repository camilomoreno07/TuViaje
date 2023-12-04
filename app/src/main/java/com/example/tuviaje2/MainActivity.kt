package com.example.tuviaje2

import android.content.Intent
import android.net.Uri
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import com.bumptech.glide.Glide
import com.bumptech.glide.load.engine.DiskCacheStrategy
import com.bumptech.glide.request.RequestOptions
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

        val imageView: ImageView = findViewById(R.id.animacionGif)
        var url = "https://urbavial.com/wp-content/uploads/2017/03/puente.gif";
        val options = RequestOptions().diskCacheStrategy(DiskCacheStrategy.ALL)
        Glide.with(this).load(url).apply(options).into(imageView)

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