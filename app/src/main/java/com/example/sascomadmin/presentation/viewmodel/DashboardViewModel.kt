package com.example.sascomadmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sascomadmin.data.repository.FirebaseDataSource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class DashboardViewModel @Inject constructor(
    private val repository: FirebaseDataSource
) : ViewModel() {

    private val _totalUsers = MutableStateFlow(0)
    val totalUsers: StateFlow<Int> = _totalUsers

    private val _totalProducts = MutableStateFlow(0)
    val totalProducts: StateFlow<Int> = _totalProducts

    private val _totalOrders = MutableStateFlow(0)
    val totalOrders: StateFlow<Int> = _totalOrders

    fun loadDashboardStats() {
        viewModelScope.launch {
            _totalUsers.value = repository.getUserCount()
            _totalProducts.value = repository.getProductCount()
            _totalOrders.value = repository.getOrderCount()
        }
    }
}
