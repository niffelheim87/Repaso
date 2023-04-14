package com.ompava.p1_converter

import kotlin.math.pow

class BinaryConverter {

    fun binaryToDecimal(binary: String): Int {
        var decimal = 0
        var power = 0
        for (i in binary.length - 1 downTo 0) {
            if (binary[i] == '1') {
                decimal += 2.0.pow(power).toInt()
            }
            power++
        }
        return decimal
    }

    fun decimalToBinary(decimal: Int): String {
        var quotient = decimal
        var binary = ""
        do {
            binary = (quotient % 2).toString() + binary
            quotient /= 2
        } while (quotient != 0)
        return binary
    }


}