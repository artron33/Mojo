package com.pierre.mojo_test.domain.list

import com.pierre.mojo_test.data.db.UserDao
import com.pierre.mojo_test.data.model.DataResult
import com.pierre.mojo_test.data.service.User
import com.pierre.mojo_test.data.service.UserService
import com.pierre.mojo_test.domain.model.DirectoryCreated
import com.pierre.mojo_test.domain.model.FileItem
import com.pierre.mojo_test.domain.model.NewDirectoryBody
import com.pierre.mojo_test.domain.model.Root
import kotlinx.coroutines.flow.Flow
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import kotlin.coroutines.resume
import kotlin.coroutines.suspendCoroutine


interface MemberRepository {
    suspend fun getUser(): List<User>?
    suspend fun saveUsers(users: List<User>): Unit
    suspend fun deleteUser(users: User): Unit
    suspend fun updateUser(user: List<User>): Unit

}


class MemberRepositoryImpl(
    val api: UserService,
    val dao: UserDao
) : MemberRepository {
    override suspend fun getUser(): List<User>? {
            return try {
                api.getUser()
            } catch (e: Exception) {
                null
            }
    }


    override suspend fun saveUsers(users: List<User>) {
        dao.insert(users)
    }

    override suspend fun deleteUser(user: User) {
        dao.delete(user)
    }

    override suspend fun updateUser(users: List<User>) {
        dao.update(users)
    }

}




