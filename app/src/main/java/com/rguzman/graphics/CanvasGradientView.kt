package com.rguzman.graphics

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CanvasGradientView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private var gradientPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val path = Path()

    init {

        path.moveTo(50f, 300f)
        path.lineTo(120f, 400f)
        path.lineTo(150f, 350f)
        path.lineTo(200f, 420f)
        path.lineTo(300f, 200f)
        path.close()

        val linearGradient = LinearGradient(
            50f,
            300f,
            300f,
            200f,
            Color.BLUE,
            Color.RED,
            Shader.TileMode.MIRROR
        )

        gradientPaint = Paint()
        gradientPaint.style = Paint.Style.FILL
        gradientPaint.shader = linearGradient

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            it.drawPath(path, gradientPaint)
        }

    }
}