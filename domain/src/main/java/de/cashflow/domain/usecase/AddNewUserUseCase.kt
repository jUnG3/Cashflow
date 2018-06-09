package de.cashflow.domain.usecase

import de.cashflow.domain.model.User
import de.cashflow.domain.repository.UserExistsException
import de.cashflow.domain.repository.UserRepository

class AddNewUserUseCase(private val userRepository: UserRepository) : UseCase<User, User> {

    override fun execute(user: User, callback: UseCase.Callback<User>) {
        if (!userRepository.isUsernameTaken(user.username)) {
            onValidUser(user, callback)
        } else {
            callback.onError(UserExistsException("Username is taken"))
        }
    }

    private fun onValidUser(user: User, callback: UseCase.Callback<User>) {
        try {
            userRepository.saveUser(user)
            callback.onSuccess(user)
        } catch (exception: Throwable) {
            callback.onError(exception)
        }
    }
}