package com.sergiobelda.android.companion.app

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Intent
import android.os.Bundle

/**
 * Launch a new Activity and runs the Intent body that will be passed to the new Activity.
 *
 * ```
 * launchActivity<MyActivity>()
 *
 * launchActivity<MyActivity> {
 *      putExtra(...)
 * }
 * ```
 *
 * @param options Additional options for how the Activity should be started.
 * @param block Intent body to start.
 * @throws [ActivityNotFoundException].
 */
inline fun <reified A : Activity> Activity.launchActivity(
    options: Bundle? = null,
    block: Intent.() -> Unit = {}
) = startActivity(
    Intent(this, A::class.java).apply(block),
    options
)

/**
 * Launch a new Activity for result and runs the Intent body that will be passed to the new Activity.
 *
 * ```
 * launchActivityForResult<MyActivity>(REQUEST_CODE)
 *
 * launchActivityForResult<MyActivity>(REQUEST_CODE) {
 *      putExtra(...)
 * }
 * ```
 *
 * @param requestCode If >= 0, this code will be returned in onActivityResult() when the activity exits.
 * @param options Additional options for how the Activity should be started.
 * @param block Intent body to start.
 * @throws [ActivityNotFoundException].
 */
inline fun <reified A : Activity> Activity.launchActivityForResult(
    requestCode: Int,
    options: Bundle? = null,
    block: Intent.() -> Unit = {}
) = startActivityForResult(Intent(this, A::class.java).apply(block), requestCode, options)
