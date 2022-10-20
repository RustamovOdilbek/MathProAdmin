package com.mathpro.admin.ui.fragment.users

import android.os.Bundle
import android.view.View
import androidx.fragment.app.Fragment
import androidx.fragment.app.viewModels
import by.kirich1409.viewbindingdelegate.viewBinding
import com.mathpro.admin.R
import com.mathpro.admin.adapter.UsersAdapter
import com.mathpro.admin.databinding.FragmentUsersBinding
import com.mathpro.admin.model.user.UserDeleteRequest
import com.mathpro.admin.utils.viewExtension.back
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class UsersFragment : Fragment(R.layout.fragment_users) {
    private val binding by viewBinding(FragmentUsersBinding::bind)
    private val viewModel: UserViewModel by viewModels<UsersViewModelImp>()
    private lateinit var adapter: UsersAdapter

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        initViews()
    }

    private fun initViews() {
        adapter = UsersAdapter() { id->
            deleteUser(id)
        }

        binding.recyclerView.adapter = adapter

        allUsers()

        binding.ivBack.setOnClickListener { back() }
    }

    private fun deleteUser(id: String) {
        viewModel.deletUser(UserDeleteRequest(id = id)){
            it.onSuccess { userDeleteResponse ->
                allUsers()
            }
            it.onFailure {
            }
        }
    }

    private fun allUsers(){
        viewModel.allUsers {
            it.onSuccess { usersResponse ->
                adapter.submitList(usersResponse.data!!.users)
                binding.lToolbar.tvUserCount.text = usersResponse.data!!.number.toString()
            }
            it.onFailure {

            }
        }
    }
}