package com.sergiobelda.android.companion.util

import androidx.test.ext.junit.runners.AndroidJUnit4
import junit.framework.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class StringTest {

    @Test
    fun matchesEmailTest() {
        val email = "a@a.es"
        assertEquals(true, email.matchesEmail())
        val email2 = "a.es"
        assertEquals(false, email2.matchesEmail())
        val email3 = "a@@s.es"
        assertEquals(false, email3.matchesEmail())
    }
}
