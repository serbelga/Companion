package com.sergiobelda.android.companion.content

import android.content.Context
import android.content.pm.PackageManager
import android.os.Build
import android.util.TypedValue
import androidx.annotation.AttrRes
import androidx.annotation.ColorInt
import androidx.annotation.RequiresApi

/**
 * The version name of the package application, as specified by the <manifest>
 * tag's {@link android.R.styleable#AndroidManifest_versionName versionName}
 * attribute.
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
 * Return {@link android.R.styleable#AndroidManifest_versionCode versionCode} and
 * {@link android.R.styleable#AndroidManifest_versionCodeMajor versionCodeMajor} combined
 * together as a single long value.
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

fun Context.pxToDp(px: Float): Int {
    return (px / resources.displayMetrics.density).toInt()
}
