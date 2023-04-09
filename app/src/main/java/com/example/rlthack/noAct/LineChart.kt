package com.example.rlthack.noAct

import android.graphics.Paint
import android.util.Log
import androidx.compose.foundation.Canvas
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.*
import androidx.compose.ui.graphics.drawscope.Stroke
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rlthack.ui.theme.Graph1_1
import com.example.rlthack.ui.theme.Graph1_2
import kotlin.math.round
import kotlin.math.roundToInt


@Composable
fun LineChart(
    data1: List<Pair<Int, Double>> = emptyList(),
    data2: List<Pair<Int, Double>> = emptyList(),
    modifier: Modifier = Modifier,
) {

    val spacing = 50f
    val graphColor1 = Graph1_1
    val graphColor2 = Graph1_2
    val transparentGraphColor1 = remember{ graphColor1.copy(alpha = 0.5f) }
    val transparentGraphColor2 = remember{ graphColor2.copy(alpha = 0.7f) }

    val upperValue1 = remember{ (data1.maxOfOrNull { it.second }?.plus(1))?.roundToInt() ?: 0 }
    val lowerValue1 = remember{ (data1.minOfOrNull { it.second }?.toInt() ?: 0) }

    val upperValue2 = remember{ (data2.maxOfOrNull { it.second }?.plus(1))?.roundToInt() ?: 0 }
    val lowerValue2 = remember{ (data2.minOfOrNull { it.second }?.toInt() ?: 0) }

    val upperValue = maxOf(upperValue1, upperValue2)
    val lowerValue = minOf(lowerValue1,lowerValue2)

    val density = LocalDensity.current

    val textPaint = remember(density) {
        Paint().apply {
            color = android.graphics.Color.WHITE
            textAlign = Paint.Align.CENTER
            textSize = density.run { 12.sp.toPx() }
        }
    }
    Canvas(modifier = modifier) {
        val spacePerHour1 = (size.width - spacing) / data1.size
        (data1.indices step 1).forEach { i ->
            val hour = data1[i].first
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    hour.toString(),
                    spacing + i * spacePerHour1,
                    size.height,
                    textPaint
                )
            }
        }
        val priceStep = (upperValue - lowerValue) / 5f
        (0..4).forEach { i ->
            drawContext.canvas.nativeCanvas.apply {
                drawText(
                    round(lowerValue + priceStep * i).toString(),
                    10f,
                    size.height - spacing - i * size.height / 5f,
                    textPaint
                )
            }
        }
        val strokePath = Path().apply {
            val height = size.height
            data1.indices.forEach { i ->
                val info = data1[i]
                val ratio = (info.second - lowerValue) / (upperValue - lowerValue)

                val x1 = spacing + i * spacePerHour1
                val y1 = height - spacing - (ratio * height).toFloat()

                if (i == 0) { moveTo(x1, y1) }
                lineTo(x1, y1)
            }
        }
        drawPath(
            path = strokePath,
            color = graphColor1,
            style = Stroke(
                width = 2.dp.toPx(),
                cap = StrokeCap.Round
            )
        )
        val fillPath = android.graphics.Path(strokePath.asAndroidPath()).asComposePath().apply {
            lineTo(size.width - spacePerHour1, size.height - spacing)
            lineTo(spacing, size.height - spacing)
            close()
        }
        drawPath(
            path = fillPath,
            brush = Brush.verticalGradient(
                colors = listOf(
                    transparentGraphColor1,
                    Color.Transparent
                ),
                endY = size.height - spacing
            )
        )


        val spacePerHour2 = (size.width - spacing) / data2.size
        //(data2.indices step 1).forEach { i ->
        //    val hour = data2[i].first
        //    drawContext.canvas.nativeCanvas.apply {
        //        drawText(
        //            hour.toString(),
        //            spacing + i * spacePerHour2,
        //            size.height,
        //            textPaint
        //        )
        //    }
        //}
        //val priceStep2 = (upperValue - lowerValue) / 4f
        //(0..4).forEach { i ->
        //    drawContext.canvas.nativeCanvas.apply {
        //        drawText(
        //            round(lowerValue + priceStep2 * i).toString(),
        //            30f,
        //            size.height - spacing - i * size.height / 4f,
        //            textPaint
        //        )
        //    }
        //}
        val strokePath2 = Path().apply {
            val height = size.height
            data2.indices.forEach { i ->
                val info = data2[i]
                val ratio = (info.second - lowerValue) / (upperValue - lowerValue)

                val x1 = spacing + i * spacePerHour2
                val y1 = height - spacing - (ratio * height).toFloat()

                if (i == 0) { moveTo(x1, y1) }
                lineTo(x1, y1)
            }
        }
        drawPath(
            path = strokePath2,
            color = graphColor2,
            style = Stroke(
                width = 2.dp.toPx(),
                cap = StrokeCap.Round
            )
        )
        val fillPath2 = android.graphics.Path(strokePath2.asAndroidPath()).asComposePath().apply {
            lineTo(size.width - spacePerHour2, size.height - spacing)
            lineTo(spacing, size.height - spacing)
            close()
        }
        drawPath(
            path = fillPath2,
            brush = Brush.verticalGradient(
                colors = listOf(
                    transparentGraphColor2,
                    Color.Transparent
                ),
                endY = size.height - spacing
            )
        )
    }
}
