package com.example.tictactoe

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.widget.TextView
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {


    private var currentPlayer = "X"
    private var gameState = "playing"
    private lateinit var allField: Array<TextView >
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

          allField = arrayOf(f1, f2, f3, f4, f5, f6, f7, f8, f9)

        for (field in allField){
            field.setOnClickListener{
                  onFieldClick(it as TextView)
            }
        }

    }

    private fun onFieldClick(field :TextView) {

        if (gameState != "playing") {
            resetGame()
            return
        }
        if (field.text == "") {
            field.text = currentPlayer

            if (checkWin() ){
                Status1.text = "Player $currentPlayer has won"
                gameState = "won"
            }
            else if (allField.all { it.text != "" }){
                Status1.text = " Tie!"
                gameState ="Tie!"
            }

            else {
                currentPlayer = if (currentPlayer == "X") "O" else "X"
                Status1.text = "it´s your turn Player $currentPlayer"
            }
             }
    }

    private fun resetGame(){
        currentPlayer = "X"
        Status1.text = "it´s your turn Player $currentPlayer"
        for (field in allField){
            field.text = ""
        }
        gameState = "playing"
    }


    private fun checkWin(): Boolean {
        return (f1.text == f2.text && f2.text == f3.text &&f1.text !="")||
               (f4.text == f5.text && f5.text == f6.text &&f4.text !="")||
               (f7.text == f8.text && f8.text == f9.text &&f7.text !="")||
               (f1.text == f4.text && f4.text == f7.text &&f7.text !="")||
               (f2.text == f5.text && f5.text == f8.text &&f8.text !="")||
               (f3.text == f6.text && f6.text == f9.text &&f3.text !="")||
               (f1.text == f5.text && f5.text == f9.text &&f5.text !="")||
               (f3.text == f5.text && f5.text == f7.text &&f3.text !="")

    }

}
