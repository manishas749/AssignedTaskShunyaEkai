package com.example.assignedtasksshunyaekai.fragment.main.userAdd

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.assignedtasksshunyaekai.R
import com.example.assignedtasksshunyaekai.data.UsersData
import com.example.assignedtasksshunyaekai.databinding.FragmentUserAddBinding
import com.example.assignedtasksshunyaekai.utils.DataState
import com.example.assignedtasksshunyaekai.utils.LoadingProgressBar


class UserAddFragment : Fragment() {

    private lateinit var binding: FragmentUserAddBinding
    private lateinit var loadingProgressBar: LoadingProgressBar
    private val viewModel: UserAddViewModel by viewModels {
        UserAddViewModelFactory(application = requireActivity().application)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =  DataBindingUtil.inflate(inflater,R.layout.fragment_user_add, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()
    }

    private fun init() {
        binding.viewModel = viewModel
        loadingProgressBar = LoadingProgressBar(requireContext())
        viewModel.userLiveData.observe(viewLifecycleOwner)
        {
            handleSignIn(it)
        }

    }

    private fun handleSignIn(it: DataState<UsersData>?) {
        when (it) {
            is DataState.Loading -> {
                loadingProgressBar.show()
            }

            is DataState.Success -> {
                loadingProgressBar.cancel()
                findNavController().navigate(R.id.action_userAddFragment_to_usersListFragment)

            }

            is DataState.Error -> {
                loadingProgressBar.cancel()
                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
            }

            null -> TODO()
        }

    }



}