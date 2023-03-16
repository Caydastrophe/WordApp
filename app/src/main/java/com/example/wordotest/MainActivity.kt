package com.example.wordotest

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.Toast

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val playBTN = findViewById<Button>(R.id.playBTN)
        val namePT = findViewById<EditText>(R.id.namePT)
        val wordBTN = findViewById<Button>(R.id.wordBTN)

        //var output  =  "Hello" + namePT.text

        playBTN.setOnClickListener() {

            if(namePT.text.isNotEmpty()) {
                Toast.makeText(this, "hello " + namePT.text, Toast.LENGTH_LONG).show()
                val intent = Intent(this@MainActivity,gameActivity::class.java)
                intent.putExtra("name", namePT.text )
                startActivity(intent)
            } else {
                Toast.makeText(this, "Please enter a name :)", Toast.LENGTH_LONG).show()
            }
        }

        wordBTN.setOnClickListener() {
            if(namePT.text.isNotEmpty()) {
                Toast.makeText(this, "hello " + namePT.text, Toast.LENGTH_LONG).show()
                val intent = Intent(this@MainActivity, wordActivity::class.java)
                intent.putExtra("name", namePT.text )
                startActivity(intent)
            } else {
                Toast.makeText(this, "Viewing as Anonymous", Toast.LENGTH_LONG).show()
                val intent = Intent(this@MainActivity, wordActivity::class.java)
                startActivity(intent)
            }

        }

    }
}