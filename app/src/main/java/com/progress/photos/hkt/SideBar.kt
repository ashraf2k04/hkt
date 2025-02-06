package com.progress.photos.hkt

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.wrapContentSize
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Bookmark
import androidx.compose.material.icons.filled.Home
import androidx.compose.material.icons.filled.PrivacyTip
import androidx.compose.material.icons.filled.SupervisorAccount
import androidx.compose.material.icons.outlined.BookmarkBorder
import androidx.compose.material.icons.outlined.Home
import androidx.compose.material.icons.outlined.PrivacyTip
import androidx.compose.material.icons.outlined.SupervisorAccount
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationDrawerItem
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.progress.photos.hkt.screens.Screens

data class SideBarItems(
    val pageName: String,
    val route : String,
    val selectedIcon : ImageVector,
    val unSelectedIcon : ImageVector,
    val isSelected : Boolean,
    val badgeCount : Int? = null)



val items : List<SideBarItems>  = listOf(
    SideBarItems("Home", Screens.HomeScreen.route, Icons.Filled.Home, Icons.Outlined.Home, isSelected = true),
    SideBarItems("MyHKT", Screens.MyHKTScreen.route, Icons.Filled.Bookmark, Icons.Outlined.BookmarkBorder, isSelected = false),
    SideBarItems("About Us", Screens.AboutUsScreen.route, Icons.Filled.SupervisorAccount, Icons.Outlined.SupervisorAccount, isSelected = false),
    SideBarItems("Privacy", Screens.PrivacyScreen.route, Icons.Filled.PrivacyTip, Icons.Outlined.PrivacyTip, isSelected = false)
)


@Composable
fun SideBarHeader(){
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center,
        modifier = Modifier.fillMaxWidth()
    ) {
        Image(painter = painterResource(R.drawable.homeimage), contentDescription = null, modifier = Modifier.clip(
            CircleShape).size(100.dp))
        Text("MKT PGIMS")
    }
}

@Composable
fun SideBarBody(
    items : List<SideBarItems>,
    currentRoute : String,
    onClick : (SideBarItems)->Unit
){
    items.forEachIndexed { _, sideBarItem ->
        NavigationDrawerItem(
            label = { Text(sideBarItem.pageName)},
            selected = currentRoute==sideBarItem.route,
            onClick = {onClick(sideBarItem)},
            icon = { Icon(
                imageVector = if(currentRoute == sideBarItem.route){sideBarItem.selectedIcon} else sideBarItem.unSelectedIcon,
                contentDescription = null
            )},
            modifier = Modifier.padding(horizontal = 15.dp, vertical = 5.dp).wrapContentSize()
        )
    }
}