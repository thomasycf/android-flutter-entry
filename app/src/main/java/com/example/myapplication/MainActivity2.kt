package com.example.myapplication
import android.os.Bundle
import android.view.KeyEvent
import androidx.activity.OnBackPressedCallback
import androidx.appcompat.app.AppCompatActivity


class MainActivity2 : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main2)
        val onBackPress = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                println("activity_main2 android handleOnBackPressed.....")
                finish()
            }
        }
        onBackPressedDispatcher.addCallback(this, onBackPress);
    }

    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        println("activity_main2 android capture onKeyUp")
        return super.onKeyUp(keyCode, event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        println("activity_main2 android capture onKeyDown")
        return super.onKeyDown(keyCode, event)
    }

    override fun onBackPressed() {
        //  this.onBackPressedDispatcher
        println("activity_main2 android capture back button pressed")
           super.onBackPressed()
    }


}