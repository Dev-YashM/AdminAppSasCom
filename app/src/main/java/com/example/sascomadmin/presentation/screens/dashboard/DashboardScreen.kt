package com.example.sascomadmin.presentation.screens.dashboard

import androidx.compose.material.icons.Icons
import androidx.compose.foundation.layout.*
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Search
import androidx.compose.material.icons.filled.ShoppingCart
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.sascomadmin.presentation.navigation.AdminScreen
import com.example.sascomadmin.presentation.viewmodel.DashboardViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardScreen(
    navController: NavHostController,
    viewModel: DashboardViewModel = hiltViewModel()
) {
    Scaffold(
        topBar = {
            TopAppBar(
                title = {
                    Text("Admin Dashboard", fontWeight = FontWeight.Bold)
                }
            )
        }
    ) { padding ->
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(20.dp),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            DashboardCard(
                title = "Manage Products",
                icon = Icons.Filled.Search,
                onClick = { navController.navigate(AdminScreen.ProductList.route) }
            )
            DashboardCard(
                title = "View Orders",
                icon = Icons.Default.ShoppingCart,
                onClick = { navController.navigate(AdminScreen.Orders.route) }
            )
            DashboardCard(
                title = "Users",
                icon = Icons.Default.Person,
                onClick = { navController.navigate(AdminScreen.Users.route) }
            )
        }
    }
}

@Composable
fun DashboardCard(
    title: String,
    icon: ImageVector,
    onClick: () -> Unit
) {
    ElevatedCard(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .height(100.dp),
        elevation = CardDefaults.elevatedCardElevation(defaultElevation = 4.dp)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalAlignment = Alignment.CenterVertically
        ) {
            Icon(
                imageVector = icon,
                contentDescription = title,
                modifier = Modifier.size(40.dp)
            )
            Spacer(modifier = Modifier.width(16.dp))
            Text(
                text = title,
                fontSize = 20.sp,
                fontWeight = FontWeight.Medium
            )
        }
    }
}
