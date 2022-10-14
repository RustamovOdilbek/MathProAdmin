package com.mathpro.admin.ui.fragment.users

import com.mathpro.admin.model.user.UserDeleteRequest
import com.mathpro.admin.model.user.UserDeleteResponse
import com.mathpro.admin.model.user.UsersResponse

interface UserViewModel {
    fun allUsers(block: (Result<ArrayList<UsersResponse>>) -> Unit)
    fun deletUser(deleteRequest: UserDeleteRequest, block: (Result<UserDeleteResponse>) -> Unit)
}