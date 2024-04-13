package com.example.vocabularylist.ui.adapters

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.core.widget.addTextChangedListener
import androidx.recyclerview.widget.DiffUtil
import androidx.recyclerview.widget.ListAdapter
import androidx.recyclerview.widget.RecyclerView
import com.example.vocabularylist.R
import com.example.vocabularylist.data.models.VocabularyData
import com.example.vocabularylist.databinding.ItemEditTextBinding
import com.example.vocabularylist.databinding.ItemTextBinding

class VocabularyAdapter : ListAdapter<VocabularyData, RecyclerView.ViewHolder>(DiffCallback()) {

    companion object {
        const val TEXT = 0
        const val EDITTEXT = 1
    }

    inner class TextViewHolder(private val binding: ItemTextBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val data = getItem(position)
            binding.tvText1.text = data.tectData.text1
            binding.tvText2.text = data.tectData.text2
        }
    }

    inner class EditTextViewHolder(private val binding: ItemEditTextBinding) :
        RecyclerView.ViewHolder(binding.root) {
        fun bind(position: Int) {
            val data = getItem(position)
            binding.etText1.addTextChangedListener {
                edit1?.invoke(it?.toString() ?: "")
            }
            binding.etText2.addTextChangedListener {
                edit2?.invoke(it?.toString() ?: "")
            }

            val a = clear?.invoke(Unit) ?: false
            if (a) {
                binding.etText1.setText("")
                binding.etText2.setText("")
            }
        }
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): RecyclerView.ViewHolder {
        return when (viewType) {
            EDITTEXT -> {
                val view = LayoutInflater.from(parent.context)
                    .inflate(R.layout.item_edit_text, parent, false)
                val binding = ItemEditTextBinding.bind(view)
                EditTextViewHolder(binding)
            }

            else -> {
                val view =
                    LayoutInflater.from(parent.context).inflate(R.layout.item_text, parent, false)
                val binding = ItemTextBinding.bind(view)
                TextViewHolder(binding)
            }
        }
    }

    override fun onBindViewHolder(holder: RecyclerView.ViewHolder, position: Int) {
        when (getItemViewType(position)) {
            TEXT -> {
                (holder as TextViewHolder).bind(position)
            }

            else -> {
                (holder as EditTextViewHolder).bind(position)
            }
        }
    }

    override fun getItemViewType(position: Int) = getItem(position).theView

    class DiffCallback : DiffUtil.ItemCallback<VocabularyData>() {
        override fun areItemsTheSame(oldItem: VocabularyData, newItem: VocabularyData): Boolean {
            return oldItem == newItem
        }

        override fun areContentsTheSame(oldItem: VocabularyData, newItem: VocabularyData): Boolean {
            return oldItem.tectData.id == newItem.tectData.id
        }
    }

    private var edit1: ((String) -> Unit)? = null
    fun setOnEdit1Listener(block: (String) -> Unit) {
        this.edit1 = block
    }

    private var edit2: ((String) -> Unit)? = null
    fun setOnEdit2Listener(block: (String) -> Unit) {
        this.edit2 = block
    }

    private var clear: ((Unit) -> Boolean)? = null
    fun clearEditTexts(block: ((Unit) -> Boolean)) {
        clear = block
    }
}