package com.example.sascomadmin

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.navigation.compose.rememberNavController
import com.example.sascomadmin.presentation.navigation.AdminNavGraph
import com.example.sascomadmin.ui.theme.AdminAppTheme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            AdminApp()
        }
    }
}

@Composable
fun AdminApp() {
    AdminAppTheme {
        Surface(
            color = MaterialTheme.colorScheme.background
        ) {
            AdminNavGraph(navController = rememberNavController()) // if it requires navController, pass it here
        }
    }
}
