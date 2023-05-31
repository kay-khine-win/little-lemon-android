package com.littlelemon.littlelemon

import android.content.Context
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Button
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController

@Composable
fun Profile(navController: NavHostController) {
    val context = LocalContext.current

    Column {
        // Profile information
        Header()
        Text("Profile information:")
        Spacer(modifier = Modifier.height(8.dp))

        // Display user data
        val userData = retrieveUserData(context)

        Column {
            Text("First Name: ${userData.firstName}")
            Text("Last Name: ${userData.lastName}")
            Text("Email: ${userData.email}")
        }

        Button(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .background(color = Color(0xf4ce14)),
            onClick = {
                navController.navigate("Home") // Navigate back to the Home screen
            }
        ) {
            Text("Go back to Home")
        }

        Button(modifier = Modifier
            .padding(16.dp)
            .fillMaxWidth()
            .wrapContentSize(Alignment.Center)
            .background(color = Color(0xf4ce14)),
            onClick = {
                navController.navigate("Onboarding") // Navigate from Profile to Onboarding
            }
        ) {
            Text("Logout")
        }
    }

}

fun retrieveUserData(context: Context): com.littlelemon.littlelemon.UserData {
    val sharedPreferences = context.getSharedPreferences("UserData", Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString("firstName", "") ?: ""
    val lastName = sharedPreferences.getString("lastName", "") ?: ""
    val email = sharedPreferences.getString("email", "") ?: ""
    return UserData(firstName, lastName, email)
}

data class UserData(
    val firstName: String,
    val lastName: String,
    val email: String
)