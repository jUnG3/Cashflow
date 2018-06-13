package de.cashflow.domain.hash

import org.junit.Assert.assertEquals
import org.junit.Test

class ShaHasherTest {

    private val hasher: Hasher = ShaHasher()

    @Test
    fun testSha256Hash() {
        val expected = "753692EC36ADB4C794C973945EB2A99C1649703EA6F76BF259ABB4FB838E013E"

        assertEquals(expected, hasher.hash("Hallo"))
    }
}
