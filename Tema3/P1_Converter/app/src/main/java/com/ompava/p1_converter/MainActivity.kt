package com.ompava.p1_converter

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.widget.Toast
import com.ompava.p1_converter.BinaryConverter
import com.ompava.p1_converter.databinding.ActivityMainBinding

class MainActivity : AppCompatActivity() {

    private lateinit var binding: ActivityMainBinding
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)

        // Crear una instancia de la clase BinaryConverter
        val etBinario = binding.etBinario
        val etDecimal = binding.etDecimal
        val swCambiar = binding.swCambiar
        val binaryConverter = BinaryConverter()

        binding.BTNcalcular.setOnClickListener() {

            // Listener que comprueba si esta activado el switch
            val toDecimal = swCambiar.isChecked

            // El Switch está activado y cambia a decimal
            if (toDecimal) {
                // Comprobamos que etBinario no este vacio
                if (etBinario.text.isNotEmpty()) {
                    // Comprobamos que el numero sea Binario
                    if (binaryConverter.esBinario(etBinario.text.toString())) {
                        // Comprobamos que el numero Binario no exceda 10 caracteres
                        if (etBinario.text.toString().length < 11) {
                            etDecimal.setText(binaryConverter.binarioDecimal(etBinario.text.toString()))
                        } else {
                            // Código para manejar la situación en la que el número excede 10 caracteres
                            Toast.makeText(
                                this,
                                "El número Binario es mayor a 10 caracteres",
                                Toast.LENGTH_SHORT
                            ).show()
                        }

                    } else {
                        // Código para manejar la situación en la que el número no es binario
                        Toast.makeText(this, "El número no es binario", Toast.LENGTH_SHORT).show()
                    }
                } else {
                    // Código para manejar la situación en la que etBinario no este vacio
                    Toast.makeText(this, "El campo binario esta vacio", Toast.LENGTH_SHORT).show()
                }

                // El Switch está desactivado y cambia a binario
            } else {
                // Comprobamos que etDecimal no este vacio
                if (etDecimal.text.isNotEmpty()) {
                    // Comprobamos que el numero sea Entero
                    if (etDecimal.text.toString().toIntOrNull() != null) {
                        // Comprobamos que el numero sea positivo
                        if (etDecimal.text.toString().toInt() > 0) {

                            // Comprobamos que el numero Binario no exceda el valor maximo de 10 caracteres
                            if (binaryConverter.decimalBinario(etDecimal.text.toString())
                                    .toInt() < 1024
                            ) {
                                etBinario.setText(binaryConverter.decimalBinario(etDecimal.text.toString()))
                            } else {
                                // Código para manejar la situación en la que el número Binario excede 10 caracteres
                                Toast.makeText(
                                    this,
                                    "El número Binario es mayor a 10 caracteres",
                                    Toast.LENGTH_SHORT
                                ).show()
                            }

                        } else {
                            // Código para manejar la situación en la que el número no es positivo
                            Toast.makeText(
                                this, "El número Decimal no es positivo", Toast.LENGTH_SHORT
                            ).show()
                        }

                    } else {
                        // Código para manejar la situación en la que el número no es entero
                        Toast.makeText(
                            this, "El número Decimal no es entero", Toast.LENGTH_SHORT
                        ).show()
                    }


                } else {
                    // Código para manejar la situación en la que etDecimal no este vacio
                    Toast.makeText(this, "El campo Decimal esta vacio", Toast.LENGTH_SHORT).show()
                }

            }

        }

    }
}