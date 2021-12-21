package com.pierre.mojo_test.presentation.screen.design.card

import android.content.Context
import android.graphics.Typeface
import android.util.AttributeSet
import android.util.TypedValue
import android.view.LayoutInflater
import android.widget.Button
import android.widget.TextView
import androidx.appcompat.widget.AppCompatTextView
import androidx.cardview.widget.CardView
import com.pierre.mojo_test.R
import com.pierre.mojo_test.data.service.User

class UserRow @JvmOverloads constructor(
    context: Context,
    attrs: AttributeSet? = null,
    defStyleAttr: Int = 0
) : CardView(context, attrs, defStyleAttr) {

    init {
        LayoutInflater.from(context).inflate(R.layout.row_user, this)
    }


    fun init(
        user: User,
        reorder: (user: User, isUp: Boolean) -> Unit,
        delete: (user: User) -> Unit
    ) {

        findViewById<TextView>(R.id.user_card_title_main).text = user.name
        findViewById<TextView>(R.id.user_card_title_sub).text = user.position
        findViewById<TextView>(R.id.user_card_title_loc).text = user.location
        findViewById<TextView>(R.id.user_card_image).text = user.pic
        findViewById<Button>(R.id.user_card_button_up).text = "up"
        findViewById<Button>(R.id.user_card_button_up).setOnClickListener {
            reorder.invoke(user, true)
        }
        findViewById<Button>(R.id.user_card_button_down).text = "down"
        findViewById<Button>(R.id.user_card_button_down).setOnClickListener {
            reorder.invoke(user, true)
        }
        findViewById<Button>(R.id.user_card_button_delete).text = "delete"
        findViewById<Button>(R.id.user_card_button_delete).setOnClickListener {
            delete.invoke(user)
        }
    }
}



