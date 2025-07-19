package com.example.sascomadmin.data.utils

object Constants {

    // Firebase Collection Names
    const val PRODUCTS_COLLECTION = "products"
    const val USERS_COLLECTION = "users"
    const val ORDERS_COLLECTION = "orders"

    // Firebase Realtime DB nodes (if used)
    const val REALTIME_STATS_NODE = "stats"
    const val REALTIME_ORDERS_NODE = "live_orders"

    // Navigation Routes
    const val ROUTE_DASHBOARD = "dashboard"
    const val ROUTE_PRODUCTS = "products"
    const val ROUTE_ADD_PRODUCT = "add_product"
    const val ROUTE_USERS = "users"
    const val ROUTE_ORDERS = "orders"

    // Other Constants
    const val ADMIN_ROLE = "admin"
    const val DEFAULT_PRODUCT_IMAGE = "https://via.placeholder.com/150"

    // Firebase Keys (fields in documents)
    const val KEY_NAME = "name"
    const val KEY_EMAIL = "email"
    const val KEY_PRICE = "price"
    const val KEY_DESCRIPTION = "description"
    const val KEY_IMAGE_URL = "imageUrl"
    const val KEY_CATEGORY = "category"
    const val KEY_TIMESTAMP = "timestamp"
    const val KEY_STATUS = "status"

    // Order Status Constants
    const val STATUS_PENDING = "Pending"
    const val STATUS_SHIPPED = "Shipped"
    const val STATUS_DELIVERED = "Delivered"
    const val STATUS_CANCELLED = "Cancelled"
}
