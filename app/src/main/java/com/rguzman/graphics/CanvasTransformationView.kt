package com.rguzman.graphics

import android.content.Context
import android.graphics.*
import android.util.AttributeSet
import android.view.View
import kotlin.math.cos
import kotlin.math.sin

class CanvasTransformationView(context: Context, attrs: AttributeSet? = null) :
    View(context, attrs) {

    private val points = mutableListOf<PointF>()
    private val path = Path()
    private val fillPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val blackPaint = Paint(Paint.ANTI_ALIAS_FLAG)

    private val greenPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val redPaint = Paint(Paint.ANTI_ALIAS_FLAG)
    private val bluePaint = Paint(Paint.ANTI_ALIAS_FLAG)

    companion object {
        const val INIT_X_POSITION = 50f
        const val INIT_Y_POSITION = 300f
    }


    init {

//        points.add(PointF(INIT_X_POSITION, INIT_Y_POSITION))
//        points.add(PointF(120f, 400f))
//        points.add(PointF(150f, 350f))
//        points.add(PointF(200f, 420f))
//        points.add(PointF(300f, 200f))

        points.add(PointF(500.0f, 300.0f))
        points.add(PointF(500.0f, 400.0f))
        points.add(PointF(600.0f, 400.0f))
        points.add(PointF(600.0f, 300.0f))

        path.moveTo(points[0].x, points[0].y)

        for (position in 1..points.lastIndex) {
            path.lineTo(points[position].x, points[position].y)
        }
        path.close()

        val linearGradient = LinearGradient(
            500f,
            300f,
            600f,
            300f,
            Color.BLUE,
            Color.RED,
            Shader.TileMode.MIRROR
        )

        fillPaint.style = Paint.Style.FILL
        fillPaint.shader = linearGradient

        blackPaint.style = Paint.Style.STROKE
        blackPaint.color = Color.BLACK
        blackPaint.strokeWidth = 15f

        greenPaint.style = Paint.Style.FILL
        greenPaint.color = Color.GREEN

        bluePaint.style = Paint.Style.FILL
        bluePaint.color = Color.BLUE

        redPaint.style = Paint.Style.FILL
        redPaint.color = Color.RED
    }

    private fun getTranslatedPoints(
        points: MutableList<PointF>,
        horizontal: Float = 1.0f,
        vertical: Float = 1.0f
    ): MutableList<PointF> {
        val pointsTransformed = mutableListOf<PointF>()
        points.forEach { point ->
            val xti = (point.x * 1) + (0 * point.y) + (1 * horizontal)
            val yti = (point.x * 0) + (1 * point.y) + (1 * vertical)
            pointsTransformed.add(PointF(xti.toFloat(), yti.toFloat()))
        }
        return pointsTransformed
    }

    private fun getRotatedPoints(
        points: MutableList<PointF>,
        angle: Float = 0.0f
    ): MutableList<PointF> {
        val pointsTransformed = mutableListOf<PointF>()
        points.forEach { point ->
            val xti = (point.x * cos(angle)) + ((-1 * sin(angle)) * point.y) + (1 * 0)
            val yti = (point.x * sin(angle)) + (cos(angle) * point.y) + (1 * 0)
            pointsTransformed.add(PointF(xti, yti))
        }
        return pointsTransformed
    }

    private fun getScaledPoints(
        points: MutableList<PointF>,
        scaleX: Float = 1.0f,
        scaleY: Float = 1.0f
    ): MutableList<PointF> {
        val pointsTransformed = mutableListOf<PointF>()
        points.forEach { point ->
            val xti = (point.x * scaleX) + (0 * point.y) + (1 * 0)
            val yti = (point.x * 0) + (scaleY * point.y) + (1 * 0)
            pointsTransformed.add(PointF(xti, yti))
        }
        return pointsTransformed
    }

    private fun getShearedPoints(
        points: MutableList<PointF>,
        xIncrement: Float = 0.0f,
        yIncrement: Float = 0.0f
    ): MutableList<PointF> {
        val pointsTransformed = mutableListOf<PointF>()
        points.forEach { point ->
            val xti = (point.x * 1) + (xIncrement * point.y) + (1 * 0)
            val yti = (point.x * yIncrement) + (1 * point.y) + (1 * 0)
            pointsTransformed.add(PointF(xti, yti))
        }
        return pointsTransformed
    }

    private fun getCrentroid(points: MutableList<PointF>): PointF {
        var centroid = PointF()
        val size = points.size
        var x = 0.0f
        var y = 0.0f
        points.forEach { point ->
            x += point.x
            y += point.y
        }

        centroid.x = (x / size)
        centroid.y = (y / size)

        return centroid
    }


    override fun draw(canvas: Canvas?) {
        super.draw(canvas)
        canvas?.let {

            //            val shearedPoints = getShearedPoints(points = points, xIncrement = 2f)
//            val scaledPoints = getScaledPoints(points = shearedPoints, scaleX = 0.5f, scaleY = 3.0f)
//            val rotatedPoints = getRotatedPoints(points = scaledPoints, angle = toRadians(45.0f))
//            val translatedPoints = getTranslatedPoints(points = rotatedPoints, horizontal = 550.0f)

//            val centroid = getCrentroid(points)
//            points.forEach {point ->
//                point.x = point.x - centroid.x
//                point.y = point.y - centroid.y
//            }
//
//            val rotatedPoints = getRotatedPoints(points = points, angle = toRadians(45.0f))
//
//            rotatedPoints.forEach {point ->
//                point.x = point.x + centroid.x
//                point.y = point.y + centroid.y
//            }

//            val pathTransformed = Path()
//            pathTransformed.moveTo(
//                rotatedPoints[0].x,
//                rotatedPoints[0].y
//            )
//
//            for (position in 1..rotatedPoints.lastIndex) {
//                pathTransformed.lineTo(
//                    rotatedPoints[position].x,
//                    rotatedPoints[position].y
//                )
//            }

            val pathTransformed = Path()
            pathTransformed.moveTo(
                0.0f,
                10.0f * sin(0.0f)
            )

            for (x in 0..50) {
                pathTransformed.lineTo(
                    x * 10.0f,
                    100.0f * sin(x * 1.0f)
                )
            }

            //it.drawPath(pathTransformed, blackPaint)

            val oval = RectF(300.0f,300.0f,600.0f,600.0f)
            //it.drawRect(oval,blackPaint)
            it.drawArc(oval,0.0f,57.6f,true,greenPaint)
            it.drawArc(oval,57.6f,43.2f,true,redPaint)
            it.drawArc(oval,100.8f,97.2f,true,bluePaint)
            it.drawArc(oval,198.0f,60.0f,true,greenPaint)
            it.drawArc(oval,252.0f,108.0f,true,redPaint)


        }
    }

    private fun toRadians(angle: Float): Float {
        return ((Math.PI * angle) / 180.0f).toFloat()
    }


}