package com.rguzman.graphics

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View

class CanvasPathView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private val path = Path()
    private val redFillPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val blackPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private lateinit var linearGradient: LinearGradient
    private val gradientPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {

        path.moveTo(50f, 300f)
        path.lineTo(120f, 400f)
        path.lineTo(150f, 350f)
        path.lineTo(200f, 420f)
        path.lineTo(300f, 200f)
        path.close()


        redFillPaint.style = Paint.Style.FILL
        redFillPaint.color = Color.RED

        blackPaint.style = Paint.Style.STROKE
        blackPaint.color = Color.BLACK
        blackPaint.strokeWidth = 15f

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            it.drawPath(path, blackPaint)
            it.drawPath(path, redFillPaint)
        }

    }
}