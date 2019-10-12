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

    private fun viewIntermediateResults() {
        status.text = cal.status
        if (cal.status.length < 8)
            status.textSize = 66f
        else if (cal.status.length < 16)
            status.textSize = 45f
        error_status.text = cal.error

    }

    //Controller

    private fun Group.setAllOnClickListener(listener: View.OnClickListener?) {
        referencedIds.forEach { id ->
            rootView.findViewById<View>(id).setOnClickListener(listener)
        }
    }

    private fun buttonNumberClick(view: View) {
        cal.inputNumber((view as Button).text.toString().toInt())
        viewIntermediateResults()
    }

    private fun buttonOperationClick(view: View) {
        cal.operation((view as Button).text.toString())
        viewIntermediateResults()
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val errorArray: Array<String> = resources.getStringArray(R.array.error_array)
        cal.inputArray(errorArray)

        group1.setAllOnClickListener(View.OnClickListener { v -> buttonNumberClick(v) })
        group2.setAllOnClickListener(View.OnClickListener { v -> buttonOperationClick(v) })

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
