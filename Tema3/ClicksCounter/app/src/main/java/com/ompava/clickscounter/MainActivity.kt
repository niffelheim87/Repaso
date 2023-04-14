package com.ompava.clickscounter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import com.ompava.clickscounter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    var counter = 0 //creates a initial counter variable

    private lateinit var binding: ActivityMainBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.increaseCounter.setOnClickListener(){
            counter++
            binding.clicksCounter.setText("You have clicked $counter times")
        }

    }
}