package de.cashflow.domain.hash

import java.security.NoSuchAlgorithmException

interface Hasher {
    @Throws(NoSuchAlgorithmException::class)
    fun hash(s: String): String
}