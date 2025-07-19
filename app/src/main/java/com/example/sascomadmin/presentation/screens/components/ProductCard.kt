package com.example.sascomadmin.presentation.screens.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import coil.compose.AsyncImage
import com.example.sascomadmin.data.model.Product

@Composable
fun ProductCard(
    product: Product,
    onClick: () -> Unit,
    modifier: Modifier = Modifier
) {
    Card(
        modifier = modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable { onClick() },
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(4.dp)
    ) {
        Row(modifier = Modifier.padding(12.dp)) {
            AsyncImage(
                model = product.image,
                contentDescription = product.title,
                modifier = Modifier
                    .size(80.dp)
                    .padding(end = 12.dp)
            )

            Column(modifier = Modifier.align(Alignment.CenterVertically)) {
                Text(product.title, style = MaterialTheme.typography.titleMedium, fontWeight = FontWeight.Bold)
                Text("₹${product.price}", style = MaterialTheme.typography.bodyMedium)
                Text("Stock: ${product.stock}", style = MaterialTheme.typography.bodySmall)
            }
        }
    }
}
