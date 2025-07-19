package com.example.sascomadmin.presentation.screens.orders

import androidx.compose.runtime.collectAsState
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel
import androidx.navigation.NavController
import com.example.sascomadmin.data.model.Order
import com.example.sascomadmin.presentation.screens.components.OrderCard
import com.example.sascomadmin.presentation.viewmodel.OrderViewModel

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun OrderListScreen(
    viewModel: OrderViewModel = viewModel(),
    navController: NavController
) {
    val orderList by viewModel.orders.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadOrders()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Orders") }
            )
        }
    ) { padding ->
        Box(modifier = Modifier
            .fillMaxSize()
            .padding(padding)) {
            if (isLoading) {
                CircularProgressIndicator(modifier = Modifier.align(Alignment.Center))
            } else {
                if (orderList.isEmpty()) {
                    Text(
                        text = "No orders found.",
                        modifier = Modifier.align(Alignment.Center)
                    )
                } else {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(8.dp)
                    ) {
                        items(orderList) { order ->
                            OrderCard(order = order)
                            Spacer(modifier = Modifier.height(8.dp))
                        }
                    }
                }
            }
        }
    }
}

//@Composable
//fun OrderCard(order: Order) {
//    Card(
//        modifier = Modifier
//            .fillMaxWidth(),
//        elevation = CardDefaults.cardElevation(defaultElevation = 4.dp)
//    ) {
//        Column(modifier = Modifier.padding(16.dp)) {
//            Text(text = "Order ID: ${order.id}", style = MaterialTheme.typography.titleMedium)
//            Text(text = "User: ${order.userName}")
//            Text(text = "Email: ${order.userEmail}")
//            Text(text = "Total: ₹${order.totalAmount}")
//            Text(text = "Status: ${order.status}")
//        }
//    }
//}
