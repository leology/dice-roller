package com.example.diceroller

import android.os.Bundle
import android.widget.Button
import android.widget.ImageView
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        val rollButton: Button =
            findViewById(R.id.button) /* The code saves the reference to the Button object in a variable called rollButton, not the Button object itself. */
        rollButton.setOnClickListener { rollDice() }
        rollDice()
    }

    private fun rollDice() {
        val dice = Dice(6)
        val diceImage: ImageView = findViewById(R.id.imageView) /* ImageView is object. imageView is ID name */
        val drawableResource = when (dice.roll()) {
            1 -> R.drawable.dice_1
            2 -> R.drawable.dice_2
            3 -> R.drawable.dice_3
            4 -> R.drawable.dice_4
            5 -> R.drawable.dice_5
            else -> gotSix()
        }
        diceImage.setImageResource(drawableResource)
        diceImage.contentDescription = dice.roll().toString()

        //val resultTextView: TextView = findViewById(R.id.textView)
        //resultTextView.text = diceRoll.toString()
        //diceImage.setImageResource(R.drawable.dice_2)
    }

    private fun gotSix(): Int {
        val toast = Toast.makeText(this, "Congrats! Now Play", Toast.LENGTH_SHORT)
        toast.show()
        return R.drawable.dice_6

    }
}

class Dice(private val sides: Int) {
    fun roll(): Int {
        return (1..sides).random()
    }
}