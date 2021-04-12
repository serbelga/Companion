package com.sergiobelda.android.companion.content

import androidx.test.ext.junit.runners.AndroidJUnit4
import androidx.test.platform.app.InstrumentationRegistry
import org.junit.Assert.assertEquals
import org.junit.Test
import org.junit.runner.RunWith

@RunWith(AndroidJUnit4::class)
class ContextTest {

    @Test
    fun testGetVersionName() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals("1.0", appContext.getVersionName())
    }

    @Test
    fun testGetVersionCode() {
        val appContext = InstrumentationRegistry.getInstrumentation().targetContext
        assertEquals(1L, appContext.getVersionCode())
    }
}
