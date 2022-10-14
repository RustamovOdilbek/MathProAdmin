package com.mathpro.admin.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mathpro.admin.databinding.ItemAddTestViewBinding
import com.mathpro.admin.helper.OnClickEvent
import com.mathpro.admin.model.Test

class AddTestAdapter(var onClickEvent: OnClickEvent)
    :  ListAdapter<Test, AddTestAdapter.ItemViewHolder>(ITEM_DIF) {

    companion object {
        val ITEM_DIF = object : DiffUtil.ItemCallback<Test>() {
            override fun areItemsTheSame(oldItem: Test, newItem: Test): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Test, newItem: Test): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class ItemViewHolder(val bn: ItemAddTestViewBinding) : RecyclerView.ViewHolder(bn.root) {
        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
            val item = getItem(position)
            with(bn) {
                tvTestNomer.text = item.id.toString()
                ll.setOnClickListener {
                    onClickEvent.setOnImageOrVedioClickListener(position)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemAddTestViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    fun submitData(list: List<Test>) {
        val items = ArrayList<Test>()
        items.addAll(currentList)
        items.addAll(list)
        items.reverse()
        submitList(items)
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(position)
    }
}