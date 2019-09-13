package ru.teslateam.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    private var x1 = 0.0 //Первая переменная
    private var x1t = -1 //Счетчик знаков после запятой. При нуле число целое
    private var x2 = 0.0 //Вторая переменная
    private var x2t = -1 //Счетчик знаков после запятой. При минус единице число не введено, при нуле целое
    private var x = " " //Оператор

    private fun null2() {
        x1t = -1
        x = " "
        x2 = 0.0
        x2t = -1
    }

    private fun inNull() {
        null2()
        x1 = 0.0
    }

    private fun inputC(a: Double) {
        textView2.text = ""
        if (x == " ") {
            if (x1t == -1) {
                inNull()
                x1t = 0
            }
            if (x1t == 0) {
                x1 = x1 * 10 + a
                textView.text = "${x1.toInt()}"
            } else {
                x1 += a / ((10.0).pow(x1t++))
                textView.text = "$x1"
            }
        } else {
            if (x2t == -1)
                x2t++
            if (((x1.toInt()).toDouble()) == x1) {
                if (x2t == 0) {
                    x2 = x2 * 10 + a
                    textView.text = "${x1.toInt()}$x${x2.toInt()}"
                } else {
                    x2 += a / ((10.0).pow(x2t++))
                    textView.text = "${x1.toInt()}$x$x2"
                }
            } else {
                if (x2t == 0) {
                    x2 = x2 * 10 + a
                    textView.text = "$x1$x${x2.toInt()}"
                } else {
                    x2 += a / ((10.0).pow(x2t++))
                    textView.text = "$x1$x$x2"
                }
            }
        }
    }

    private fun operation(b: String) {
        if (!((x1t == -1) && (x1 == 0.0))) {
            x = b
            if (((x1.toInt()).toDouble()) == x1)
                textView.text = "${x1.toInt()}$x"
            else
                textView.text = "$x1$x"
            x2 = 0.0
            x2t = -1
        } else
            textView2.text = "Не введена первая переменная"
    }

    private fun point() {
        if (x2t > -1) {
            if (x2t > 0)
                textView2.text = "Вы уже нажали"
            else
                x2t = 1
            if (x1t == 0)
                textView.text = "${x1.toInt()}$x${x2.toInt()}."
            else
                textView.text = "$x1$x${x2.toInt()}."
        } else {
            if (x1t != 0)
                textView2.text = "Вы уже нажали"
            else
                x1t = 1
            if (x == " ")
                textView.text = "${x1.toInt()}."
            else
                textView2.text = "Не введена вторая переменная"
        }
    }

    private fun calculation() {
        if ((x != " ") && (x2t > -1)) {
            if (x == "+") {
                x1 += x2
                if (((x1.toInt()).toDouble()) == x1)
                    textView.text = "${x1.toInt()}"
                else
                    textView.text = "$x1"
            }
            if (x == "-") {
                x1 -= x2
                if (((x1.toInt()).toDouble()) == x1)
                    textView.text = "${x1.toInt()}"
                else
                    textView.text = "$x1"
            }
            if (x == "/")
                if (x2 != 0.0) {
                    x1 /= x2
                    if (((x1.toInt()).toDouble()) == x1)
                        textView.text = "${x1.toInt()}"
                    else
                        textView.text = "$x1"
                } else
                    textView2.text = "На ноль делить нельзя"
            if (x == "*") {
                x1 *= x2
                if (((x1.toInt()).toDouble()) == x1)
                    textView.text = "${x1.toInt()}"
                else
                    textView.text = "$x1"
            }
            null2()
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        button1.setOnClickListener {
            inputC(1.0)
        }

        button2.setOnClickListener {
            inputC(2.0)
        }

        button3.setOnClickListener {
            inputC(3.0)
        }

        button4.setOnClickListener {
            inputC(4.0)
        }

        button5.setOnClickListener {
            inputC(5.0)
        }

        button6.setOnClickListener {
            inputC(6.0)
        }

        button7.setOnClickListener {
            inputC(7.0)
        }

        button8.setOnClickListener {
            inputC(8.0)
        }

        button9.setOnClickListener {
            inputC(9.0)
        }

        button0.setOnClickListener {
            inputC(0.0)
        }

        buttonPlus.setOnClickListener {
            operation("+")
        }

        buttonMinus.setOnClickListener {
            operation("-")
        }

        buttonMult.setOnClickListener {
            operation("*")
        }

        buttonDiv.setOnClickListener {
            operation("/")
        }

        buttonDel.setOnClickListener {
            inNull()
            textView.text = "0"
        }

        buttonPoint.setOnClickListener {
            point()
        }

        buttonEq.setOnClickListener {
            calculation()
        }
    }
}
