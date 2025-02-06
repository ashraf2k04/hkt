package com.progress.photos.hkt.screens

sealed class Screens(var route : String) {

    data object HomeScreen : Screens("home")
    data object MyHKTScreen : Screens("myHktScreen")
    data object AboutUsScreen : Screens( " aboutUs")
    data object PrivacyScreen : Screens("privacy")
    data object ListScreen : Screens("listScreen")

}