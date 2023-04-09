package com.example.rlthack.noAct

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.Color
import com.example.rlthack.ui.theme.MainBack


@Composable
fun PieChart(
    data1:List<Float>,
    data2:List<Color>,
    modifier: Modifier = Modifier,
) {
    val totalSum = data1.sum()
    val weight = data1.map {
        it*100/totalSum
    }
    val percentAngle = weight.map {
        it*360/100
    }

    Canvas(
        modifier = modifier,
    ){
        var startAngle = 270f
        drawArc(
            color = data2[0],
            startAngle = startAngle,
            sweepAngle = percentAngle[0],
            useCenter = true,
            size = Size(size.width,size.width)
        )
        startAngle+=percentAngle[0]
        drawArc(
            color = data2[1],
            startAngle = startAngle,
            sweepAngle = percentAngle[1],
            useCenter = true,
            size = Size(size.width,size.width)
        )
        startAngle+=percentAngle[1]
        drawArc(
            color = data2[2],
            startAngle = startAngle,
            sweepAngle = percentAngle[2],
            useCenter = true,
            size = Size(size.width,size.width)
        )
        startAngle+=percentAngle[2]
        drawArc(
            color = data2[3],
            startAngle = startAngle,
            sweepAngle = percentAngle[3],
            useCenter = true,
            size = Size(size.width,size.width)
        )
        startAngle+=percentAngle[3]
        drawArc(
            color = data2[4],
            startAngle = startAngle,
            sweepAngle = percentAngle[4],
            useCenter = true,
            size = Size(size.width,size.width)
        )
    }
}