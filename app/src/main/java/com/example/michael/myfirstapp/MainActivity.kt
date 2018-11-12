package com.example.michael.myfirstapp

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.provider.AlarmClock.EXTRA_MESSAGE
import android.view.View
import android.widget.EditText
import android.widget.Toast
import com.example.michael.myfirstapp.R.id.textView
import kotlinx.android.synthetic.main.activity_main.textView

class MainActivity : AppCompatActivity() {

    private var back_pressed: Long = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
    }

    override fun onBackPressed() {
        if (back_pressed + 2000 > System.currentTimeMillis())
            super.onBackPressed()
        else
            Toast.makeText(baseContext, "Press once again to exit!", Toast.LENGTH_SHORT).show()
        back_pressed = System.currentTimeMillis()
    }

    fun toastMe(view: View) {
        // val myToast = Toast.makeText(this, message, duration);
        val myToast = Toast.makeText(this, "Hello Michael~  ", Toast.LENGTH_SHORT)
        myToast.show()
    }

    fun countMe (view: View) {
//        // Get the text view
//        val showCountTextView = findViewById(R.id.textView) as TextView

        // Get the value of the text view.
        val countString = textView.text.toString()

        // Convert value to a number and increment it
        var count: Int = Integer.parseInt(countString)
        count+=3

        // Display the new value in the text view.
        textView.text = count.toString()
    }

    fun randomMe(view: View){
        // Create an Intent to start the second activity
        val randomIntent = Intent(this, SecondActivity::class.java)

        // Get the current value of the text view.
        val countString = textView.text.toString()

        // Convert the count to an int
        val count = Integer.parseInt(countString)

        // Add the count to the extras for the Intent.
        randomIntent.putExtra(SecondActivity.TOTAL_COUNT, count)

        // Start the new activity.
        startActivity(randomIntent)
    }

    fun sendMessage(view: View) {
        val editText = findViewById<EditText>(R.id.editText)
        val message = editText.text.toString()
        textView.text = message
//        val intent = Intent(this, DisplayMessageActivity::class.java).apply {
//            putExtra(EXTRA_MESSAGE, message)
//        }
        startActivity(intent)
    }

    fun resetNo(view: View) {
        textView.text = getString(R.string.default_value)
    }
}
