package com.rguzman.graphics

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity

class MainActivity : AppCompatActivity() {

    private lateinit var canvasDrawView: CanvasDrawView
    private lateinit var canvasPathView: CanvasPathView
    private lateinit var canvasGradientView: CanvasGradientView
    private lateinit var canvasTransformationView: CanvasTransformationView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        canvasDrawView = CanvasDrawView(this)
        canvasPathView = CanvasPathView(this)
        canvasGradientView = CanvasGradientView(this)
        canvasTransformationView = CanvasTransformationView(this)
        setContentView(canvasTransformationView)
    }
}
