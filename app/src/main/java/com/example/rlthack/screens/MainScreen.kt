package com.example.rlthack.screens

import android.annotation.SuppressLint
import androidx.compose.material.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.vectorResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.compose.rememberNavController
import com.example.rlthack.R
import com.example.rlthack.items.BottomNavItem
import com.example.rlthack.noAct.BottomNavigationBar
import com.example.rlthack.noAct.Navigation

@Preview(showBackground = true)
@Composable
@SuppressLint("UnusedMaterialScaffoldPaddingParameter")
fun MainScreen() {
    val navController = rememberNavController()
    Scaffold(
        bottomBar = {
            BottomNavigationBar(
                items = listOf(
                    BottomNavItem(
                        name = "DASBOARD",
                        route = "dashboard",
                        icon = ImageVector.vectorResource(id = R.drawable.bottom_nav_iten_dashboard)
                    ),
                    BottomNavItem(
                        name = "Рейтинг",
                        route = "rating",
                        icon = ImageVector.vectorResource(id = R.drawable.bottom_nav_item_list)
                    ),
                    BottomNavItem(
                        name = "Контакты",
                        route = "contacts",
                        icon = ImageVector.vectorResource(id = R.drawable.bottom_nav_item_contacts)
                    ),
                ), 
                navController = navController,
                onItemClick = {
                    navController.navigate(it.route)
                }
            )
        }
    ) {
        Navigation(
            navController = navController,
        )
    }
}