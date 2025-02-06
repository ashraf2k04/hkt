package com.progress.photos.hkt.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Menu
import androidx.compose.material3.DrawerState
import androidx.compose.material3.DrawerValue
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.material3.rememberDrawerState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.progress.photos.hkt.R
import com.progress.photos.hkt.ui.theme.HKTTheme
import kotlinx.coroutines.launch


@Composable
fun HomeScreen(drawerState: DrawerState) {

    val scrollState = rememberScrollState()
    val scope = rememberCoroutineScope()

    Column(modifier = Modifier.fillMaxSize().verticalScroll(state = scrollState, enabled = true )){

        Box(modifier = Modifier.fillMaxWidth()){

            Image(
                painter = painterResource(R.drawable.homeimage),
                contentScale = ContentScale.Crop,
                contentDescription = null,
                modifier = Modifier.fillMaxWidth())
            Icon(imageVector = Icons.Default.Menu, contentDescription = null,
                modifier = Modifier.padding(start=15.dp, top=50.dp).size(30.dp).clickable { scope.launch { drawerState.open() } },
                tint = Color.White)
            Text(text = "HKT\n\nPGIMS", color = Color.White, fontSize = 50.sp,
                modifier = Modifier.align(Alignment.CenterStart).padding(15.dp))
        }
        Box(modifier = Modifier.fillMaxWidth().height(150.dp).background(color = Color.Green))
        Box(modifier = Modifier.fillMaxWidth().height(150.dp).background(color = Color.Blue))
        Box(modifier = Modifier.fillMaxWidth().height(150.dp).background(color = Color.Black))
        Box(modifier = Modifier.fillMaxWidth().height(150.dp).background(color = Color.Red))
        Box(modifier = Modifier.fillMaxWidth().height(150.dp).background(color = Color.Yellow))
        Box(modifier = Modifier.fillMaxWidth().height(150.dp).background(color = Color.Green))
    }

}


@Preview(showBackground = true)
@Composable
fun HomeScreenPreview() {
    HKTTheme {
        HomeScreen(rememberDrawerState(initialValue = DrawerValue.Closed))
    }
}