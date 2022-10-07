package com.tombat.rgb

import android.graphics.Color
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import android.widget.Toast
import com.google.android.material.textfield.TextInputEditText
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        colorButton.setOnClickListener {
            var redChannelText = redChannel.text.toString()
            var greenChannelText = greenChannel.text.toString()
            var blueChannelText = blueChannel.text.toString()

            if (redChannelText.isEmpty() or greenChannelText.isEmpty() or blueChannelText.isEmpty()) {
                Toast.makeText(this, "All Values are required", Toast.LENGTH_LONG).show()
            } else {

                if (redChannelText.length == 1) redChannelText = redChannelText.plus(redChannelText)
                if (greenChannelText.length == 1) greenChannelText = greenChannelText.plus(greenChannelText)
                if (blueChannelText.length == 1) blueChannelText = blueChannelText.plus(blueChannelText)

                val colorToDisplay = redChannelText.plus(greenChannelText).plus(blueChannelText)

                val colorAsInt = Color.parseColor("#".plus(colorToDisplay))
                colorDisplay.setBackgroundColor(colorAsInt)
            }
        }
    }
}