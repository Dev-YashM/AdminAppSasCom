package com.example.sascomadmin.data.repository

import com.example.sascomadmin.data.model.Product
import com.example.sascomadmin.data.model.User
import com.google.firebase.database.FirebaseDatabase
import com.google.firebase.firestore.FirebaseFirestore
import kotlinx.coroutines.tasks.await
import javax.inject.Inject

class FirebaseDataSource @Inject constructor(
    private val firestore: FirebaseFirestore,
    private val realtimeDb: FirebaseDatabase
) {

    private val productsRef = firestore.collection("products")
    private val usersDbRef = realtimeDb.getReference("users")
    private val ordersRef = realtimeDb.getReference("orders")

    suspend fun addProduct(product: Product): Result<Unit> = try {
        productsRef.document(product.id.toString()).set(product).await() // 👈 ID stays Int, doc ID is string
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun deleteProduct(productId: String): Result<Unit> = try {
        productsRef.document(productId).delete().await()
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getAllProducts(): Result<List<Product>> = try {
        val snapshot = productsRef.get().await()
        val products = snapshot.documents.mapNotNull { doc ->
            val product = doc.toObject(Product::class.java)
            product
        }
        Result.success(products)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getAllUsers(): Result<List<User>> = try {
        val snapshot = usersDbRef.get().await()
        val users = snapshot.children.mapNotNull { child ->
            val user = child.getValue(User::class.java)
            user?.copy(uid = child.key ?: "") // <-- manually setting uid
        }
        Result.success(users)
    } catch (e: Exception) {
        Result.failure(e)
    }


    suspend fun getOrderCount(): Int = try {
        val snapshot = ordersRef.get().await()
        snapshot.childrenCount.toInt()
    } catch (e: Exception) {
        0
    }

    // Optional: Fetch all orders if needed
    suspend fun getAllOrders(): Result<List<Map<String, Any>>> = try {
        val snapshot = ordersRef.get().await()
        val orders = snapshot.children.mapNotNull { it.value as? Map<String, Any> }
        Result.success(orders)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun setAdminStatusOnline(adminId: String): Result<Unit> = try {
        realtimeDb.getReference("adminStatus/$adminId").setValue(true).await()
        Result.success(Unit)
    } catch (e: Exception) {
        Result.failure(e)
    }

    suspend fun getUserCount(): Int = try {
        val snapshot = usersDbRef.get().await()
        snapshot.childrenCount.toInt()
    } catch (e: Exception) {
        0
    }

    suspend fun getProductCount(): Int = try {
        val snapshot = productsRef.get().await()
        snapshot.size()
    } catch (e: Exception) {
        0
    }
}
