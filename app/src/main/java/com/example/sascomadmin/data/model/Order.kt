package com.example.sascomadmin.data.model
data class Order(
    val id: String = "",
    val userName: String = "",
    val status: String = "",
    val items: List<Order> = emptyList(),
    val totalAmount: Double = 0.0,
    val timestamp: Long = 0L
)
