package com.example.stylish.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stylish.databinding.TypeItemBinding
import com.example.stylish.models.Type

class TypeAdapter(
    private val context: Context
): RecyclerView.Adapter<TypeAdapter.ViewHolder>() {
    var typeData = emptyList<Type>()

    class ViewHolder(val binding: TypeItemBinding): RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = TypeItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return typeData.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = typeData[position]
    }

    fun setData(data: List<Type>) {
        val newDiffUtil = NewDiffUtils(typeData, data)
        val diffUtil = DiffUtil.calculateDiff(newDiffUtil)
        typeData = data
        diffUtil.dispatchUpdatesTo(this)
    }

    class NewDiffUtils(private val oldItem: List<Type>, private val newItem: List<Type>)
        :DiffUtil.Callback(){
        override fun getOldListSize(): Int {
            return oldItem.size
        }

        override fun getNewListSize(): Int {
            return newItem.size
        }

        override fun areItemsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItem[oldItemPosition] === newItem[newItemPosition]
        }

        override fun areContentsTheSame(oldItemPosition: Int, newItemPosition: Int): Boolean {
            return oldItem[oldItemPosition] === newItem[newItemPosition]
        }

    }
}