package com.example.assignedtasksshunyaekai.fragment.main.userList

import android.view.LayoutInflater
import android.view.ViewGroup
import androidx.recyclerview.widget.RecyclerView
import com.example.assignedtasksshunyaekai.data.UsersData
import com.example.assignedtasksshunyaekai.databinding.RecyclerRowBinding

class UsersListAdapter(private val usersList: List<UsersData>) :
    RecyclerView.Adapter<UsersListAdapter.ViewHolder>() {


    override fun onCreateViewHolder(parent: ViewGroup, viewType: Int): UsersListAdapter.ViewHolder {
        val binding = RecyclerRowBinding.inflate(LayoutInflater.from(parent.context), parent, false)
        return ViewHolder(binding)

    }

    override fun onBindViewHolder(holder: UsersListAdapter.ViewHolder, position: Int) {
        holder.binding.nameDisplay.text = usersList[position].name
        holder.binding.emailDisplay.text = usersList[position].email


    }

    override fun getItemCount(): Int {
        return usersList.size
    }

    fun getUserAt(position: Int): UsersData {
        return usersList.get(position)

    }

    inner class ViewHolder(val binding: RecyclerRowBinding) :
        RecyclerView.ViewHolder(binding.root) {

    }

}