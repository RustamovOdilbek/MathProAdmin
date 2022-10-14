package com.mathpro.admin.ui.fragment.users

import android.os.Bundle
import android.util.Log
import androidx.fragment.app.Fragment
import android.view.View
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.example.mathpro.extension.timeFormat
import com.mathpro.admin.R
import com.mathpro.admin.adapter.UsersAdapter
import com.mathpro.admin.databinding.FragmentUsersBinding
import com.mathpro.admin.model.user.UserDeleteRequest
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment(R.layout.fragment_users) {
    private val TAG = "UsersFragment"
    private val binding by viewBinding(FragmentUsersBinding::bind)
    private val viewModel: UserViewModel by viewModels<UsersViewModelImp>()
    private lateinit var adapter: UsersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        adapter = UsersAdapter() {
            var userDeleteRequest = UserDeleteRequest(it)
            viewModel.deletUser(userDeleteRequest){
                it.onSuccess { userDeleteResponse ->
                    allUsers()
                    Log.d(TAG, "initViews: ${userDeleteResponse}")
                }
                it.onFailure {
                    Log.d(TAG, "error: ${it.message}")
                }
            }
        }

        allUsers()

        binding.recyclerView.adapter = adapter

        Log.d(TAG, "initViews: ${timeFormat("")}")

        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

    private fun allUsers(){
        viewModel.allUsers {
            it.onSuccess { usersResponse ->
                Log.d(TAG, "initViews: ${usersResponse}")
                adapter.submitData(usersResponse)
            }
            it.onFailure {
                Log.d(TAG, "error: ${it.message}")
            }
        }
    }

}