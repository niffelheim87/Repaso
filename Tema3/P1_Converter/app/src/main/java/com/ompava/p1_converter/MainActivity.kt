package com.ompava.p1_converter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.ompava.p1_converter.BinaryConverter
import com.ompava.p1_converter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Crear una instancia de la clase BinaryConverter
        val binaryConverter = BinaryConverter()

        binding.swCambiar.setOnCheckedChangeListener { _, isChecked ->

            // código que ejecute cuando el Switch cambie de estado
            if (isChecked) {
                // El Switch está activado
            } else {
                // El Switch está desactivado
            }
        }

    }
}