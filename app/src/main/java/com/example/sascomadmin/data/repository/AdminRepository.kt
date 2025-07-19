package com.example.sascomadmin.data.repository

import com.example.sascomadmin.data.model.Product
import com.example.sascomadmin.data.model.User
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class AdminRepository @Inject constructor(
    private val firebaseDataSource: FirebaseDataSource
) {

    suspend fun addProduct(product: Product) = firebaseDataSource.addProduct(product)

    suspend fun deleteProduct(productId: String) = firebaseDataSource.deleteProduct(productId)

    suspend fun getAllProducts() = firebaseDataSource.getAllProducts()

    suspend fun getAllUsers() = firebaseDataSource.getAllUsers()

    suspend fun getOrderCount() = firebaseDataSource.getOrderCount()

    suspend fun setAdminOnline(adminId: String) = firebaseDataSource.setAdminStatusOnline(adminId)

}
