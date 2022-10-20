package com.mathpro.admin.ui.fragment.users

import com.mathpro.admin.model.user.UserDeleteRequest
import com.mathpro.admin.model.user.UserDeleteResponse
import com.mathpro.admin.model.user.UsersResponse

interface UserViewModel {
    fun allUsers(block: (Result<UsersResponse>) -> Unit)
    fun deletUser(userDeleteRequest: UserDeleteRequest, block: (Result<UserDeleteResponse>) -> Unit)
}