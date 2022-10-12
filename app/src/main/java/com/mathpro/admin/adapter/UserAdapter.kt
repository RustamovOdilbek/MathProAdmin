package com.mathpro.admin.adapter

import android.annotation.SuppressLint
import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mathpro.admin.databinding.ItemUserViewBinding
import com.mathpro.admin.model.User

class UserAdapter :
    ListAdapter<User, UserAdapter.ItemViewHolder>(ITEM_DIF) {

    companion object {
        val ITEM_DIF = object : DiffUtil.ItemCallback<User>() {
            override fun areItemsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: User, newItem: User): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class ItemViewHolder(val bn: ItemUserViewBinding) : RecyclerView.ViewHolder(bn.root) {
        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
            val item = getItem(adapterPosition)
            with(bn) {

            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemUserViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(position)
    }

    fun submitData(list: List<User>) {
        val items = ArrayList<User>()
        items.addAll(currentList)
        items.addAll(list)
        items.reverse()
        submitList(items)
    }
}