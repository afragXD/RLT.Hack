package com.example.rlthack.noAct

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.RowScope
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rlthack.ui.theme.BackList
import com.example.rlthack.ui.theme.Eco
import com.example.rlthack.ui.theme.MainText

@Composable
fun RowScope.TableCell(
    text: String,
    weight: Float,
) {
    Text(
        text = text,
        Modifier
            .border(1.dp, Color.White)
            .weight(weight)
            .height(56.dp)
            .background(BackList),
        color = MainText,
        fontSize = 14.sp,
        textAlign = TextAlign.Center,
        fontFamily = Eco,
    )
}