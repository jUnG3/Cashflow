package de.cashflow.domain.usecase.user

import de.cashflow.domain.model.User
import de.cashflow.domain.exception.UserExistsException
import de.cashflow.domain.hash.Hasher
import de.cashflow.domain.repository.UserRepository
import de.cashflow.domain.usecase.UseCase

class AddNewUserUseCase(private val userRepository: UserRepository, private val hasher: Hasher) : UseCase<User, User> {

    override fun execute(user: User, callback: UseCase.Callback<User>) {
        if (!userRepository.isUsernameTaken(user.username)) {
            onValidUser(user, callback)
        } else {
            callback.onError(UserExistsException("Username is taken"))
        }
    }

    private fun onValidUser(user: User, callback: UseCase.Callback<User>) {
        val saveUser = User(user.username, hasher.hash(user.password))
        try {
            userRepository.saveUser(saveUser)
            callback.onSuccess(saveUser)
        } catch (exception: Throwable) {
            callback.onError(exception)
        }
    }
}