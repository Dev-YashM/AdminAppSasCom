**🛠️ SasComAdmin – Admin Dashboard for SasCom eCommerce Platform**

SasComAdmin is the official Admin Panel for managing orders, customers, and product activity on the SasCom eCommerce Platform. Built using Kotlin, Jetpack Compose, and Firebase, this app enables administrators to monitor and update real-time order statuses, view user profiles, and streamline backend workflows — all from a modern, mobile interface.

🚀 Project Overview
This app is designed for admins and delivery personnel to oversee incoming orders, manage their status (e.g., Pending, Shipped, Out for Delivery, Delivered), and monitor user details stored in Firebase Realtime Database. It works seamlessly alongside the SasCom user app, providing full control over the backend from a mobile device.

🎯 It reflects how modern businesses can use real-time dashboards powered by Firebase for live operations.

📋 Key Features
📦 View All Orders
List of user orders with total amount, order ID, and customer name.

🔄 Update Order Status
Set and modify order status (Pending, Shipped, Delivered, etc.) using dropdowns.

🧾 Detailed Order View
See items in the order including product name, quantity, and price.

👤 User Management
View customer data and addresses pulled from Firebase.

⚡ Real-time Firebase Sync
All order updates are instantly reflected in the user app via Firebase RTDB.

🧰 Tech Stack
Layer	Tech Used
Language	Kotlin
UI Framework	Jetpack Compose
Architecture	MVVM (ViewModel, StateFlow, Repository)
Backend/Database	Firebase Realtime Database
State Management	MutableStateFlow + Compose States

🔐 Firebase Setup Required
To run the app:

Use the same Firebase project as the SasCom User App.

Ensure the Realtime Database contains /orders, /users, and /products paths.

Download and place the google-services.json file inside the /app directory.

🖼️ Screenshots

Upload screenshots such as:

<img src="https://github.com/user-attachments/assets/4f05b6e7-3d27-442d-a26f-7870705fe1db" width="200"/>

<img src="https://github.com/user-attachments/assets/bc0ae3b8-4056-4be5-946b-35447472736e" width="200"/>

<img src="https://github.com/user-attachments/assets/9631c112-2748-43e8-ab35-d2bb747a0e79" width="200"/>

<img src="https://github.com/user-attachments/assets/699dd04a-5f70-4b0c-97d6-08809d6c4803" width="200"/>

<img src="https://github.com/user-attachments/assets/9bcd0182-c923-41fe-a010-04b6d36795fe" width="200"/>

<img src="https://github.com/user-attachments/assets/c845462a-af2f-422d-b6d6-a035d8ad59a3" width="200"/>

<img src="https://github.com/user-attachments/assets/9e14ec93-5d15-4ef1-9ae2-41ba852678c6" width="200"/>


🧩 Project Modules

OrderRepository.kt – Fetch and update orders from Firebase
OrderViewModel.kt – Handles admin UI logic and exposes state
OrderListScreen.kt – Displays all incoming orders
OrderCard.kt – Shows order summary with dropdown to update status
UserListScreen.kt – (Optional) View user details from Firebase

🌐 Related Projects
🛒 SasCom User App – The frontend app used by customers for shopping and placing orders.

https://github.com/Dev-YashM/SasComApplication

👨‍💻 Developed By:

Yash Maske

Android Developer | Jetpack Compose Advocate | Firebase Engineer

📬 Email Me: yash20051057@gmail.com

🔗 LinkedIn : https://www.linkedin.com/in/yash-maske

