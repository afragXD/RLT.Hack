package com.example.rlthack.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.appendInlineContent
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.Divider
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rlthack.R
import com.example.rlthack.noAct.BarChart
import com.example.rlthack.noAct.LineChart
import com.example.rlthack.noAct.PieChart
import com.example.rlthack.ui.theme.*

@Preview(showBackground = true)
@Composable
fun DashboardScreen(
    //text1:String,
    //text2:String,
    //text3:String,
    //text4:String,
    //text5:String,
    //pie1:String,
    //pie2:String,
    //pie3:String,
    //num1:String,
    //num2:String,
    //num3:String,
    //num4:String,
) {

    val data1 = listOf(
        Pair(0, 0.0),
        Pair(1, 1.5),
        Pair(2, 2.1),
        Pair(3, 2.5),
        Pair(4, 3.1),
        Pair(5, 3.5),
    )
    val data2 = listOf(
        Pair(0, 0.0),
        Pair(1, 0.3),
        Pair(2, 0.6),
        Pair(3, 1.0),
        Pair(4, 2.0),
        Pair(5, 2.0),
    )

    val data3 = listOf(30f,90f,150f)
    val data4 = listOf(Pie1, Pie2, Pie3)

    val data5 =  mapOf(
        Pair(0.1f, "1"),
        Pair(0.3f, "2"),
        Pair(0.5f, "3"),
        Pair(0.7f, "4"),
        Pair(0.9f, "5"),
    )

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBack)
            .verticalScroll(rememberScrollState()),
        verticalArrangement = Arrangement.Top,
        horizontalAlignment = Alignment.CenterHorizontally,
    ) {
        Text(
            text = "DASBOARD",
            modifier = Modifier
                .padding(top = 20.dp),
            color = MainText,
            fontSize = 32.sp,
            //fontFamily =
        )
        LineChart(
            data1 = data1,
            data2 = data2,
            modifier = Modifier
                .fillMaxWidth()
                .height(200.dp)
                .align(Alignment.CenterHorizontally)
                .padding(top = 40.dp, start = 30.dp, end = 17.dp)
        )
        val names = listOf(
            "Первый номер в списке",
            "Второй номер в списке",
            "Третий номер в списке",
            "Четвертый номер в списке",
            "Пятый номер в списке"
        )
        RecyclerView(names)
        Row(
            horizontalArrangement = Arrangement.SpaceBetween,
            modifier = Modifier
                .fillMaxWidth()
                .padding(end = 28.dp, start = 18.dp, top = 37.dp)
        ) {
            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                PieChart(
                    data1 = data3,
                    data2 = data4,
                    modifier = Modifier
                        .width(200.dp)
                        .background(MainBack)
                        .padding(top = 20.dp)
                )
                Spacer(modifier = Modifier.padding(top = 200.dp))
                Text(
                    text = "Сиреневая долька",
                    color = Pie1,
                    fontSize = 14.sp,
                )
                Text(
                    text = "Розовая долька",
                    color = Pie2,
                    fontSize = 14.sp,
                )
                Text(
                    text = "Голубая долька",
                    color = Pie3,
                    fontSize = 14.sp,
                )
            }

            Column(
                verticalArrangement = Arrangement.Top,
                horizontalAlignment = Alignment.CenterHorizontally,
            ) {
                Text(
                    text = "1420",
                    modifier = Modifier,
                    color = MainText,
                    fontSize = 32.sp,
                    //fontFamily =
                )
                Text(
                    text = "чего-то",
                    modifier = Modifier,
                    color = MainText,
                    fontSize = 14.sp,
                    //fontFamily =
                )
                Text(
                    text = "5680",
                    modifier = Modifier,
                    color = MainText,
                    fontSize = 32.sp,
                    //fontFamily =
                )
                Text(
                    text = "ещё чего-то",
                    modifier = Modifier,
                    color = MainText,
                    fontSize = 14.sp,
                    //fontFamily =
                )
                Text(
                    text = "0.0% ",
                    modifier = Modifier,
                    color = MainText,
                    fontSize = 32.sp,
                    //fontFamily =
                )
                Text(
                    text = "очень много",
                    modifier = Modifier,
                    color = MainText,
                    fontSize = 14.sp,
                    //fontFamily =
                )
                Text(
                    text = "100.0% ",
                    modifier = Modifier.padding(top = 25.dp),
                    color = MainText,
                    fontSize = 32.sp,
                    //fontFamily =
                )
                Text(
                    text = "очень мало",
                    modifier = Modifier,
                    color = MainText,
                    fontSize = 14.sp,
                    //fontFamily =
                )
            }
            
        }
        BarChart(data = data5, max_value = 1000)
        Spacer(modifier = Modifier.padding(top = 100.dp))
    }
}


@Composable
fun ListItem(name:String){
    Surface(
        color = BackList,
        modifier = Modifier.padding(vertical = 4.dp, horizontal = 32.dp),
        shape = RoundedCornerShape(8.dp)
    ){
        Box(
            modifier = Modifier
                .width(331.dp)
                .height(44.dp),
            contentAlignment = Alignment.Center
        ) {
            Text(
                text = name,
                fontWeight = FontWeight.ExtraBold,
                color = MainText,
                textAlign = TextAlign.Start,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(start = 11.dp)
            )
        }
    }
}

@Composable
fun RecyclerView(
    names:List<String>
){
    Column(
        verticalArrangement = Arrangement.Center,
        modifier = Modifier
            .padding(top = 47.dp)
    ) {
        names.forEach {  name->
            ListItem(name = name)
        }
    }
}