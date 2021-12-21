package com.pierre.mojo_test.presentation.screen.user

import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.pierre.mojo_test.data.service.User
import com.pierre.mojo_test.domain.list.MemberRepository
import kotlinx.coroutines.CoroutineDispatcher
import kotlinx.coroutines.Dispatchers
import kotlinx.coroutines.launch

class UserViewModel(
    private val repository: MemberRepository,
    private val dispatcher: CoroutineDispatcher = Dispatchers.Default,

    ) : ViewModel() {

    private val _liveData = MutableLiveData<List<User>?>()
    val liveData = _liveData


    init {
        getUsers()
    }

    fun getUsers() {
        viewModelScope.launch(dispatcher) {

            val users = repository.getUser()
            _liveData.postValue(users)
        }
    }

    fun deleteUser(user: User) {
        viewModelScope.launch(dispatcher) {
            repository.deleteUser(user)

            val users = repository.getUser()
            _liveData.postValue(users)
        }
    }

    fun addUsers(users: List<User>) {
        viewModelScope.launch(dispatcher) {
            repository.updateUser(users)

            val users = repository.getUser()
            _liveData.postValue(users)
        }
    }

    fun updateUsersOrder(users: List<User>) {
        viewModelScope.launch(dispatcher) {
            repository.updateUser(users)

            val users = repository.getUser()
            _liveData.postValue(users)
        }
    }
}

