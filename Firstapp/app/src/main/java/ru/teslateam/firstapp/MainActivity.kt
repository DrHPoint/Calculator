package ru.teslateam.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.*

//Model

class ModelCal {

    private var x1 = 0.0 //Первая переменная
    private var x1t = -1 //Счетчик знаков после запятой. При нуле число целое
    private var x2 = 0.0 //Вторая переменная
    private var x2t = -1 //Счетчик знаков после запятой. При минус единице число не введено, при нуле целое
    private var x = " " //Оператор
    var text = " "
    var text2 = " "

    private fun null2() {
        x1t = -1
        x = " "
        x2 = 0.0
        x2t = -1
    }

    fun inNull() {
        null2()
        x1 = 0.0
    }

    fun inputC(a: Double) {
        text2 = ""
        if (x == " ") {
            if (x1t == -1) {
                inNull()
                x1t = 0
            }
            if (x1t == 0) {
                x1 = x1 * 10 + a
                text = "${x1.toInt()}"
            } else {
                x1 += a / ((10.0).pow(x1t++))
                text = "$x1"
            }
        } else {
            if (x2t == -1)
                x2t++
            if (((x1.toInt()).toDouble()) == x1) {
                if (x2t == 0) {
                    x2 = x2 * 10 + a
                    text = "${x1.toInt()}$x${x2.toInt()}"
                } else {
                    x2 += a / ((10.0).pow(x2t++))
                    text = "${x1.toInt()}$x$x2"
                }
            } else {
                if (x2t == 0) {
                    x2 = x2 * 10 + a
                    text = "$x1$x${x2.toInt()}"
                } else {
                    x2 += a / ((10.0).pow(x2t++))
                    text = "$x1$x$x2"
                }
            }
        }
    }

    fun operation(b: String) {
        if (!((x1t == -1) && (x1 == 0.0))) {
            x = b
            if (((x1.toInt()).toDouble()) == x1)
                text = "${x1.toInt()}$x"
            else
                text = "$x1$x"
            x2 = 0.0
            x2t = -1
        } else
            text2 = "Не введена первая переменная"
    }

    fun point() {
        if (x2t > -1) {
            if (x2t > 0)
                text2 = "Вы уже нажали"
            else
                x2t = 1
            if (x1t == 0)
                text = "${x1.toInt()}$x${x2.toInt()}."
            else
                text = "$x1$x${x2.toInt()}."
        } else {
            if (x1t != 0)
                text2 = "Вы уже нажали"
            else
                x1t = 1
            if (x == " ")
                text = "${x1.toInt()}."
            else
                text2 = "Не введена вторая переменная"
        }
    }

    fun calculation() {
        if ((x != " ") && (x2t > -1)) {
            if (x == "+") {
                x1 += x2
                if (((x1.toInt()).toDouble()) == x1) text = "${x1.toInt()}"
                else
                    text = "$x1"
            }
            if (x == "-") {
                x1 -= x2
                if (((x1.toInt()).toDouble()) == x1)
                    text = "${x1.toInt()}"
                else
                    text = "$x1"
            }
            if (x == "/")
                if (x2 != 0.0) {
                    x1 /= x2
                    if (((x1.toInt()).toDouble()) == x1)
                        text = "${x1.toInt()}"
                    else
                        text = "$x1"
                } else
                    text2 = "На ноль делить нельзя"
            if (x == "*") {
                x1 *= x2
                if (((x1.toInt()).toDouble()) == x1)
                    text = "${x1.toInt()}"
                else
                    text = "$x1"
            }
            null2()
        }
    }
}

class MainActivity : AppCompatActivity() {

    private var cal = ModelCal()

    //View

    private fun viewC(d: Int, e: String) {
        when (d) {
            1 -> textView.text = "$e"
            2 -> textView2.text = "$e"
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Controller

        button1.setOnClickListener {
            cal.inputC(1.0)
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        button2.setOnClickListener {
            cal.inputC(2.0)
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        button3.setOnClickListener {
            cal.inputC(3.0)
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        button4.setOnClickListener {
            cal.inputC(4.0)
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        button5.setOnClickListener {
            cal.inputC(5.0)
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        button6.setOnClickListener {
            cal.inputC(6.0)
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        button7.setOnClickListener {
            cal.inputC(7.0)
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        button8.setOnClickListener {
            cal.inputC(8.0)
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        button9.setOnClickListener {
            cal.inputC(9.0)
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        button0.setOnClickListener {
            cal.inputC(0.0)
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        buttonPlus.setOnClickListener {
            cal.operation("+")
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        buttonMinus.setOnClickListener {
            cal.operation("-")
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        buttonMult.setOnClickListener {
            cal.operation("*")
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        buttonDiv.setOnClickListener {
            cal.operation("/")
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        buttonDel.setOnClickListener {
            cal.inNull()
            viewC(1, "0")
        }

        buttonPoint.setOnClickListener {
            cal.point()
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }

        buttonEq.setOnClickListener {
            cal.calculation()
            viewC(1, cal.text)
            viewC(2, cal.text2)
        }
    }
}
