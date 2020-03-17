package com.syakir.academy.detail

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.syakir.academy.R
import com.syakir.academy.data.ModuleEntity
import kotlinx.android.synthetic.main.items_module_list.view.*

class DetailCourseAdapter : RecyclerView.Adapter<DetailCourseAdapter.ModuleViewHolder>() {

    private var listModules = ArrayList<ModuleEntity>()

    fun setModules(modules: List<ModuleEntity>?) {
        if (modules == null) return
        listModules.clear()
        listModules.addAll(modules)
    }

    inner class ModuleViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(module: ModuleEntity) {
            with(itemView) {
                text_module_title.text = module.title
            }
        }
    }

    override fun onCreateViewHolder(
        parent: ViewGroup,
        viewType: Int
    ): DetailCourseAdapter.ModuleViewHolder {
        val view =
            LayoutInflater.from(parent.context).inflate(R.layout.items_module_list, parent, false)
        return ModuleViewHolder(view)
    }

    override fun getItemCount(): Int = listModules.size

    override fun onBindViewHolder(holder: DetailCourseAdapter.ModuleViewHolder, position: Int) {
        val module = listModules[position]
        holder.bind(module)
    }
}