package com.mathpro.admin.ui.fragment.users

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.mathpro.admin.model.user.UserDeleteRequest
import com.mathpro.admin.model.user.UserDeleteResponse
import com.mathpro.admin.model.user.UsersResponse
import com.mathpro.admin.repository.AuthRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.launch
import javax.inject.Inject

@HiltViewModel
class UsersViewModelImp  @Inject constructor(private val authRepository: AuthRepository):
    ViewModel(),
    UserViewModel {
    override fun allUsers(block: (Result<UsersResponse>) -> Unit) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.allUsers()))
            }catch (e:Exception){
                block(Result.failure(e))
            }
        }
    }

    override fun deletUser(
        userDeleteRequest: UserDeleteRequest,
        block: (Result<UserDeleteResponse>) -> Unit
    ) {
        viewModelScope.launch {
            try {
                block(Result.success(authRepository.deleteUser(userDeleteRequest)))
            }catch (e: Exception){
                block(Result.failure(e))
            }
        }
    }
}