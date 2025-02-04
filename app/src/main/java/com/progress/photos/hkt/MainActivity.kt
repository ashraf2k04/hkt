package com.progress.photos.hkt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.width
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ModalDrawerSheet
import androidx.compose.material3.ModalNavigationDrawer
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.currentBackStackEntryAsState
import androidx.navigation.compose.rememberNavController
import com.progress.photos.hkt.screens.AboutUsScreen
import com.progress.photos.hkt.screens.HomeScreen
import com.progress.photos.hkt.screens.MyHKTScreen
import com.progress.photos.hkt.screens.PrivacyScreen
import com.progress.photos.hkt.ui.theme.HKTTheme
import kotlinx.coroutines.launch

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HKTTheme {
                Drawer()
            }
        }
    }
}


@Composable
fun Drawer(){

    val drawerState = rememberDrawerState(initialValue = DrawerValue.Closed)
    val scope = rememberCoroutineScope()

    val width = (LocalConfiguration.current.screenWidthDp * 0.75).dp
    
    val navController = rememberNavController()
    val navBackStackEntry by navController.currentBackStackEntryAsState()
    val currentDestination = navBackStackEntry?.destination?.route

    ModalNavigationDrawer(
        drawerContent = {
            ModalDrawerSheet(modifier = Modifier.width(width)){
                SideBarHeader()
                Spacer(modifier = Modifier.height(10.dp))
                if (currentDestination != null) {
                    SideBarBody(items = items, currentRoute = currentDestination) {
                        navController.navigate(it.route)
                        scope.launch{
                            drawerState.close()
                        }
                    }
                }
            }
        },
        drawerState = drawerState
        ) {
            NavHost(navController = navController, startDestination = Screens.HomeScreen.route) {
                composable(Screens.HomeScreen.route){
                    HomeScreen(drawerState)
                }
                composable(Screens.MyHKTScreen.route){
                    MyHKTScreen()
                }
                composable(Screens.AboutUsScreen.route){
                    AboutUsScreen()
                }
                composable(Screens.PrivacyScreen.route){
                    PrivacyScreen()
                }
            }
        }
    }




@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HKTTheme {
        Drawer()
    }
}