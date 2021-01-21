package com.example.colorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random

class MainActivity : AppCompatActivity() {

    private var colorList = mutableListOf<Color>()
    private var nonSelectedColorList = mutableListOf<Color>()
    private var count : Int = 0

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        addColor()

        colorSelection()

        listener()
    }

    fun addColor(){

        val color_arr = mutableListOf<Int>(
            R.color.Aquamarine,
            R.color.Erin,
            R.color.Magenta_rose,
            R.color.Sangria,
            R.color.Sapphire,
            R.color.Taupe,
            R.color.Ultramarine,
            R.color.Viridian,
            R.color.black
        )

        val color_Name = mutableListOf<String>(
            "Aquamarine",
            "Erin",
            "Magenta_rose",
            "Sangria",
            "Sapphire",
            "Taupe",
            "Ultramarine",
            "Viridian",
            "black"
        )

        for (i in 0 until color_Name.size) {
            colorList.add(Color(color_Name[i], color_arr[i]))
        }
    }

    private fun colorSelection(){
        val size : Int = colorList.size
        val currentColor = colorList.get(Random.nextInt(size))
        iv_color.setBackgroundColor(resources.getColor(currentColor.color))
        Log.d("*** current color = ", ""+currentColor.colorName)
        colorList.forEach {
            if (!it.colorName.equals(currentColor.colorName)){
                nonSelectedColorList.add(it)
            }
        }

        btn_option1.setText(currentColor.colorName)
        btn_option2.setText(nonSelectedColorList.get(Random.nextInt(nonSelectedColorList.size)).colorName)
        btn_option3.setText(nonSelectedColorList.get(Random.nextInt(nonSelectedColorList.size)).colorName)
        btn_option4.setText(nonSelectedColorList.get(Random.nextInt(nonSelectedColorList.size)).colorName)
    }

    private fun listener(){
        btn_option1.setOnClickListener {
            ++count
            tv_count.setText("Points : ${count}")
            colorSelection()
        }
        btn_option2.setOnClickListener {
            count = 0
            tv_count.setText("Game Over")
        }
        btn_option3.setOnClickListener {
            count = 0
            tv_count.setText("Game Over")
        }
        btn_option4.setOnClickListener {
            count = 0
            tv_count.setText("Game Over")
        }


    }
}

