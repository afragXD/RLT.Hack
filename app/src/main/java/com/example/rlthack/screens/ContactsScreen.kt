package com.example.rlthack.screens

import android.widget.Toast
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Divider
import androidx.compose.material.Text
import androidx.compose.material.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.ClipboardManager
import androidx.compose.ui.platform.LocalClipboardManager
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.platform.LocalUriHandler
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.rlthack.R
import com.example.rlthack.noAct.LineChart
import com.example.rlthack.ui.theme.BackList
import com.example.rlthack.ui.theme.Eco
import com.example.rlthack.ui.theme.MainBack
import com.example.rlthack.ui.theme.MainText

@Preview(showBackground = true)
@Composable
fun ContactsScreen() {
    val clipboardManager: ClipboardManager = LocalClipboardManager.current
    val context = LocalContext.current
    val uriHandler = LocalUriHandler.current

    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(MainBack)
            .verticalScroll(rememberScrollState())
            .padding(start = 32.dp, end = 32.dp),
        verticalArrangement = Arrangement.Top,
    ) {
        Text(
            text = "Контакты",
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            color = MainText,
            fontSize = 32.sp,
            fontFamily = Eco,
            textAlign = TextAlign.Center
        )
        Text(
            text = "Офис",
            modifier = Modifier
                .padding(top = 40.dp)
                .fillMaxWidth(),
            color = MainText,
            fontSize = 14.sp,
            fontFamily = Eco,
        )
        Text(
            text = "г. Москва, ул. Кожевническая, д.14с5",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth(),
            color = MainText,
            fontSize = 16.sp,
            fontFamily = Eco,
        )
        Text(
            text = "Электронная почта",
            modifier = Modifier
                .padding(top = 20.dp)
                .fillMaxWidth(),
            color = MainText,
            fontSize = 14.sp,
            fontFamily = Eco,
        )
        Text(
            text = "mailto:uni@roseltorg.ru",
            modifier = Modifier
                .padding(top = 8.dp)
                .fillMaxWidth()
                .clickable(enabled = true) {
                    clipboardManager.setText(AnnotatedString("mailto:uni@roseltorg.ru"))
                    Toast
                        .makeText(context, "Почта скопирована", Toast.LENGTH_SHORT)
                        .show()
                },
            color = MainText,
            fontSize = 16.sp,
            fontFamily = Eco,
        )
        TextButton(
            onClick = {
                      uriHandler.openUri("https://t.me/zakupki_hack_chat")
            },
            modifier = Modifier
                .padding(top = 60.dp)
                .height(56.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = BackList,
            ),
        ) {
            Text(
                text = "Мы в Telegram",
                color = MainText,
                fontSize = 17.sp,
                fontFamily = Eco,
            )
        }
        TextButton(
            onClick = {
                uriHandler.openUri("https://vk.com/roseltorg")
                      },
            modifier = Modifier
                .padding(top = 20.dp)
                .height(56.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = BackList,
            ),
        ) {
            Text(
                text = "Мы в ВКонтакте",
                color = MainText,
                fontSize = 17.sp,
                fontFamily = Eco,
            )
        }
        TextButton(
            onClick = {
                uriHandler.openUri("https://www.youtube.com/@RoseltorgOfficial")
            },
            modifier = Modifier
                .padding(top = 20.dp)
                .height(56.dp)
                .fillMaxWidth(),
            colors = ButtonDefaults.buttonColors(
                backgroundColor = BackList,
            ),
        ) {
            Text(
                text = "Мы в Youtube",
                color = MainText,
                fontSize = 17.sp,
                fontFamily = Eco,
            )
        }
    }
}