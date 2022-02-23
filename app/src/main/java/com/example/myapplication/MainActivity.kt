package com.example.myapplication

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import android.view.KeyEvent
import android.view.View
import androidx.activity.OnBackPressedCallback
import androidx.lifecycle.LifecycleOwner
import io.flutter.embedding.android.FlutterActivity

class MainActivity : AppCompatActivity(), LifecycleOwner {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
         val onBackPress = object : OnBackPressedCallback(true) {
            override fun handleOnBackPressed() {
                print("android handleOnBackPressed.....")
            }
//                if (popBackStack()) {
//                    return
//                }
//                val currentTIme = System.currentTimeMillis()
//                if (lastBackPressTime == -1L || currentTIme - lastBackPressTime >= 2000) {
//                    // 显示提示信息
//                    showBackPressTip()
//                    // 记录时间
//                    lastBackPressTime = currentTIme
//                } else {
//                    //退出应用
//                    finish()
//                    // android.os.Process.killProcess(android.os.Process.myPid())
//                    // System.exit(0) // exitProcess(0)
//                    // moveTaskToBack(false)
//                }
            }
        onBackPressedDispatcher.addCallback(this, onBackPress);

//         this.onBackPressedDispatcher.addCallback( this,
//            object : OnBackPressedCallback(true) {
//                override fun handleOnBackPressed() {
//                    print("android capture onKeyUp")
//                    Log.d("main act", "Activity back pressed invoked")
//                    // Do custom work here
//
//                    // if you want onBackPressed() to be called as normal afterwards
//                    if (isEnabled) {
//                        isEnabled = false
//                        this.handleOnBackPressed()
//                    }
//                }
//            })

    }

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
        print("android capture back button pressed")
     //   super.onBackPressed()
    }

    fun sendMessage(v:View){
        println("button onClicked, opening flutter page")
//        startActivity(
////            FlutterActivity.createDefaultIntent(this)
//            FlutterActivity
//                .withCachedEngine("my_engine_id")
//                .build(this)
//
//        );
        val nextClass = SingleFlutterActivity::class.java
        val flutterIntent = Intent(this, nextClass)
        startActivity(flutterIntent)
    }

    fun secAct(v: View){
        println("button onClicked, opening second page")
        val nextClass = SingleFlutterActivity::class.java
        val secIntent = Intent(this, MainActivity2::class.java)
        startActivity(secIntent)

    }
}