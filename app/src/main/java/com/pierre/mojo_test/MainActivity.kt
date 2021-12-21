package com.pierre.mojo_test

import android.os.Bundle
import android.widget.LinearLayout
import androidx.appcompat.app.AppCompatActivity
import androidx.room.Room
import com.pierre.mojo_test.data.db.MojoDatabase
import com.pierre.mojo_test.data.service.User
import com.pierre.mojo_test.data.service.UserService
import com.pierre.mojo_test.data.service.getRetrofitWithCacheNotEnabled
import com.pierre.mojo_test.domain.list.MemberRepositoryImpl
import com.pierre.mojo_test.presentation.screen.design.card.UserRow
import com.pierre.mojo_test.presentation.screen.user.UserViewModel

class MainActivity : AppCompatActivity() {

    private val viewModel: UserViewModel = UserViewModel(
        MemberRepositoryImpl(
            getRetrofitWithCacheNotEnabled().create(UserService::class.java),
            Room.databaseBuilder(
                applicationContext,
                MojoDatabase::class.java, "database-name"
            ).build().userDao()
        )
    )


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)

        setContentView(R.layout.content_main)
        viewModel.liveData.observe(this) {
            if (it != null) {
                val layout = findViewById<LinearLayout>(R.id.main_layout)
                layout.removeAllViews()

                it.forEach {
                    layout.addView(
                        UserRow(this).apply {
                            init(it, ::isUpp, ::delete)
                        }
                    )
                }
            }
        }
    }


    fun isUpp(user: User, isUp: Boolean) {
        viewModel.liveData.value ?: return
        val userTemps = viewModel.liveData.value
        val index = viewModel.liveData.value?.indexOf(user)

//        userTemps?.drop
//        viewModel.updateUsersOrder(user)

    }

    fun delete(user: User) {
        viewModel.deleteUser(user)
    }


}
