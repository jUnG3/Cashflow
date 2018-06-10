package de.cashflow.domain.repository.user

import de.cashflow.domain.model.User
import de.cashflow.domain.exception.UserNotFoundException
import de.cashflow.domain.repository.UserRepository

class InMemoryUserRepository : UserRepository {

    companion object {
        private val users: MutableMap<String, User> = HashMap()
    }

    override fun findUserByUsername(username: String): User {

        if (!users.containsKey(username)) {
            throw UserNotFoundException("User with given username does not exists")
        }

        return users[username]!!
    }

    override fun isUsernameTaken(username: String): Boolean {
        return users.containsKey(username)
    }

    override fun saveUser(user: User): Boolean {
        users[user.username] = user
        return true
    }
}