package com.unityfoods.mmvmcoroutineretrofit.adapter

import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView
import android.widget.TextView
import androidx.recyclerview.widget.RecyclerView
import com.bumptech.glide.Glide
import com.unityfoods.mmvmcoroutineretrofit.R
import com.unityfoods.mmvmcoroutineretrofit.model.ApiUser


class Adapter(
    private val users: ArrayList<ApiUser>
) : RecyclerView.Adapter<Adapter.DataViewHolder>() {

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int) =
        DataViewHolder(
            LayoutInflater.from(parent.context).inflate(
                R.layout.item_layout, parent,
                false
            )
        )

    override fun getItemCount(): Int = users.size

    override fun onBindViewHolder(holder: DataViewHolder, position: Int) =
        holder.bind(users[position])

    fun addData(list: List<ApiUser>) {
        users.addAll(list)
    }

    inner class DataViewHolder(itemView: View) : RecyclerView.ViewHolder(itemView) {
        val textViewUserName: TextView
        val textViewUserEmail: TextView
        val imageViewAvatar: ImageView

        init {
            textViewUserName = itemView.findViewById(R.id.textViewUserName)
            textViewUserEmail = itemView.findViewById(R.id.textViewUserEmail)
            imageViewAvatar = itemView.findViewById(R.id.imageViewAvatar)
        }


        fun bind(user: ApiUser) {
            textViewUserName.text = user.name
            textViewUserEmail.text = user.email
            Glide.with(imageViewAvatar.context)
                .load(user.avatar)
                .into(imageViewAvatar)
        }


    }


}