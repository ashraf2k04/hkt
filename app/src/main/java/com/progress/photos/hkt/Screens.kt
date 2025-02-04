package com.progress.photos.hkt

sealed class Screens(var route : String) {

    data object HomeScreen : Screens("home")
    data object MyHKTScreen : Screens("myHktScreen")
    data object AboutUsScreen : Screens( " aboutUs")
    data object PrivacyScreen : Screens("privacy")

}