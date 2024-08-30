package com.example.assignedtasksshunyaekai.fragment.main.userList

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.assignedtasksshunyaekai.R
import com.example.assignedtasksshunyaekai.databinding.FragmentLoginBinding
import com.example.assignedtasksshunyaekai.databinding.FragmentUserListBinding
import com.example.assignedtasksshunyaekai.fragment.login.LoginViewModel
import com.example.assignedtasksshunyaekai.fragment.login.LoginViewModelFactory
import com.example.assignedtasksshunyaekai.navigator.UsersListNavigator
import com.example.assignedtasksshunyaekai.repository.auth.AuthRepositoryImpl
import com.example.assignedtasksshunyaekai.utils.LoadingProgressBar
import kotlin.concurrent.thread


class UsersListFragment : Fragment(),UsersListNavigator{
    private lateinit var binding: FragmentUserListBinding
    private lateinit var loadingProgressBar: LoadingProgressBar
    private val viewModel: UserListViewModel by viewModels {
        UserListViewModelFactory(this)
    }



    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding =
                DataBindingUtil.inflate(inflater,R.layout.fragment_user_list, container, false)
        return binding.root
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        init()

    }

    private fun init() {
        binding.viewModel = viewModel
        loadingProgressBar = LoadingProgressBar(requireContext())
    }

    override fun onFabButtonClick() {
        findNavController().navigate(R.id.action_usersListFragment_to_userAddFragment)
    }


}