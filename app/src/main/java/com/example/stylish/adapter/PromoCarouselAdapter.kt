package com.example.stylish.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stylish.databinding.PromoItemBinding
import com.example.stylish.models.PromoCarousel

class PromoCarouselAdapter(
    private val context: Context
) : RecyclerView.Adapter<PromoCarouselAdapter.ViewHolder>() {

    var dataPromo = emptyList<PromoCarousel>()

    class ViewHolder(val binding: PromoItemBinding) : RecyclerView.ViewHolder(binding.root) {

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = PromoItemBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataPromo.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataPromo[position]
    }

    fun setData(data: List<PromoCarousel>) {
        val newDiffUtils = NewDiffUtils(dataPromo, data)
        val diffUtils = DiffUtil.calculateDiff(newDiffUtils)
        dataPromo = data
        diffUtils.dispatchUpdatesTo(this)
    }

    class NewDiffUtils(
        private val oldItem: List<PromoCarousel>,
        private val newItem: List<PromoCarousel>
    ): DiffUtil.Callback() {
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