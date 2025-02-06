package com.progress.photos.hkt.screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.LocalPostOffice
import androidx.compose.material3.Card
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp


@Composable
fun ListScreen(){

    val items = listOf("Item 1","Item 2","Item 3","Item 4","Item 5","Item 6","Item 7","Item 8","Item 9","Item 10","Item 1","Item 2","Item 3","Item 4","Item 5","Item 6","Item 7","Item 8","Item 9","Item 10")
    LazyColumn(modifier = Modifier.fillMaxSize()) {
        items(items){
            item->
            Card(
                modifier = Modifier.fillMaxWidth().height(80.dp).padding(2.dp),
            ){
                Row(
                    modifier = Modifier
                        .fillMaxSize()
                        .background(Color(238, 122, 45, 25))
                        .padding(start = 40.dp),
                    verticalAlignment = Alignment.CenterVertically,
                    horizontalArrangement = Arrangement.Start){
                    Icon(
                        imageVector = Icons.Filled.LocalPostOffice, contentDescription = null,
                        modifier = Modifier.clip(CircleShape).size(23.dp),
                        tint = Color.Black
                        )
                    Spacer(modifier = Modifier.width(10.dp))
                    Text(text = item, modifier = Modifier.padding(10.dp), color = Color.Black, fontSize = 20.sp)
                }

            }
        }
    }
}

@Preview(showBackground = true)
@Composable
fun PreviewLazyScreen(){
    ListScreen()
}