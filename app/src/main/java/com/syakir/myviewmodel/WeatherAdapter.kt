package com.syakir.myviewmodel

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import kotlinx.android.synthetic.main.weather_items.view.*

class WeatherAdapter : RecyclerView.Adapter<WeatherAdapter.WeatherViewHolder>() {

    private val mData = ArrayList<WeatherItems>()

    fun setData(items: ArrayList<WeatherItems>) {
        mData.clear()
        mData.addAll(items)
        notifyDataSetChanged()
    }

    override fun onCreateViewHolder(
        viewGroup: ViewGroup,
        viewType: Int
    ): WeatherAdapter.WeatherViewHolder {
        val mView =
            LayoutInflater.from(viewGroup.context).inflate(R.layout.weather_items, viewGroup, false)
        return WeatherViewHolder(mView)
    }

    override fun onBindViewHolder(holder: WeatherAdapter.WeatherViewHolder, position: Int) {
        holder.bind(mData[position])
    }

    override fun getItemCount(): Int {
        return mData.size
    }

    inner class WeatherViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        fun bind(weatherItems: WeatherItems) {
            with(itemView) {
                textKota.text = weatherItems.name
                textDesc.text = weatherItems.description
                textTemp.text = weatherItems.temperature
            }
        }
    }
}