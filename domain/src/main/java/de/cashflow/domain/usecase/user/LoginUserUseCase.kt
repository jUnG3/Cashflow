package de.cashflow.domain.usecase.user

import de.cashflow.domain.model.User
import de.cashflow.domain.exception.UserNotFoundException
import de.cashflow.domain.hash.Hasher
import de.cashflow.domain.repository.UserRepository
import de.cashflow.domain.usecase.UseCase

class LoginUserUseCase(private val userRepository: UserRepository, private val hasher: Hasher) : UseCase<User, User> {

    override fun execute(input: User, callback: UseCase.Callback<User>) {
        try {
            val user = userRepository.findUserByUsername(input.username)

            if (hasher.hash(input.password) != user.password) {
                throw RuntimeException("Password does not match")
            }

            callback.onSuccess(user)
        } catch (e: UserNotFoundException) {
            callback.onError(e)
        }
    }
}