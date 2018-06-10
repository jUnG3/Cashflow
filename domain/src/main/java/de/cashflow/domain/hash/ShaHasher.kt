package de.cashflow.domain.hash

import java.security.MessageDigest

class ShaHasher : Hasher {

    override fun hash(s: String): String {
        val digest = MessageDigest.getInstance("SHA-256")
        digest.update(s.toByteArray())

        val messageDigest = digest.digest()
        val hexString = StringBuffer()

        for (i in messageDigest) {
            hexString.append(String.format("%02X", i))
        }

        return hexString.toString()
    }

}