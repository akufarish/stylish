package com.example.stylish.adapter

import android.content.Context
import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.RecyclerView
import com.example.stylish.databinding.SplashItemsBinding
import com.example.stylish.models.Splash

class SplashAdapter(
    private val context: Context
): RecyclerView.Adapter<SplashAdapter.ViewHolder>() {
    var dataSplash = emptyList<Splash>()

    class ViewHolder(val binding: SplashItemsBinding): RecyclerView.ViewHolder(binding.root) {
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding = SplashItemsBinding.inflate(LayoutInflater.from(context), parent, false)
        return ViewHolder(binding)
    }

    override fun getItemCount(): Int {
        return dataSplash.size
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val currentItem = dataSplash[position]
        holder.binding.splashImageView.setImageResource(currentItem.image)
        holder.binding.splashDesc.text = currentItem.desc
        holder.binding.splashTitle.text = currentItem.title
    }

    fun setData(data: List<Splash>) {
        val newDiffUtil = NewDiffUtils(dataSplash, data)
        val diffUtils = DiffUtil.calculateDiff(newDiffUtil)
        dataSplash = data
        diffUtils.dispatchUpdatesTo(this)
    }

    class NewDiffUtils(
        private val oldItem: List<Splash>,
        private val newItem: List<Splash>
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