package com.example.myquiz


import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText

import com.example.myquiz.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory
import retrofit2.create
import retrofit2.http.Url
import java.net.InterfaceAddress

class MainActivity2 : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val history=findViewById<Button>(R.id.history)
        val politics=findViewById<Button>(R.id.politics)
        val geography=findViewById<Button>(R.id.geography)
        val sports=findViewById<Button>(R.id.sports)

        val nameId =findViewById<EditText>(R.id.name)
        val name = nameId.text

        history.setOnClickListener{
            val intent=Intent(this, MainActivity3::class.java)
            intent.putExtra("Name",name)
            startActivity(intent)
        }
        politics.setOnClickListener{
            val intent=Intent(this,MainActivity4::class.java)
            intent.putExtra("Name",name)
            startActivity(intent)
        }
        geography.setOnClickListener{
            val intent=Intent(this,MainActivity5::class.java)
            intent.putExtra("Name",name)
            startActivity(intent)
        }
        sports.setOnClickListener{
            val intent=Intent(this,MainActivity7::class.java)
            intent.putExtra("Name",name)
            startActivity(intent)
        }

    }
}