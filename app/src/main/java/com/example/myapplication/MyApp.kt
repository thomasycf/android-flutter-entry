package com.example.myapplication

import android.app.Application
import io.flutter.embedding.engine.FlutterEngine
import io.flutter.embedding.engine.FlutterEngineCache
import io.flutter.embedding.engine.dart.DartExecutor

class MyApp:Application() {
    lateinit var flutterEngine: FlutterEngine

    override fun onCreate() {
        super.onCreate()
        flutterEngine = FlutterEngine(this)
        flutterEngine.navigationChannel.setInitialRoute("/hello_flutter");
        // Start executing Dart code to pre-warm the FlutterEngine.
        flutterEngine.dartExecutor.executeDartEntrypoint(
            DartExecutor.DartEntrypoint.createDefault()
        )

        println("MyApp - is flutter engine running before cache = ${flutterEngine.dartExecutor.isExecutingDart}")
        // Cache the FlutterEngine to be used by FlutterActivity.
        FlutterEngineCache
            .getInstance()
            .put("my_engine_id", flutterEngine)

        println("MyApp - flutter engine cached done , is flutter engine running = ${flutterEngine.dartExecutor.isExecutingDart}")

    }
}