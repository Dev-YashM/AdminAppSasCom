package com.example.sascomadmin.data.repository

import com.example.sascomadmin.data.model.Order
import com.google.firebase.database.DatabaseReference
import com.google.firebase.database.FirebaseDatabase
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class OrderRepository @Inject constructor() {

    private val database: DatabaseReference = FirebaseDatabase.getInstance().getReference("orders")

    suspend fun getAllOrders(): Result<List<Order>> {
        return try {
            val snapshot = database.get().await()
            val orders = mutableListOf<Order>()
            for (child in snapshot.children) {
                val order = child.getValue(Order::class.java)
                order?.let { orders.add(it) }
            }
            Result.success(orders)
        } catch (e: Exception) {
            Result.failure(e)
        }
    }

    suspend fun updateOrderStatus(orderId: String, newStatus: String): Boolean {
        return try {
            database.child(orderId).child("status").setValue(newStatus).await()
            true
        } catch (e: Exception) {
            false
        }
    }
}
