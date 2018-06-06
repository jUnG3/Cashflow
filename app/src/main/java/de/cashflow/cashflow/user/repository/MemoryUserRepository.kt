package de.cashflow.cashflow.user.repository

class MemoryUserRepository : UserRepository {

    companion object {
        private var users: MutableMap<String, String> = HashMap()
    }

    override fun checkUser(username: String): Boolean {
        return users.containsKey(username)
    }

    override fun saveUser(username: String, password: String) {
        users[username] = password
    }

    override fun fetchUser(username: String): String? {
        return users[username]
    }
}