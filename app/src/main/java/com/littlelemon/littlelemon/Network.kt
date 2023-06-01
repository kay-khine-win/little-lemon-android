package com.littlelemon.littlelemon

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable

@kotlinx.serialization.Serializable
data class MenuNetworkData(
    @SerialName("menuItems")
    val menuItems: List<MenuItemNetwork>
)

@Serializable
data class MenuItemNetwork(
    @SerialName("id")
    val id: String,
    @SerialName("name")
    val name: String,
    @SerialName("price")
    val price: Double
)
