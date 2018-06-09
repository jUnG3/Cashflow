package de.cashflow.domain.repository

import de.cashflow.domain.model.User

interface UserRepository {

    fun findUserByUsername(username: String): User

    fun isUsernameTaken(username: String): Boolean

    fun saveUser(user: User): Boolean
}