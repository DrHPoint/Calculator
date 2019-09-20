package ru.teslateam.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import androidx.constraintlayout.widget.Group
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    private var cal = ModelCalculator()

    //View

    private fun viewC(d: Int, e: String) {
        when (d) {
            1 -> status.text = "$e"
            2 -> error_status.text = "$e"
        }
    }

    fun Group.setAllOnClickListener(listener: View.OnClickListener?) {
        referencedIds.forEach { id ->
            rootView.findViewById<View>(id).setOnClickListener(listener)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        //Controller
        var groupNumber: Group = findViewById(R.id.group1)

        groupNumber.setAllOnClickListener(View.OnClickListener {
            viewC(1, cal.status)
            viewC(2, cal.error)
        })

        button1.setOnClickListener {
            cal.inputNumber(1)
        }

        button2.setOnClickListener {
            cal.inputNumber(2)
        }

        button3.setOnClickListener {
            cal.inputNumber(3)
        }

        button4.setOnClickListener {
            cal.inputNumber(4)
        }

        button5.setOnClickListener {
            cal.inputNumber(5)
        }

        button6.setOnClickListener {
            cal.inputNumber(6)
        }

        button7.setOnClickListener {
            cal.inputNumber(7)
        }

        button8.setOnClickListener {
            cal.inputNumber(8)
        }

        button9.setOnClickListener {
            cal.inputNumber(9)
        }

        button0.setOnClickListener {
            cal.inputNumber(0)
        }

        buttonPlus.setOnClickListener {
            cal.operation("+")
            viewC(1, cal.status)
            viewC(2, cal.error)
        }

        buttonMinus.setOnClickListener {
            cal.operation("-")
            viewC(1, cal.status)
            viewC(2, cal.error)
        }

        buttonMultiply.setOnClickListener {
            cal.operation("*")
            viewC(1, cal.status)
            viewC(2, cal.error)
        }

        buttonDivide.setOnClickListener {
            cal.operation("/")
            viewC(1, cal.status)
            viewC(2, cal.error)
        }

        buttonDelete.setOnClickListener {
            cal.nullElements(0.0)
            viewC(1, "0")
        }

        buttonPoint.setOnClickListener {
            cal.point()
            viewC(1, cal.status)
            viewC(2, cal.error)
        }

        buttonEqually.setOnClickListener {
            cal.calculation()
            viewC(1, cal.status)
            viewC(2, cal.error)
        }
    }
}
