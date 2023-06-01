package com.example.daggerandroidexample.adapter

import android.app.Activity
import android.view.LayoutInflater
import android.view.ViewGroup
import com.example.daggerandroidexample.databinding.UserListItemBinding
import com.example.daggerandroidexample.model.Result
import com.squareup.picasso.Picasso

class UserListAdapter(
    private val context: Activity,
    private val list: ArrayList<Result>,
    private val picasso: Picasso,
) : androidx.recyclerview.widget.RecyclerView.Adapter<UserListAdapter.ViewHolder>() {

    inner class ViewHolder(val binding: UserListItemBinding) :
        androidx.recyclerview.widget.RecyclerView.ViewHolder(binding.root)

    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): ViewHolder {
        val binding =
            UserListItemBinding.inflate(LayoutInflater.from(parent.context), parent, false)

        return ViewHolder(binding)
    }

    override fun onBindViewHolder(holder: ViewHolder, position: Int) {
        val name = list[position].name
        val picture = list[position].picture

        holder.binding.textViewName.text = "${name.title} ${name.first} ${name.last}"
        holder.binding.textViewEmail.text = list[position].email
        holder.binding.textViewGender.text = list[position].gender

        picasso.load(picture.medium).into(holder.binding.imgViewProfilePic)
    }

    override fun getItemCount(): Int {
        return list.size
    }

}