package com.example.bostatask.feature.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import androidx.transition.Visibility
import com.example.bostatask.databinding.ItemCityBinding
import com.example.bostatask.feature.data.model.Data

class CitiesAdapter (val onClick:(Int)->Unit) :RecyclerView.Adapter<CitiesAdapter.Holder>(){

    var list : List<Data> ?=null

    inner class Holder (val binding : ItemCityBinding):RecyclerView.ViewHolder(binding.root){

        init {
            binding.icExpand.setOnClickListener {
                onClick.invoke(layoutPosition)
            }
        }

        fun bind (name : Data){
//            var adapter = DistrictAdapter()
            binding.tvCity.text=name.cityName
//            adapter.list=name.districts
//
//
//
//            binding.recyclerDistrict.adapter = adapter
//            binding.recyclerDistrict.layoutManager = LinearLayoutManager(binding.root.context)
            var rotationAngle = 0f
            binding.icExpand.animate()
                .rotation(rotationAngle)
                .setDuration(500)
                .start()
            if ( name.isExpanded ==true){
                if (binding.recyclerDistrict.adapter == null) {
                    val adapter = DistrictAdapter()
                    adapter.list = name.districts
                    binding.recyclerDistrict.layoutManager = LinearLayoutManager(binding.root.context)
                    binding.recyclerDistrict.adapter = adapter
                }
                binding.layoutDistricts.visibility= View.VISIBLE
                rotationAngle =180f
            }
            else{
                binding.layoutDistricts.visibility= View.GONE
                rotationAngle = 0f
            }
            binding.icExpand.animate()
                .rotation(rotationAngle)
                .setDuration(500)
                .start()



        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemCityBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return Holder(binding)
    }

    override fun getItemCount(): Int {
        return list?.size ?: 0
    }

    override fun onBindViewHolder(holder: Holder, position: Int) {
        val string = list?.get(position)
        holder.bind(string!!)
    }
}