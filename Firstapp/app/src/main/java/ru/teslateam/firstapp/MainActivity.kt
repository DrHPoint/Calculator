package ru.teslateam.firstapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.View
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*



class MainActivity : AppCompatActivity() {

    private var cal = ModelCalculator()

    //View

    private fun viewIntermediateResults() {
        status.text = cal.status
        error_status.text = cal.error

    }

    //Controller

    fun buttonNumberClick(view: View) {
        cal.inputNumber((view as Button).text.toString().toInt())
        viewIntermediateResults()
    }

    fun buttonOperationClick(view: View) {
        cal.operation((view as Button).text.toString())
        viewIntermediateResults()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        buttonDelete.setOnClickListener {
            cal.nullElements(0.0)
            viewIntermediateResults()
        }

        buttonPoint.setOnClickListener {
            cal.point()
            viewIntermediateResults()
        }

        buttonEqually.setOnClickListener {
            cal.calculation()
            viewIntermediateResults()
        }
    }
}
