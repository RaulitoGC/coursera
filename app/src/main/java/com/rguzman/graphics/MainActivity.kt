package com.rguzman.graphics

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle

class MainActivity : AppCompatActivity() {

    private lateinit var canvasDrawView : CanvasDrawView
    private lateinit var canvasPathView : CanvasPathView
    private lateinit var canvasGradientView : CanvasGradientView

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        canvasDrawView = CanvasDrawView(this)
        canvasPathView = CanvasPathView(this)
        canvasGradientView = CanvasGradientView(this)
        setContentView(canvasGradientView)
    }
}
