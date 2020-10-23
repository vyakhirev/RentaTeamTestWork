package com.example.flickrapp.ui.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.flickrapp.R
import com.example.flickrapp.data.UserItem

class ListUsersAdapter(
        private val context: Context,
        private var users: List<UserItem>,
        val userClick: ((user: UserItem) -> Unit)?,

        ) : RecyclerView.Adapter<RecyclerView.ViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return ViewHolderUserItem(
                LayoutInflater.from(context).inflate(R.layout.user_item, parent, false)
        )
    }

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        if (holder is ViewHolderUserItem)
            holder.bind(users[position])

        if (holder is ViewHolderUserItem)
            holder.itemView.setOnClickListener {
                userClick?.invoke(users[position])
            }

    }

//    fun addItems(items: MutableList<UserItem?>) {
//        items.addAll(items)
//    }

    fun update(data: List<UserItem>) {
//        val movieDiffUtilCallback = DiffCallback(photos, data)
//        val diffResult = DiffUtil.calculateDiff(movieDiffUtilCallback)
//        diffResult.dispatchUpdatesTo(this)
        users = data
        notifyDataSetChanged()
    }
}