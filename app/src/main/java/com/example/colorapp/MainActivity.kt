package com.example.colorapp

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.Button
import kotlinx.android.synthetic.main.activity_main.*
import kotlin.random.Random
import kotlin.random.nextInt

class MainActivity : AppCompatActivity() {


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setupScene()
    }

    private var score: Int = 0
    private val colors = mutableListOf<Color>(
        Color(colorName = "Aquamarine", color = R.color.Aquamarine),
        Color(colorName = "Erin", color = R.color.Erin),
        Color(colorName = "Magenta Rose", color = R.color.Magenta_rose),
        Color(colorName = "Sangria", color = R.color.Sangria),
        Color(colorName = "Sapphire", color = R.color.Sapphire),
        Color(colorName = "Taupe", color = R.color.Taupe),
        Color(colorName = "Ultramarine", color = R.color.Ultramarine),
        Color(colorName = "Viridian", color = R.color.Viridian),
        Color(colorName = "Black", color = R.color.black)
    )

    fun setupScene() {

        val randomIndex = Random.nextInt(0..colors.lastIndex)
        val winColor = colors.get(randomIndex)
        val wrongColors = colors.filter { it != winColor }
            .shuffled()
            .take(3)
            .plus(winColor)
            .shuffled()

        container_color.setBackgroundResource(winColor.color)
        btn_option1.text = wrongColors[0].colorName
        btn_option2.text = wrongColors[1].colorName
        btn_option3.text = wrongColors[2].colorName
        btn_option4.text = wrongColors[3].colorName

        btn_option1.setOnClickListener { checkWin(it as Button, winColor) }
        btn_option2.setOnClickListener { checkWin(it as Button, winColor) }
        btn_option3.setOnClickListener { checkWin(it as Button, winColor) }
        btn_option4.setOnClickListener { checkWin(it as Button, winColor) }
        btn_reset.setOnClickListener { resetGame() }
    }

    private fun checkWin(targetView: Button, displayColor: Color) {
        val label = targetView.text.toString()
        if (label == displayColor.colorName) {
            score += 1
            text_score.text = "Score : $score"
            buttonClickStatus(isEnabled = true)
            setupScene()
        } else {
            text_score.text = "GameOver : Score : $score"
            buttonClickStatus(isEnabled = false)
        }
    }

    fun buttonClickStatus(isEnabled: Boolean) {
        val buttons = listOf<Button>(btn_option1, btn_option2, btn_option3, btn_option4)
        buttons.forEach { it.isEnabled = isEnabled }
    }


    private fun resetGame() {
        score = 0
        text_score.text = "Score : $score"
        buttonClickStatus(isEnabled = true)
        setupScene()
    }
}

