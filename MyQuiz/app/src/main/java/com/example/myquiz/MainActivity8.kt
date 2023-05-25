package com.example.myquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView


class MainActivity8 : AppCompatActivity() {



    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main8)

         val txtScore=findViewById<TextView>(R.id.txtScore)
      //  val name = intent.getStringExtra("Name1")
        // Tried to add the name of the user after congratulations but its not working this way
       // val score = intent.getIntExtra("SCORE",0)

       val getName=findViewById<TextView>(R.id.getName)

        //getName.text="Congratulation!! "
        //txtScore.text = "You scored: $score"
        val bundle = intent.extras
        if (bundle != null){
            txtScore.text = "You Scored ${bundle.getInt("SCORE",0)}"
//            getName.text = "Congrats ${bundle.getString("Name")}"
            getName.text = "Congratulations!!"
        }

        var retryButton=findViewById<Button>(R.id.retryButton)
        retryButton.setOnClickListener{
            val intent= Intent(this,MainActivity::class.java)
            startActivity(intent)
        }
    }
}