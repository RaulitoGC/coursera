package com.rguzman.graphics

import android.content.Context
import android.graphics.Canvas
import android.graphics.Color
import android.graphics.Paint
import android.util.AttributeSet
import android.view.View

class CanvasDrawView(context: Context, attrs: AttributeSet? = null) : View(context, attrs) {

    private var redPaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)
    private var bluePaint: Paint = Paint(Paint.ANTI_ALIAS_FLAG)

    init {

        redPaint.style = Paint.Style.STROKE //stroke only no fill
        redPaint.color = Color.RED //color red
        redPaint.strokeWidth = 5f //set the line stroke width to 5

        bluePaint.style = Paint.Style.FILL //stroke only no fill
        bluePaint.color = Color.BLUE //color blue

    }

    override fun onDraw(canvas: Canvas?) {
        super.onDraw(canvas)
        canvas?.let {
            it.drawRect(10f, 30f, 200f, 200f, redPaint)
            it.drawRect(10f, 30f, 200f, 200f, bluePaint)
        }

    }
}