package com.mathpro.admin.adapter

import android.annotation.SuppressLint
import android.os.Build
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.annotation.RequiresApi
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mathpro.admin.databinding.ItemUserViewBinding
import com.mathpro.admin.helper.OnClickEvent
import com.mathpro.admin.model.user.Users
import com.mathpro.admin.model.user.UsersResponse
import com.mathpro.admin.utils.viewExtension.dateConvert

class UsersAdapter(private var onItemClicked: ((String) -> Unit)) :
    ListAdapter<Users, UsersAdapter.ItemViewHolder>(ITEM_DIF) {

    companion object {
        val ITEM_DIF = object : DiffUtil.ItemCallback<Users>() {
            override fun areItemsTheSame(oldItem: Users, newItem: Users): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Users, newItem: Users): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class ItemViewHolder(val bn: ItemUserViewBinding) : RecyclerView.ViewHolder(bn.root) {
        @RequiresApi(Build.VERSION_CODES.O)
        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
            val item = getItem(position)
            with(bn) {
                tvFullName.text = item.FullName
                tvAddress.text = item.Viloyat
                tvStudy.text = "(${item.Study})"
                tvUserBirth.text = dateConvert(item.BirthDate!!)
                tvEmail.text = item.Email
                tvPhoneNumber.text = item.Phone
                ivDelete.setOnClickListener {
                    onItemClicked.invoke(item.ID!!)
                }

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

//    fun submitData(list: List<Users>) {
//        val items = ArrayList<Users>()
//        items.addAll(currentList)
//        items.addAll(list)
//        submitList(items)
//    }
}