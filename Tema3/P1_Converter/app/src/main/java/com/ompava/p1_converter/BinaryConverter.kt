package com.ompava.p1_converter

import kotlin.math.pow

class BinaryConverter {

    fun binarioDecimal(binary: String): String {
        var decimal = 0
        var power = 0
        for (i in binary.length - 1 downTo 0) {
            if (binary[i] == '1') {
                decimal += 2.0.pow(power).toInt()
            }
            power++
        }
        return decimal.toString()
    }

    fun decimalBinario(decimal: String): String {
        var quotient = decimal.toInt()
        var binary = ""
        do {
            binary = (quotient % 2).toString() + binary
            quotient /= 2
        } while (quotient != 0)
        return binary
    }

    fun esBinario(numero: String): Boolean {
        for (caracter in numero) {
            if (caracter != '0' && caracter != '1') {
                return false
            }
        }
        return true
    }


}