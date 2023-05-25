package com.example.myquiz

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.widget.Button
import android.widget.RadioButton
import android.widget.RadioGroup
import android.widget.TextView
import com.example.myquiz.GeoApiService
import com.example.myquiz.R
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import retrofit2.Retrofit
import retrofit2.converter.gson.GsonConverterFactory

class MainActivity5 : AppCompatActivity() {

    private lateinit var txtId: TextView
    private lateinit var optionsRadioGroup: RadioGroup
    private lateinit var option1: RadioButton
    private lateinit var option2: RadioButton
    private lateinit var option3: RadioButton
    private lateinit var questionNo:TextView
    private lateinit var option4: RadioButton
    private lateinit var nextButton: Button

    private var currentQuestionIndex = 0

    private lateinit var questions: List<GeoDataItem>

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main5)
        questionNo=findViewById(R.id.questionNo)
        txtId = findViewById(R.id.txtId)
        optionsRadioGroup = findViewById(R.id.options)
        option1 = findViewById(R.id.option1)
        option2 = findViewById(R.id.option2)
        option3 = findViewById(R.id.option3)
        option4 = findViewById(R.id.option4)
        nextButton = findViewById(R.id.nextButton)

        val retrofit = Retrofit.Builder()
            .baseUrl("https://opentdb.com//")
            .addConverterFactory(GsonConverterFactory.create())
            .build()

        val apiService = retrofit.create(GeoApiService::class.java)
        val call = apiService.getQuizData()

        call.enqueue(object : Callback<GeoQuizResponse> {
            override fun onResponse(call: Call<GeoQuizResponse>, response: Response<GeoQuizResponse>) {
                if (response.isSuccessful) {
                    val quizResponse = response.body()
                    questions = quizResponse?.results ?: emptyList()
                    if (questions.isNotEmpty()) {
                        displayQuestion(currentQuestionIndex)
                    }
                } else {
                    Log.e("MainActivity5", "Response not successful: ${response.code()}")
                }
            }

            override fun onFailure(call: Call<GeoQuizResponse>, t: Throwable) {
                Log.e("MainActivity5", "API call failed: ${t.message}")
            }
        })
        val name = intent.getStringExtra("Name")
        nextButton.setOnClickListener {
            currentQuestionIndex++
            if (currentQuestionIndex < questions.size) {
                displayQuestion(currentQuestionIndex)
            }
            if (currentQuestionIndex == questions.size - 1) {
                nextButton.text = "Submit"
            }
            if(currentQuestionIndex==questions.size) {
                val chosenId = optionsRadioGroup.checkedRadioButtonId
                if (chosenId == R.id.option4) {
                    score += 100
                }
            }
            if(currentQuestionIndex==questions.size){

                val intent= Intent(this,MainActivity8::class.java)
                intent.putExtra("Name",name)
                intent.putExtra("SCORE", score)
                startActivity(intent)
            }
        }
    }


    var score = 0;

    private fun displayQuestion(index: Int) {
        questionNo.text="${index+1}/5"
        val question = questions[index]
        txtId.text = question.question
        var correctId =0
        var i =(1..4).random()
        if(i==1){
            option1.text=question.correct_answer
            correctId=R.id.option1
        }
        if(i==2){
            option2.text=question.correct_answer
            correctId=R.id.option2
        }
        if(i==3){
            option3.text=question.correct_answer
            correctId=R.id.option3
        }
        if(i==4){
            option4.text=question.correct_answer
            correctId=R.id.option4
        }

        if(option1.text==question.correct_answer){
            option2.text = question.incorrect_answers[1]
            option3.text = question.incorrect_answers[2]
            option4.text = question.incorrect_answers[0]
        }
        else if(option2.text==question.correct_answer){
            option1.text = question.incorrect_answers[1]
            option3.text = question.incorrect_answers[2]
            option4.text = question.incorrect_answers[0]
        }
        else if (option3.text==question.correct_answer){
            option2.text = question.incorrect_answers[1]
            option1.text = question.incorrect_answers[2]
            option4.text = question.incorrect_answers[0]
        }
        else{
            option2.text = question.incorrect_answers[1]
            option3.text = question.incorrect_answers[2]
            option1.text = question.incorrect_answers[0]
        }


        val chosenId = optionsRadioGroup.checkedRadioButtonId

        if(chosenId==correctId){
            score+=100
        }
        optionsRadioGroup.clearCheck()

    }



}