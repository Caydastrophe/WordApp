package com.example.wordotest

import android.annotation.SuppressLint
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import kotlin.random.Random

class gameActivity : AppCompatActivity() {
    @SuppressLint("MissingInflatedId")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_game)

        val words = arrayOf<String>("red", "blue", "green", "orange", "purple", "black", "white", "cyan", "magenta")

        val charGuess = mutableListOf<Char>()

        val ranNum = Random.nextInt(0, words.size)
        var randomWord = words[ranNum]
        val dashes="_ ".repeat(randomWord.length)

        fun numDash(a:String) {
            var lengthDash = a
            val lengthTV: TextView = findViewById<TextView>(R.id.lengthTV)
            val dashes="_ ".repeat(lengthDash.length)
            lengthTV.text = dashes
        }
        numDash(randomWord)

        fun refreshLives(a:Int) {
            var lives: Int = a;
            var healthTV = findViewById<TextView>(R.id.healthTV)
            healthTV.text = "Lives left : " + lives.toString()
        }
        fun refreshScore(a:Int) {
            var score = a;
            var scoreTV = findViewById<TextView>(R.id.scoreTV)
            scoreTV.text = "Score : " + score.toString()
        }

        fun checkChar (a:String, b:String) {
            var strA = a;
            var strB = b;
            var resultA = strA.toSet()
            var resultB = strB.toSet()
            if (resultA == resultB)
            {
                charGuess += resultA
            }
        }

        fun addChars() {
            var charTV = findViewById<TextView>(R.id.charTV)
            charTV.text = charGuess.joinToString { " " } ?:"_ _ _ _"
        }

        val guessBTN = findViewById<Button>(R.id.guessBTN)
        guessBTN.setOnClickListener() {
            var lives = 5;
            var score = 0;
            val guessET = findViewById<EditText>(R.id.guessET)
            numDash(randomWord)

            if (lives == 0) {
                var scoreTV = findViewById<TextView>(R.id.scoreTV)
                scoreTV.text = "Score : 000"
            }
            if ( guessET.text.toString() == randomWord) {
                randomWord += words[ranNum]
                Toast.makeText(this, "You got it!", Toast.LENGTH_LONG).show()
                guessET.getText().clear()
                score += 100;
                refreshScore(score)
                refreshLives(lives)
            }
            else {
                Toast.makeText(this, "please try again!", Toast.LENGTH_LONG).show()
                guessET.getText().clear()
                lives -= 1;
                refreshLives(lives)
                refreshScore(score)
                checkChar(guessET.text.toString(), randomWord)
                addChars()

            }
        }
    }
}