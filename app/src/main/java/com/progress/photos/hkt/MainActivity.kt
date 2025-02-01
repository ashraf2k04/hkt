package com.progress.photos.hkt

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.Image
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalConfiguration
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.progress.photos.hkt.screens.HomeScreen
import com.progress.photos.hkt.ui.theme.HKTTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            HKTTheme {
                MainScreen()
            }
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun MainScreen() {

    val configuration = LocalConfiguration.current
    val screenWidth = (configuration.screenWidthDp * 0.75).dp


    var sidebarOpened by remember { mutableStateOf(false) }

    Scaffold(
        topBar = {
            TopAppBar(
                title = {Text("HKT PGIMS", modifier = Modifier.padding(start = 10.dp))},
                navigationIcon = { Image(imageVector = Icons.Default.Menu, contentDescription = null, modifier = Modifier.clickable { sidebarOpened = true }) },
                colors = TopAppBarDefaults.topAppBarColors(containerColor = Color(243, 101, 45, 100)),
                windowInsets = WindowInsets(10, 10, 10 , 0)
                )})
    {
        HomeScreen(modifier=Modifier.padding(it))

    }

    Sidebar(
        opened = sidebarOpened,
        onDismiss = { sidebarOpened = false }
    )

}

@Composable
fun Sidebar(opened: Boolean, onDismiss: () -> Unit) {
    val drawerState = rememberDrawerState(DrawerValue.Closed)



    LaunchedEffect(opened) {
        if (opened) {
            drawerState.open()
        } else {
            drawerState.close()
        }
    }
}



@Preview(showBackground = true)
@Composable
fun GreetingPreview() {
    HKTTheme {
        MainScreen()
    }
}