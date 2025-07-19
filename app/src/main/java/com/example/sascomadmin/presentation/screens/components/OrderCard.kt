package com.example.sascomadmin.presentation.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sascomadmin.data.model.Order

@Composable
fun OrderCard(
    order: Order,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp),
        shape = RoundedCornerShape(12.dp),
        elevation = CardDefaults.cardElevation(2.dp)
    ) {
        Column(modifier = Modifier.padding(12.dp)) {
            Text("Order ID: ${order.id}", style = MaterialTheme.typography.titleMedium)
            Text("User: ${order.userName}", style = MaterialTheme.typography.bodyMedium)
            Text("Total: ₹${order.totalAmount}", style = MaterialTheme.typography.bodyMedium)
            Text("Status: ${order.status}", style = MaterialTheme.typography.bodySmall)
        }
    }
}
