package com.example.myapplication.UI.Activities

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import com.bumptech.glide.Glide
import androidx.recyclerview.widget.RecyclerView
import com.example.myapplication.R

class RewardsAdapter(private val rewardsList: List<RewardsActivity.Reward>) : RecyclerView.Adapter<RewardsAdapter.ViewHolder>() {

    inner class ViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val rewardTitle: TextView = itemView.findViewById(R.id.rewardTitle)
        val taskDescription: TextView = itemView.findViewById(R.id.taskDescription)
        val rewardImage: ImageView = itemView.findViewById(R.id.rewardImage)
    }

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val view = LayoutInflater.from(parent.context).inflate(R.layout.item_reward, parent, false)
        return ViewHolder(view)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val reward = rewardsList[position]
        holder.rewardTitle.text = reward.title
        holder.taskDescription.text = reward.taskDescription

        // Load the reward image using Glide
        Glide.with(holder.itemView.context)
            .load(reward.imageUrl)
            .into(holder.rewardImage)
    }

    override fun getItemCount(): Int {
        return rewardsList.size
    }
}

