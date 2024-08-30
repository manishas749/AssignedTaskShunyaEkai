package com.example.assignedtasksshunyaekai.fragment.main.userList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import androidx.recyclerview.widget.ItemTouchHelper
import androidx.recyclerview.widget.LinearLayoutManager
import androidx.recyclerview.widget.RecyclerView
import com.example.assignedtasksshunyaekai.R
import com.example.assignedtasksshunyaekai.databinding.FragmentUserListBinding
import com.example.assignedtasksshunyaekai.navigator.UsersListNavigator
import com.example.assignedtasksshunyaekai.utils.LoadingProgressBar


class UsersListFragment : Fragment(), UsersListNavigator {
    private lateinit var binding: FragmentUserListBinding
    private lateinit var loadingProgressBar: LoadingProgressBar
    private val viewModel: UserListViewModel by viewModels {
        UserListViewModelFactory(this, requireActivity().application)
    }
    private lateinit var userListAdapter: UsersListAdapter


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
            DataBindingUtil.inflate(inflater, R.layout.fragment_user_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
        setRecyclerViewItemTouchListener()


    }

    private fun init() {
        binding.viewModel = viewModel
        loadingProgressBar = LoadingProgressBar(requireContext())
        viewModel.readAllUsersData.observe(viewLifecycleOwner)
        { list ->

            list.let {

                binding.recyclerView.layoutManager = LinearLayoutManager(requireContext())
                userListAdapter = UsersListAdapter(list!!)
                binding.recyclerView.adapter = userListAdapter

            }


        }
    }

    private fun setRecyclerViewItemTouchListener() {
        val itemTouchCallBack = object : ItemTouchHelper.SimpleCallback(
            0,
            ItemTouchHelper.LEFT or ItemTouchHelper.RIGHT
        ) {
            override fun onMove(
                recyclerView: RecyclerView,
                viewHolder: RecyclerView.ViewHolder,
                target: RecyclerView.ViewHolder
            ): Boolean {
                return false
            }

            override fun onSwiped(viewHolder: RecyclerView.ViewHolder, direction: Int) {
                val position = viewHolder.adapterPosition
                viewModel.deleteUsersData(userListAdapter.getUserAt(viewHolder.adapterPosition))
                binding.recyclerView.adapter!!.notifyItemRemoved(position)
                Toast.makeText(requireContext(), "User has been Deleted", Toast.LENGTH_SHORT).show()

            }
        }
        val itemTouchHelper = ItemTouchHelper(itemTouchCallBack)
        itemTouchHelper.attachToRecyclerView(binding.recyclerView)
    }

    override fun onFabButtonClick() {
        findNavController().navigate(R.id.action_usersListFragment_to_userAddFragment)
    }


}