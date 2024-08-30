package com.example.assignedtasksshunyaekai.fragment.login

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.Toast
import androidx.databinding.DataBindingUtil
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import androidx.navigation.fragment.findNavController
import com.example.assignedtasksshunyaekai.utils.DataState
import com.example.assignedtasksshunyaekai.R
import com.example.assignedtasksshunyaekai.data.User
import com.example.assignedtasksshunyaekai.databinding.FragmentLoginBinding
import com.example.assignedtasksshunyaekai.repository.auth.AuthRepositoryImpl
import com.example.assignedtasksshunyaekai.utils.LoadingProgressBar


class LoginFragment : Fragment() {

    private lateinit var binding: FragmentLoginBinding
    private lateinit var loadingProgressBar: LoadingProgressBar
    private val viewModel: LoginViewModel by viewModels {
        LoginViewModelFactory(AuthRepositoryImpl())
    }


    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        // Inflate the layout for this fragment
        binding = DataBindingUtil.inflate(inflater, R.layout.fragment_login, container, false)
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

    private fun handleSignIn(it: DataState<User>?) {
        when (it) {
            is DataState.Loading -> {
                loadingProgressBar.show()
            }

            is DataState.Success -> {
                loadingProgressBar.cancel()
                findNavController().navigate(R.id.action_loginFragment_to_usersListFragment)

            }

            is DataState.Error -> {
                loadingProgressBar.cancel()
                Toast.makeText(requireContext(), it.message, Toast.LENGTH_SHORT).show()
            }

            null -> TODO()
        }

    }


}