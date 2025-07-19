package com.example.sascomadmin.presentation.screens.products

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.example.sascomadmin.presentation.viewmodel.ProductViewModel
import com.example.sascomadmin.presentation.screens.components.ProductCard

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ProductListScreen(
    navController: NavHostController,
    viewModel: ProductViewModel = hiltViewModel(),
    onNavigateToAddProduct: () -> Unit
) {
    val productList by viewModel.products.collectAsState()
    val isLoading by viewModel.isLoading.collectAsState()

    LaunchedEffect(Unit) {
        viewModel.loadAllProducts()
    }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Products") },
                actions = {
                    IconButton(onClick = onNavigateToAddProduct) {
                        Icon(Icons.Default.Add, contentDescription = "Add Product")
                    }
                }
            )
        }
    ) { paddingValues ->
        Box(modifier = Modifier
            .padding(paddingValues)
            .fillMaxSize()) {

            when {
                isLoading -> {
                    CircularProgressIndicator(modifier = Modifier
                        .align(Alignment.Center)
                        .padding(24.dp))
                }

                productList.isEmpty() -> {
                    Text(
                        text = "No products available.",
                        modifier = Modifier
                            .align(Alignment.Center)
                            .padding(24.dp)
                    )
                }

                else -> {
                    LazyColumn(
                        modifier = Modifier
                            .fillMaxSize()
                            .padding(horizontal = 12.dp, vertical = 8.dp)
                    ) {
                        items(productList) { product ->
                            ProductCard(
                                product = product,
                                onClick = {
                                    // Optional: Navigate to product detail/edit
                                }
                            )
                        }
                    }
                }
            }
        }
    }
}
