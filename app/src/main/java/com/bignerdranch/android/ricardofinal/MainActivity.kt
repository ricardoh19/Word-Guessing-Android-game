package com.bignerdranch.android.ricardofinal

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import android.widget.TextView
import android.widget.Toast
import androidx.core.view.isInvisible
import androidx.core.view.isVisible

class MainActivity : AppCompatActivity() {

    private lateinit var Button1: Button
    private lateinit var Button2: Button
    private lateinit var Button3: Button
    private lateinit var Button4: Button
    private lateinit var Button5: Button
    private lateinit var Button6: Button
    private lateinit var Button7: Button
    private lateinit var Button8: Button
    private lateinit var Button9: Button

    private lateinit var questionTextView: TextView
    private lateinit var scoreTextView: TextView
    private lateinit var  replayButton: Button


    private var score = 0



    private val wordBank = listOf("eavesdrop",
            "general", "default", "tower" , "zebra",
            "majority", "excuse" ,"rich", "bundle")


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)


        Button1 = findViewById(R.id.button1)
        Button2 = findViewById(R.id.button2)
        Button3 = findViewById(R.id.button3)
        Button4 = findViewById(R.id.button4)
        Button5 = findViewById(R.id.button5)
        Button6 = findViewById(R.id.button6)
        Button7 = findViewById(R.id.button7)
        Button8 = findViewById(R.id.button8)
        Button9 = findViewById(R.id.button9)
        questionTextView = findViewById(R.id.question_text_view)
        scoreTextView = findViewById(R.id.score_text_view)
        replayButton = findViewById(R.id.replay_text_view)

        var numbers = mutableListOf(0,1,2,3,4,5,6,7,8)

        var questionNewIndex = numbers.shuffled().first()
        var newWord = wordBank[questionNewIndex]
        questionTextView.text = "Guess where the following word is: $newWord"


        Button1.setOnClickListener {
            val newIndex = numbers.shuffled().first()
            Button1.text = wordBank[newIndex]
            numbers.remove(newIndex);
            Button1.isEnabled = false;
            checkAnswer(newWord, wordBank[newIndex])
        }
        Button2.setOnClickListener {
            val newIndex = numbers.shuffled().first()
            Button2.text = wordBank[newIndex]
            numbers.remove(newIndex);
            Button2.isEnabled = false;
            checkAnswer(newWord, wordBank[newIndex])
        }
        Button3.setOnClickListener {
            val newIndex = numbers.shuffled().first()
            Button3.text = wordBank[newIndex]
            numbers.remove(newIndex);
            Button3.isEnabled = false;
            checkAnswer(newWord, wordBank[newIndex])
        }
        Button4.setOnClickListener {
            val newIndex = numbers.shuffled().first()
            Button4.text = wordBank[newIndex]
            numbers.remove(newIndex);
            Button4.isEnabled = false;
            checkAnswer(newWord, wordBank[newIndex])
        }
        Button5.setOnClickListener {
            val newIndex = numbers.shuffled().first()
            Button5.text = wordBank[newIndex]
            numbers.remove(newIndex);
            Button5.isEnabled = false;
            checkAnswer(newWord, wordBank[newIndex])
        }
        Button6.setOnClickListener {
            val newIndex = numbers.shuffled().first()
            Button6.text = wordBank[newIndex]
            numbers.remove(newIndex);
            Button6.isEnabled = false;
            checkAnswer(newWord, wordBank[newIndex])
        }
        Button7.setOnClickListener {
            val newIndex = numbers.shuffled().first()
            Button7.text = wordBank[newIndex]
            numbers.remove(newIndex);
            Button7.isEnabled = false;
            checkAnswer(newWord, wordBank[newIndex])
        }
        Button8.setOnClickListener {
            val newIndex = numbers.shuffled().first()
            Button8.text = wordBank[newIndex]
            numbers.remove(newIndex);
            Button8.isEnabled = false;
            checkAnswer(newWord, wordBank[newIndex])
        }
        Button9.setOnClickListener {
            val newIndex = numbers.shuffled().first()
            Button9.text = wordBank[newIndex]
            numbers.remove(newIndex);
            Button9.isEnabled = false;
            checkAnswer(newWord, wordBank[newIndex])
        }

        //REPLAY button
        replayButton.setOnClickListener{
            this.score = 0
            scoreTextView.text = ""


            for ( i in 1..9){
                var id:Int = resources.getIdentifier("button$i","id", packageName)
                var btn:Button = findViewById(id) as Button
                btn.isEnabled = true
                btn.text = "?"
            }


            replayButton.setVisibility(View.INVISIBLE)
            numbers = mutableListOf(0,1,2,3,4,5,6,7,8)
            questionNewIndex = numbers.shuffled().first()
            newWord = wordBank[questionNewIndex]
            questionTextView.text = "Guess where the following word is: $newWord"
        }
    }

    private fun checkAnswer(questionWord: String, newWord:String){
        if (questionWord == newWord){
            this.score++;

            for ( i in 1..9){
                var id:Int = resources.getIdentifier("button$i","id", packageName)
                var btn:Button = findViewById(id) as Button
                btn.isEnabled = false
            }

            scoreTextView.text = "Number of trials needed: " + this.score.toString()
            replayButton.setVisibility(View.VISIBLE)
        }
        else{
            this.score++;
            scoreTextView.text = "Number of trials needed: " + this.score.toString()

        }
    }

}