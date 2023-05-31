package com.littlelemon.littlelemon

import android.content.Context
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.tooling.preview.Preview
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.littlelemon.littlelemon.ui.theme.LittleLemonTheme

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContent {
            LittleLemonTheme {
                // A surface container using the 'background' color from the theme
                Surface(
                    modifier = Modifier.fillMaxSize(),
                    color = MaterialTheme.colors.background
                ) {
                    val navController = rememberNavController()
                   // val isLoggedIn = isUserLoggedIn()
                    MyNavigation(navController)
                }
            }
        }
    }


}

@Composable
fun MyNavigation(navController: NavHostController) {
    val context = LocalContext.current
    // NavigationComposable(navController,false)
    NavigationComposable(navController, determineStartDestination(context))

}
fun determineStartDestination(context: Context): Boolean {
    val sharedPreferences = context.getSharedPreferences("UserData", Context.MODE_PRIVATE)
    val firstName = sharedPreferences.getString("firstName", null)
    val lastName = sharedPreferences.getString("lastName", null)
    val email = sharedPreferences.getString("email", null)

    return if (firstName.isNullOrBlank() || lastName.isNullOrBlank() || email.isNullOrBlank()) {
      //  "Home" // User data is not stored, start destination is Home
        false
    } else {
       // "Onboarding" // User data is stored, start destination is Onboarding
        true
    }
}
