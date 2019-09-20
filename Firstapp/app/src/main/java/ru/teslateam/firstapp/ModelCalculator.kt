package ru.teslateam.firstapp

//import android.content.res.Resources
import kotlin.math.pow


class ModelCalculator {
    private var x1 = 0.0 //Первая переменная
    private var x1t = -1 //Счетчик знаков после запятой. При нуле число целое
    private var x2 = 0.0 //Вторая переменная
    private var x2t = -1 //Счетчик знаков после запятой. При минус единице число не введено, при нуле целое
    private var operator = " "
    var status = " "
    var error = " "
    //private val errors = Resources.getSystem().getStringArray(R.array.error_array)

    fun nullElements(a: Double) {
        x1 *= a
        x1t = -1
        operator = " "
        x2 = 0.0
        x2t = -1
    }

    fun inputNumber(a: Int) {
        error = ""
        if (operator == " ") {
            if (x1t == -1) {
                nullElements(0.0)
                x1t = 0
            }
            if (x1t == 0) {
                x1 = x1 * 10 + a
                status = "${x1.toInt()}"
            } else {
                x1 += a / ((10.0).pow(x1t++))
                status = "$x1"
            }
        } else {
            if (x2t == -1)
                x2t++
            if (((x1.toInt()).toDouble()) == x1) {
                if (x2t == 0) {
                    x2 = x2 * 10 + a
                    status = "${x1.toInt()}$operator${x2.toInt()}"
                } else {
                    x2 += a / ((10.0).pow(x2t++))
                    status = "${x1.toInt()}$operator$x2"
                }
            } else {
                if (x2t == 0) {
                    x2 = x2 * 10 + a
                    status = "$x1$operator${x2.toInt()}"
                } else {
                    x2 += a / ((10.0).pow(x2t++))
                    status = "$x1$operator$x2"
                }
            }
        }
    }

    fun operation(b: String) {
        if (!((x1t == -1) && (x1 == 0.0))) {
            operator = b
            if (((x1.toInt()).toDouble()) == x1)
                status = "${x1.toInt()}$operator"
            else
                status = "$x1$operator"
            x2 = 0.0
            x2t = -1
        } else
            error = "1"
    }

    fun point() {
        if (x2t > -1) {
            if (x2t > 0)
                error = "3"
            else
                x2t = 1
            if (x1t == 0)
                status = "${x1.toInt()}$operator${x2.toInt()}."
            else
                status = "$x1$operator${x2.toInt()}."
        } else {
            if (x1t != 0)
                error = "3"
            else
                x1t = 1
            if (operator == " ")
                status = "${x1.toInt()}."
            else
                error = "2"
        }
    }

    fun calculation() {
        if ((operator != " ") && (x2t > -1)) {
            if (operator == "+") {
                x1 += x2
                status = "${x1.toInt()}"
                if ((x1 - x1.toInt()) != 0.0)
                    status = "$x1"
            }
            if (operator == "-") {
                x1 -= x2
                status = "${x1.toInt()}"
                if ((x1 - x1.toInt()) != 0.0)
                    status = "$x1"
            }
            if (operator == "/")
                if (x2 != 0.0) {
                    x1 /= x2
                    status = "${x1.toInt()}"
                    if ((x1 - x1.toInt()) != 0.0)
                        status = "$x1"
                } else
                    error = "0"
            if (operator == "*") {
                x1 *= x2
                status = "${x1.toInt()}"
                if ((x1 - x1.toInt()) != 0.0)
                    status = "$x1"
            }
            nullElements(1.0)
        }
    }
}