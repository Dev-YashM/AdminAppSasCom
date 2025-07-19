    package com.example.sascomadmin.presentation.viewmodel

    import androidx.lifecycle.ViewModel
    import androidx.lifecycle.viewModelScope
    import com.example.sascomadmin.data.model.User
    import com.example.sascomadmin.data.repository.AdminRepository
    import dagger.hilt.android.lifecycle.HiltViewModel
    import kotlinx.coroutines.flow.MutableStateFlow
    import kotlinx.coroutines.flow.StateFlow
    import kotlinx.coroutines.launch
    import javax.inject.Inject

    @HiltViewModel
    class UserViewModel @Inject constructor(
        private val repository: AdminRepository

    ) : ViewModel() {

        private val _users = MutableStateFlow<List<User>>(emptyList())
        val users: StateFlow<List<User>> = _users

        private val _isLoading = MutableStateFlow(false)
        val isLoading: StateFlow<Boolean> = _isLoading

        fun loadUsers() {
            viewModelScope.launch {
                _isLoading.value = true
                val result = repository.getAllUsers()
                result.onSuccess { userList ->
                    _users.value = userList
                }.onFailure {
                    _users.value = emptyList() // Or handle error appropriately
                }
                _isLoading.value = false
            }
        }

    }