package com.example.rlthack.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rlthack.R
import com.example.rlthack.noAct.TableCell
import com.example.rlthack.noAct.TableData
import com.example.rlthack.ui.theme.BackList
import com.example.rlthack.ui.theme.Eco
import com.example.rlthack.ui.theme.MainBack
import com.example.rlthack.ui.theme.MainText

@Preview(showBackground = true)
@Composable
fun RatingScreen() {

    val data = listOf(
        TableData(1,"ss1", 3123, "47,98%"),
        TableData(2,"ss2", 3123, "12,64%"),
        TableData(3,"ss3", 3123, "47,98%"),
    )

    val column1Weight = .1f
    val column2Weight = .4f
    val column3Weight = .3f
    val column4Weight = .3f

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBack),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "Рейтинг",
            modifier = Modifier
                .padding(top = 20.dp),
            color = MainText,
            fontSize = 32.sp,
            fontFamily = Eco,
        )
        LazyColumn(
            Modifier
                .fillMaxSize()
                .padding(16.dp)){
            item {
                Row(Modifier.background(BackList)) {
                    TableCell(text = "№", weight = column1Weight)
                    TableCell(text = "Описание", weight = column2Weight)
                    TableCell(text = "Цифры", weight = column3Weight)
                    TableCell(text = "Цифры", weight = column4Weight)
                }
            }
            items(items = data){item ->
                Row(Modifier.fillMaxWidth()) {
                    TableCell(text = item.index.toString(), weight = column1Weight)
                    TableCell(text = item.description, weight = column2Weight)
                    TableCell(text = item.num1.toString(), weight = column3Weight)
                    TableCell(text = item.num2, weight = column4Weight)
                }
            }
        }
        Spacer(modifier = Modifier.padding(top = 100.dp))
    }
}