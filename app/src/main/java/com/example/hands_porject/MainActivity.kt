package com.example.hands_porject

import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.EditText
import android.widget.TextView
import androidx.annotation.RequiresApi

class MainActivity : AppCompatActivity() {
    @RequiresApi(Build.VERSION_CODES.O)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val et = findViewById<EditText>(R.id.input)
        val bt = findViewById<Button>(R.id.submit)
        val tv1 = findViewById<TextView>(R.id.total)
        val tv2 = findViewById<TextView>(R.id.totalRelax)

        bt.setOnClickListener {
            val input = et.text.toString();
            if (input != null && !input.isEmpty()) {
                val arr = input.split(",");
                val a = arr[0].toInt();
                val b = arr[0].toInt();
                EventCalculation().countTotalEvent(a, b);
            }
        }
    }
}