package com.example.bostatask.feature.presentation.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.bostatask.databinding.ItemDistrictBinding
import com.example.bostatask.feature.data.model.District

class DistrictAdapter :RecyclerView.Adapter<DistrictAdapter.Holder>() {

    var list : List<District> ?=null

    inner class Holder (val binding : ItemDistrictBinding):RecyclerView.ViewHolder(binding.root){

        fun bind (name : District){
            binding.tvDistrict.text=name.districtName
            if (name.pickupAvailability==false&&name.dropOffAvailability==false){
                binding.btnUncover.visibility= View.VISIBLE
            }

        }

    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): Holder {
        val binding =
            ItemDistrictBinding.inflate(LayoutInflater.from(parent.context), parent, false)
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