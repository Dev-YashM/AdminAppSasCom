package com.example.sascomadmin.presentation.navigation

import AddProductScreen
import androidx.compose.runtime.Composable
import androidx.hilt.navigation.compose.hiltViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.NavType
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.navArgument
import com.example.sascomadmin.presentation.screens.dashboard.DashboardScreen
import com.example.sascomadmin.presentation.screens.products.ProductListScreen
import com.example.sascomadmin.presentation.screens.users.UserListScreen
import com.example.sascomadmin.presentation.screens.orders.OrderListScreen
import com.example.sascomadmin.presentation.viewmodel.ProductViewModel
import com.example.sascomadmin.presentation.viewmodel.UserViewModel
import com.example.sascomadmin.presentation.viewmodel.OrderViewModel
import com.example.sascomadmin.presentation.viewmodel.DashboardViewModel

sealed class AdminScreen(val route: String) {
    object Dashboard : AdminScreen("dashboard")
    object ProductList : AdminScreen("products")
    object AddProduct : AdminScreen("add_product")
    object Users : AdminScreen("users")
    object Orders : AdminScreen("orders")
}

@Composable
fun AdminNavGraph(navController: NavHostController) {
    NavHost(
        navController = navController,
        startDestination = AdminScreen.Dashboard.route
    ) {
        composable(route = AdminScreen.Dashboard.route) {
            val viewModel: DashboardViewModel = hiltViewModel()
            DashboardScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(route = AdminScreen.ProductList.route) {
            val viewModel: ProductViewModel = hiltViewModel()
            ProductListScreen(
                navController = navController,
                viewModel = viewModel,
                onNavigateToAddProduct = {
                    navController.navigate(AdminScreen.AddProduct.route)
                }
            )
        }

        composable(route = AdminScreen.AddProduct.route) {
            val viewModel: ProductViewModel = hiltViewModel()
            AddProductScreen(
                navController = navController,
                viewModel = viewModel,
                onProductAdded = {
                    navController.popBackStack() // or navigate to ProductList
                }
            )
        }

        composable(route = AdminScreen.Users.route) {
            val viewModel: UserViewModel = hiltViewModel()
            UserListScreen(
                navController = navController,
                viewModel = viewModel
            )
        }

        composable(route = AdminScreen.Orders.route) {
            val viewModel: OrderViewModel = hiltViewModel()
            OrderListScreen(
                navController = navController,
                viewModel = viewModel
            )
        }
    }
}
