package com.example.sascomadmin.presentation.screens.users

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavController
import com.example.sascomadmin.data.model.User
import com.example.sascomadmin.presentation.screens.components.UserCard
import com.example.sascomadmin.presentation.viewmodel.UserViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun UserListScreen(
    viewModel: UserViewModel = hiltViewModel(),
    navController: NavController
) {
    val users by viewModel.users.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    // ✅ Load users when this screen is shown
    LaunchedEffect(Unit) {
        viewModel.loadUsers()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Registered Users") }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier.padding(paddingValues)) {
            when {
                isLoading -> {
                    CircularProgressIndicator(modifier = Modifier.padding(16.dp))
                }

                users.isEmpty() -> {
                    Text("No users found.", modifier = Modifier.padding(16.dp))
                }

                else -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    ) {
                        items(users) { user ->
                            UserCard(user = user)
                        }
                    }
                }
            }
        }
    }
}
