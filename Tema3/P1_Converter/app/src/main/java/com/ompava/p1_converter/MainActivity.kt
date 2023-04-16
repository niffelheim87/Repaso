package com.ompava.p1_converter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ompava.p1_converter.BinaryConverter
import com.ompava.p1_converter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    private val binaryConverter = BinaryConverter()
    private val MAX_BINARY_LENGTH = 10

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.BTNcalcular.setOnClickListener() {
            calcular()
        }
    }

    private fun calcular() {
        val etBinario = binding.etBinario
        val etDecimal = binding.etDecimal
        val swCambiar = binding.swCambiar

        if (swCambiar.isChecked) {
            val binario = etBinario.text.toString()
            if (validarBinario(binario)) {
                etDecimal.setText(binaryConverter.binarioDecimal(binario))
            }
        } else {
            val decimal = etDecimal.text.toString()
            if (validarDecimal(decimal)) {
                etBinario.setText(binaryConverter.decimalBinario(decimal))
            }
        }
    }

    private fun validarBinario(binario: String): Boolean {
        return if (binario.isEmpty()) {
            mostrarError("El campo binario está vacío")
            false
        } else if (!binaryConverter.esBinario(binario)) {
            mostrarError("El número no es binario")
            false
        } else if (binario.length > MAX_BINARY_LENGTH) {
            mostrarError("El número binario es mayor a 10 caracteres")
            false
        } else {
            true
        }
    }

    private fun validarDecimal(decimal: String): Boolean {
        return if (decimal.isEmpty()) {
            mostrarError("El campo decimal está vacío")
            false
        } else if (decimal.toIntOrNull() == null) {
            mostrarError("El número decimal no es entero")
            false
        } else if (decimal.toInt() <= 0) {
            mostrarError("El número decimal no es positivo")
            false
        } else {
            true
        }
    }

    private fun mostrarError(mensaje: String) {
        Toast.makeText(this, mensaje, Toast.LENGTH_SHORT).show()
    }
}
