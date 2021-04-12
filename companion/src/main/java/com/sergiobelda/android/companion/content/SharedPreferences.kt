package com.sergiobelda.android.companion.content

import android.content.SharedPreferences

/**
 * Removes all values from the preferences.
 */
fun SharedPreferences.clearAll() {
    edit().clear().apply()
}
