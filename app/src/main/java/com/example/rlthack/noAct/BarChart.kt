package com.example.rlthack.noAct

import android.content.Context
import android.util.Log
import android.widget.Toast
import androidx.compose.animation.core.LinearEasing
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.android.volley.Request
import com.android.volley.toolbox.JsonObjectRequest
import com.android.volley.toolbox.Volley
import com.example.rlthack.ui.theme.BarChartLine
import com.example.rlthack.ui.theme.BarChart_C
import com.example.rlthack.ui.theme.Eco
import com.example.rlthack.ui.theme.Purple500
import org.json.JSONException


@Composable
fun BarChart(
    data: Map<Float, String>,
) {
    val max_value:Int = SearchRep.map.get(12).toString().toInt()
    Log.d("GGLog", SearchRep.map.get(12).toString().toInt().toString())
    val context = LocalContext.current
    // BarGraph Dimensions
    val barGraphHeight by remember { mutableStateOf(200.dp) }
    val barGraphWidth by remember { mutableStateOf(12.dp) }
    // Scale Dimensions
    val scaleYAxisWidth by remember { mutableStateOf(50.dp) }
    val scaleLineWidth by remember { mutableStateOf(2.dp) }

    Column(
        modifier = Modifier
            .padding(top = 50.dp, start = 10.dp, end = 10.dp)
            .fillMaxSize(),
        verticalArrangement = Arrangement.Top
    ) {

        Row(
            modifier = Modifier
                .fillMaxWidth()
                .height(barGraphHeight),
            verticalAlignment = Alignment.Bottom,
            horizontalArrangement = Arrangement.Start
        ) {
            // scale Y-Axis
            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(scaleYAxisWidth),
                contentAlignment = Alignment.BottomCenter
            ) {
                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(text = max_value.toString())
                    Spacer(modifier = Modifier.fillMaxHeight())
                }

                Column(
                    modifier = Modifier.fillMaxHeight(),
                    verticalArrangement = Arrangement.Bottom
                ) {
                    Text(text = (max_value / 2).toString())
                    Spacer(modifier = Modifier.fillMaxHeight(0.5f))
                }

            }

            Box(
                modifier = Modifier
                    .fillMaxHeight()
                    .width(scaleLineWidth)
                    .background(BarChartLine)
            )

            data.forEach {
                Box(
                    modifier = Modifier
                        .padding(start = barGraphWidth, bottom = 5.dp)
                        .width(barGraphWidth)
                        .fillMaxHeight(it.key)
                        .background(BarChart_C)
                        .clickable {
                            //Toast
                            //    .makeText(context, it.key.toString(), Toast.LENGTH_SHORT)
                            //    .show()
                        }
                )
            }

        }

        Box(
            modifier = Modifier
                .fillMaxWidth()
                .height(scaleLineWidth)
                .background(BarChartLine)
        )

        Row(
            modifier = Modifier
                .padding(start = scaleYAxisWidth+barGraphWidth+scaleLineWidth)
                .fillMaxWidth(),
            horizontalArrangement = Arrangement.spacedBy(barGraphWidth)
        ) {

            data.values.forEach {
                Text(
                    modifier = Modifier.width(barGraphWidth),
                    text = it,
                    textAlign = TextAlign.Center,
                    fontFamily = Eco,
                    fontSize = 12.sp,
                )
            }

        }

    }
}