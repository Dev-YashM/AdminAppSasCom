package com.example.sascomadmin.presentation.screens.components

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.example.sascomadmin.data.model.User

@Composable
fun UserCard(
    user: User,
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
            Text(text = "Name: ${user.name}", style = MaterialTheme.typography.titleMedium)
            Text(text = "Email: ${user.email}", style = MaterialTheme.typography.bodyMedium)
        }
    }
}
