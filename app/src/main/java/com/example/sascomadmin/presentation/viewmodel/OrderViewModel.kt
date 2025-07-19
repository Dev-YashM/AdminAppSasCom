package com.example.sascomadmin.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.example.sascomadmin.data.model.Order
import com.example.sascomadmin.data.repository.OrderRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class OrderViewModel @Inject constructor(
    private val repository: OrderRepository
) : ViewModel() {

    private val _orders = MutableStateFlow<List<Order>>(emptyList())
    val orders: StateFlow<List<Order>> = _orders

    private val _isLoading = MutableStateFlow(false)
    val isLoading: StateFlow<Boolean> = _isLoading

    fun fetchOrders() {
        viewModelScope.launch {
            _isLoading.value = true
            repository.getAllOrders().onSuccess { fetchedOrders ->
                _orders.value = fetchedOrders
            }.onFailure {
                _orders.value = emptyList() // optional error handling
            }
            _isLoading.value = false
        }
    }

    fun updateOrderStatus(orderId: String, newStatus: String) {
        viewModelScope.launch {
            repository.updateOrderStatus(orderId, newStatus)
            fetchOrders()
        }
    }
    fun loadOrders() {
        viewModelScope.launch {
            _isLoading.value = true
            repository.getAllOrders().onSuccess { fetchedOrders ->
                _orders.value = fetchedOrders
            }.onFailure {
                _orders.value = emptyList() // Optional: log error
            }
            _isLoading.value = false
        }
    }
}
