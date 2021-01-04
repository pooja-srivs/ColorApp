package com.example.colorapp

import android.content.Intent
import android.graphics.Color
import android.os.Bundle
import android.os.Handler
import android.os.Looper
import android.os.Message
import androidx.appcompat.app.AppCompatActivity
import kotlinx.android.synthetic.main.activity_home.*
import java.util.*

class HomeActivity : AppCompatActivity() {

    val colors = arrayListOf<String>("#FF00AF",
                                                    "#0F52BA", "#92000A", "#3F00FF",
                                                    "#00FF3F", "#40826D", "#483C32")

    val runnableCode = object: Runnable {
        override fun run() {
            var r = Random()
            var rand: Int = r.nextInt(colors.size)
            cl_parent.setBackgroundColor(Color.parseColor(colors.get(rand)))
            Handler(Looper.getMainLooper()).postDelayed(this, 150)
        }
    }

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_home)
        runnableCode.run()

        btn_start.setOnClickListener {
            startActivity(Intent(this, MainActivity::class.java))
        }
    }
}