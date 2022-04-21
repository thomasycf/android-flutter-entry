package com.example.myapplication

import android.view.KeyEvent
import androidx.appcompat.app.AppCompatActivity
import androidx.lifecycle.LifecycleOwner

class SecAct: AppCompatActivity(), LifecycleOwner {
    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        print("android capture onKeyUp")
        return super.onKeyUp(keyCode, event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        print("android capture onKeyDown")
        return super.onKeyDown(keyCode, event)
    }

    override fun onBackPressed() {
        //  this.onBackPressedDispatcher
        print("SecAct - android capture back button pressed")
        //   super.onBackPressed()
    }
}