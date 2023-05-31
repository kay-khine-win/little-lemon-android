package com.littlelemon.littlelemon

interface Destinations {
    val route: String

}

object Home : Destinations {
    override val route = "Home"
}
object Profile : Destinations{
    override val route = "Profile"

}