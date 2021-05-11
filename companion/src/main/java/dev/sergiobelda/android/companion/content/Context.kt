/*
 * Copyright 2021 Sergio Belda
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     http://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */

package dev.sergiobelda.android.companion.content

import android.app.Activity
import android.content.ActivityNotFoundException
import android.content.Context
import android.content.Intent
import android.content.pm.PackageManager
import android.os.Build
import android.os.Bundle
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi

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
inline fun <reified A : Activity> Context.launchActivity(
    options: Bundle? = null,
    block: Intent.() -> Unit = {}
) = startActivity(
    Intent(this, A::class.java).apply(block),
    options
)

/**
 * The version name of the package application, as specified by the <manifest>
 * tag's [android.R.styleable#AndroidManifest_versionName]
 * attribute.
 *
 * @return versionName if defined or null if not.
 */
fun Context.getVersionName(): String? {
    return try {
        val packageInfo = packageManager.getPackageInfo(packageName, 0)
        packageInfo.versionName
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        null
    }
}

/**
 * Return versionCode and versionCodeMajor combined together as a
 * single long value. versionCodeMajor is placed in the upper 32 bits.
 *
 * @return versionCode if defined or null if not.
 */
@RequiresApi(Build.VERSION_CODES.P)
fun Context.getVersionCode(): Long? {
    return try {
        val packageInfo = packageManager.getPackageInfo(packageName, 0)
        packageInfo.longVersionCode
    } catch (e: PackageManager.NameNotFoundException) {
        e.printStackTrace()
        null
    }
}

/**
 * Returns a color associated with a particular attribute ID and styled for
 * the current theme.
 *
 * @return A single color value in the form 0xAARRGGBB or null if [attrColor] not found.
 */
@ColorInt
fun Context.getColorFromAttr(
    @AttrRes attrColor: Int
): Int? {
    val typedValue = TypedValue()
    return if (theme.resolveAttribute(attrColor, typedValue, true)) {
        typedValue.data
    } else null
}

/**
 * Converts Px to Dp.
 *
 * @return [px] converted to Dp as [Float].
 */
fun Context.pxToDp(px: Float): Float? =
    resources?.displayMetrics?.density?.let { density ->
        px / density
    }
