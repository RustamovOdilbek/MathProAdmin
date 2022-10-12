package com.mathpro.admin.ui.fragment.users

import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import com.mathpro.admin.R
import com.mathpro.admin.adapter.UserAdapter
import com.mathpro.admin.databinding.FragmentUsersBinding
import com.mathpro.admin.model.User

class UsersFragment : Fragment(R.layout.fragment_users) {
    private lateinit var binding: FragmentUsersBinding
    val adapter by lazy { UserAdapter() }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)
        binding = FragmentUsersBinding.bind(view)

        initViews()
    }

    private fun initViews() {
        var list = ArrayList<User>()
        for (i in 0..20){
            list.add(User(i))
        }

        adapter.submitData(list)
        binding.recyclerView.adapter = adapter

        binding.ivBack.setOnClickListener {
            requireActivity().onBackPressed()
        }
    }

}