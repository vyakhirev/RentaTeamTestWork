package com.example.rentateam.ui.adapter

import android.graphics.Color
import android.view.View
import androidx.recyclerview.widget.RecyclerView
import com.example.rentateam.data.UserItem
import kotlinx.android.synthetic.main.user_item.view.*

class ViewHolderUserItem(itemView: View) : RecyclerView.ViewHolder(itemView) {

    fun bind(item: UserItem) {
        itemView.first_name_onList_TV.setTextColor(Color.parseColor("#0972C5"))
        itemView.first_name_onList_TV.text = item.first_name
        itemView.last_name_onList_TV.setTextColor(Color.parseColor("#0972C5"))
        itemView.last_name_onList_TV.text = item.last_name
    }

}
