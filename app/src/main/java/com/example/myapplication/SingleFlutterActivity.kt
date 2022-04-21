package com.example.myapplication

import android.content.Context
import android.content.Intent
import android.os.Bundle
import android.os.PersistableBundle
import android.view.KeyEvent
import androidx.activity.OnBackPressedCallback
import io.flutter.embedding.android.FlutterActivity
import io.flutter.embedding.engine.FlutterEngine

class SingleFlutterActivity : FlutterActivity(), EngineBindingsDelegate {
    private val engineBindings: EngineBindings by lazy {
        EngineBindings(activity = this, delegate = this, entrypoint = "main")
    }

    override fun onCreate(savedInstanceState: Bundle?, persistentState: PersistableBundle?) {
        println("SingleFlutterActivity onCreate")
        super.onCreate(savedInstanceState, persistentState)
        engineBindings.attach()
    }
    override fun onKeyUp(keyCode: Int, event: KeyEvent?): Boolean {
        println("SingleFlutterActivity - android capture onKeyUp")
        return super.onKeyUp(keyCode, event)
    }

    override fun onKeyDown(keyCode: Int, event: KeyEvent?): Boolean {
        println("SingleFlutterActivity - android capture onKeyDown")
        return super.onKeyDown(keyCode, event)
    }

    override fun onBackPressed() {
        println("SingleFlutterActivity - android capture back button pressed")
       // super.onBackPressed() // comment this to disable back action
    }

    override fun onDestroy() {
        super.onDestroy()
        println("SingleFlutterActivity - android capture back button onDestroy")
        engineBindings.detach()
    }



    override fun provideFlutterEngine(context: Context): FlutterEngine? {
        return engineBindings.engine
    }

    override fun onNext() {
        print("SingleFlutterActivity - android capture back button onNext")
        val flutterIntent = Intent(this, MainActivity::class.java)
        startActivity(flutterIntent)
    }  
}