package com.mathpro.admin.adapter

import android.annotation.SuppressLint
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.mathpro.admin.databinding.ItemChapterViewBinding
import com.mathpro.admin.model.chapter.Bobs

class ChapterAdapter(private var onItemClicked: ((String) -> Unit)):
    ListAdapter<Bobs, ChapterAdapter.ItemViewHolder>(ITEM_DIF) {

    companion object {
        val ITEM_DIF = object : DiffUtil.ItemCallback<Bobs>() {
            override fun areItemsTheSame(oldItem: Bobs, newItem: Bobs): Boolean {
                return oldItem == newItem
            }

            override fun areContentsTheSame(oldItem: Bobs, newItem: Bobs): Boolean {
                return oldItem == newItem
            }

        }
    }

    inner class ItemViewHolder(val bn: ItemChapterViewBinding) : RecyclerView.ViewHolder(bn.root) {
        @SuppressLint("SetTextI18n")
        fun bind(position: Int) {
            val item = getItem(itemCount - position - 1)
            with(bn) {
                tvBob.text = "${position+1}-Bob-${item.Name}"
                ivNext.setOnClickListener {
                    onItemClicked.invoke(item.ID!!)
                }
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ItemViewHolder {
        return ItemViewHolder(
            ItemChapterViewBinding.inflate(
                LayoutInflater.from(parent.context),
                parent,
                false
            )
        )
    }

    override fun onBindViewHolder(holder: ItemViewHolder, position: Int) {
        holder.bind(position)
    }

    fun submitData(list: List<Bobs>) {
        val items = ArrayList<Bobs>()
        items.addAll(currentList)
        items.addAll(list)
        items.reverse()
        submitList(items)
    }
}