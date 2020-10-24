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

    companion object {
        const val VIEW_TYPE_HEADER = 0
        const val VIEW_TYPE_ITEM = 1
    }

    override fun getItemViewType(position: Int): Int {
        return if (position == 0) VIEW_TYPE_HEADER else VIEW_TYPE_ITEM
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return if (viewType == VIEW_TYPE_HEADER)
            HeaderViewHolder(LayoutInflater.from(context).inflate(R.layout.header_list_user, parent, false))
        else
            ViewHolderUserItem(
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

    fun update(data: List<UserItem>) {
//        val movieDiffUtilCallback = DiffCallback(photos, data)
//        val diffResult = DiffUtil.calculateDiff(movieDiffUtilCallback)
//        diffResult.dispatchUpdatesTo(this)
        users = data
        notifyDataSetChanged()
    }
}