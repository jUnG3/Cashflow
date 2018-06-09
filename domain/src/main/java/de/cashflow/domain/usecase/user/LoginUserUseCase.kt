package de.cashflow.domain.usecase.user

import de.cashflow.domain.model.User
import de.cashflow.domain.repository.UserNotFoundException
import de.cashflow.domain.repository.UserRepository
import de.cashflow.domain.usecase.UseCase

class LoginUserUseCase(private val userRepository: UserRepository) : UseCase<User, User> {

    override fun execute(input: User, callback: UseCase.Callback<User>) {
        try {
            callback.onSuccess(userRepository.findUserByUsername(input.username))
        } catch (e: UserNotFoundException) {
            callback.onError(e)
        }
    }

}