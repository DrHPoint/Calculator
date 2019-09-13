package ru.teslateam.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.math.*

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        var x1 = 0.0
        var x1i = "y"
        var x1t = 1
        var x2 = 0.0
        var x2i = "y"
        var x2t = 1
        var x = " "
        var xv = "n"
        var z: Double


        fun x0() {
            x1 = 0.0
            x1i = "y"
            x1t = 1
            x = " "
            x2 = 0.0
            x2i = "y"
            x2t = 1
            xv = "n"
            z = 0.0
        }

        fun xx(a:Double) {
            textView2.text = ""
            if (x == " ") {
                if (x1i == "y") {
                    x1 = x1 * 10 + a
                    textView.text = "${x1.toInt()}"
                }
                else {
                    x1 += a / ((10.0).pow(x1t++))
                    textView.text = "${x1}"
                }
            }
            else {
                xv = "y"
                if (x1i == "y") {
                    if (x2i == "y") {
                        x2 = x2 * 10 + a
                        textView.text = "${x1.toInt()}${x}${x2.toInt()}"
                    }
                    else {
                        x2 += a/((10.0).pow(x2t++))
                        textView.text = "${x1.toInt()}${x}${x2}"
                    }
                }
                else {
                    if (x2i == "y") {
                        x2 = x2 * 10 + a
                        textView.text = "${x1}${x}${x2.toInt()}"
                    }
                    else {
                        x2 += a/((10.0).pow(x2t++))
                        textView.text = "${x1}${x}${x2}"
                    }
                    }
            }
        }

        button12.setOnClickListener {
            xx(1.0)
        }

        button13.setOnClickListener {
            xx(2.0)
        }

        button14.setOnClickListener {
            xx(3.0)
        }

        button16.setOnClickListener {
            xx(4.0)
        }

        button17.setOnClickListener {
            xx(5.0)
        }

        button18.setOnClickListener {
            xx(6.0)
        }

        button19.setOnClickListener {
            xx(7.0)
        }

        button20.setOnClickListener {
            xx(8.0)
        }

        button21.setOnClickListener {
            xx(9.0)
        }

        button9.setOnClickListener {
            xx(0.0)
        }

        button11.setOnClickListener {
            x = "+"
            if (x1i == "y")
                textView.text = "${x1.toInt()}${x}"
            else
                textView.text = "${x1}${x}"
        }

        button15.setOnClickListener {
            x = "-"
            if (x1i == "y")
                textView.text = "${x1.toInt()}${x}"
            else
                textView.text = "${x1}${x}"
        }

        button22.setOnClickListener {
            x = "*"
            if (x1i == "y")
                textView.text = "${x1.toInt()}${x}"
            else
                textView.text = "${x1}${x}"
        }

        button23.setOnClickListener {
            x = "/"
            if (x1i == "y")
                textView.text = "${x1.toInt()}${x}"
            else
                textView.text = "${x1}${x}"
        }

        button24.setOnClickListener {
            x0()
            textView.text = "0"
        }

        button6.setOnClickListener {
            if (xv == "y") {
                if (x2i == "n") {
                    textView2.text = "Вы уже нажали"
                }
                x2i = "n"
                if (x1i == "y") {
                    textView.text = "${x1.toInt()}${x}${x2.toInt()}."
                }
                else {
                    textView.text = "${x1}${x}${x2.toInt()}."
                }
            }
            else {
                if (x1i == "n") {
                    textView2.text = "Вы уже нажали"
                }
                if (x == " ") {
                    x1i = "n"
                    textView.text = "${x1.toInt()}."
                }
                else
                    textView2.text = "Ошибка"
            }

        }

        button10.setOnClickListener {
            if ((x != " ")&&(xv == "y")) {
                if (x == "+") {
                    z = x1 + x2
                    if ((x1i == "y") && (x2i == "y"))
                        textView.text = "${z.toInt()}"
                    else
                        textView.text = "${z}"
                }
                if (x == "-") {
                    z = x1 - x2
                    if ((x1i == "y") && (x2i == "y"))
                        textView.text = "${z.toInt()}"
                    else
                        textView.text = "${z}"
                }
                if (x == "/")
                    if (x2 != 0.0) {
                        z = x1 / x2
                        if (((z.toInt()).toDouble())==(z))
                            textView.text = "${z.toInt()}"
                        else
                            textView.text = "${z}"
                    }
                    else
                        textView2.text = "На ноль делить нельзя"
                if (x == "*"){
                    z = x1 * x2
                    if (((z.toInt()).toDouble())==(z))
                        textView.text = "${z.toInt()}"
                    else
                        textView.text = "${z}"
                }
            }
            x0()
        }



    }
}
