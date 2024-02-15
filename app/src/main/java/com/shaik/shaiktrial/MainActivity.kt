package com.shaik.shaiktrial

import android.app.DatePickerDialog
import android.os.Bundle
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.app.AppCompatActivity
import java.text.SimpleDateFormat
import java.util.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        val btnDatePicker: Button = findViewById(R.id.btnDatePicker)
        val tvSelectedDate: TextView = findViewById(R.id.tvSelectedDate)
        val tvSelectedDateInMinutes: TextView = findViewById(R.id.tvSelectedDateInminutes)

        btnDatePicker.setOnClickListener {
            val calendar = Calendar.getInstance()
            val year = calendar.get(Calendar.YEAR)
            val month = calendar.get(Calendar.MONTH)
            val dayOfMonth = calendar.get(Calendar.DAY_OF_MONTH)

            val datePickerDialog = DatePickerDialog(this,
                { _, selectedYear, selectedMonth, selectedDay ->
                    val selectedDate = Calendar.getInstance()
                    selectedDate.set(selectedYear, selectedMonth, selectedDay)
                    val dateFormat = SimpleDateFormat("dd-MM-yyyy", Locale.getDefault())
                    val formattedDate = dateFormat.format(selectedDate.time)
                    tvSelectedDate.text = "Selected Date: $formattedDate"

                    val currentTime = Calendar.getInstance().timeInMillis
                    val selectedTime = selectedDate.timeInMillis
                    val ageInMinutes = (currentTime - selectedTime) / (1000 * 60)
                    tvSelectedDateInMinutes.text = "Age In Minutes: $ageInMinutes"
                },
                year, month, dayOfMonth
            )
            datePickerDialog.show()
        }
    }
}
