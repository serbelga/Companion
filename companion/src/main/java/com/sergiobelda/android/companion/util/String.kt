package com.sergiobelda.android.companion.util

import android.util.Patterns

/**
 * Returns true if a String matches the Email pattern.
 */
fun String.matchesEmail(): Boolean? = Patterns.EMAIL_ADDRESS?.matcher(this)?.matches()
