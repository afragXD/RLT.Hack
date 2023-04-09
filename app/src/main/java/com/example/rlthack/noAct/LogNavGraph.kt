package com.example.rlthack.noAct

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.size
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import com.example.rlthack.items.BottomNavItem
import com.example.rlthack.screens.ContactsScreen
import com.example.rlthack.screens.DashboardScreen
import com.example.rlthack.screens.RatingScreen
import com.example.rlthack.ui.theme.BottomNavColor
import com.example.rlthack.ui.theme.BottomNavSelectedColor
import com.example.rlthack.ui.theme.BottomNavUnselectedColor
import com.example.rlthack.ui.theme.MainText

@Composable
fun Navigation(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = "rating"
    ){
        composable("dashboard"){
            DashboardScreen()
        }
        composable("rating"){
            RatingScreen()
        }
        composable("contacts"){
            ContactsScreen()
        }
    }
}

@Composable
fun BottomNavigationBar(
    items: List<BottomNavItem>,
    navController: NavController,
    modifier: Modifier = Modifier,
    onItemClick:(BottomNavItem)->Unit,
){
    val  backStackEntry = navController.currentBackStackEntryAsState()
    BottomNavigation(
        modifier = modifier
            .fillMaxHeight(0.1f),
        backgroundColor = BottomNavColor,
        elevation = 5.dp,
    ){
        items.forEach{item->
            val selected = item.route == backStackEntry.value?.destination?.route
            BottomNavigationItem(
                selected = selected,
                onClick = { onItemClick(item) },
                selectedContentColor = BottomNavSelectedColor,
                unselectedContentColor = BottomNavUnselectedColor,
                icon = {
                    Column(
                        horizontalAlignment = Alignment.CenterHorizontally,
                    ) {
                        if (item.badgeCount > 0){
                            BadgedBox(
                                badge = {
                                    Badge{ Text(item.badgeCount.toString())}
                                }
                            ) {
                                Icon(
                                    modifier = Modifier.size(33.dp),
                                    imageVector = item.icon,
                                    contentDescription = item.name,
                                )
                            }
                        }else{
                            Icon(
                                modifier = Modifier.size(33.dp),
                                imageVector = item.icon,
                                contentDescription = item.name,
                            )
                        }
                        if (selected){
                            Text(
                                text = item.name,
                                textAlign = TextAlign.Center,
                                fontSize = 12.sp,
                                color = MainText,
                            )
                        }
                    }
                }
            )
        }
    }
}