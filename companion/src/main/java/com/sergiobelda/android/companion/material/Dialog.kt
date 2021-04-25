package com.sergiobelda.android.companion.material

import android.content.Context
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AlertDialog
import com.google.android.material.R
import com.google.android.material.dialog.MaterialAlertDialogBuilder

/**
 * Creates a custom [AlertDialog] using Material style by setting
 * [context] and [AlertDialog.Builder] methods.
 * Optionally, we can set the dialog [style].
 *
 * ```
 *  createMaterialDialog(this) {
 *      // AlertDialog.Builder methods.
 *  }.show()
 *
 *  createMaterialDialog(this, R.style.MaterialAlertDialog_MaterialComponents_Title_Icon_CenterStacked) {
 *      // AlertDialog.Builder methods.
 *  }.show()
 * ```
 */
inline fun createMaterialDialog(
    context: Context,
    @StyleRes style: Int = R.style.MaterialAlertDialog_MaterialComponents,
    dialogBuilder: AlertDialog.Builder.() -> Unit = {}
): AlertDialog =
    MaterialAlertDialogBuilder(context, style).apply {
        dialogBuilder()
    }.create()

fun AlertDialog.Builder.title(title: String) {
    this.setTitle(title)
}

fun AlertDialog.Builder.title(@StringRes resId: Int) {
    this.setTitle(resId)
}

fun AlertDialog.Builder.icon(@DrawableRes drawableResId: Int) {
    this.setIcon(drawableResId)
}

fun AlertDialog.Builder.message(message: String) {
    this.setMessage(message)
}

fun AlertDialog.Builder.message(@StringRes resId: Int) {
    this.setMessage(context.getString(resId))
}

fun AlertDialog.Builder.singleChoiceItems(items: Array<CharSequence>, checkedItem: Int, onClick: (which: Int) -> Unit = {}) {
    this.setSingleChoiceItems(items, checkedItem) { _, which -> onClick(which) }
}

fun AlertDialog.Builder.positiveButton(text: String, onClick: (which: Int) -> Unit = {}) {
    this.setPositiveButton(text) { _, which -> onClick(which) }
}

fun AlertDialog.Builder.positiveButton(@StringRes resId: Int, onClick: (which: Int) -> Unit = {}) {
    this.setPositiveButton(resId) { _, which -> onClick(which) }
}

fun AlertDialog.Builder.neutralButton(text: String, onClick: (which: Int) -> Unit = {}) {
    this.setNeutralButton(text) { _, which -> onClick(which) }
}

fun AlertDialog.Builder.neutralButton(@StringRes resId: Int, onClick: (which: Int) -> Unit = {}) {
    this.setNeutralButton(resId) { _, which -> onClick(which) }
}

fun AlertDialog.Builder.negativeButton(text: String, onClick: (which: Int) -> Unit = {}) {
    this.setNegativeButton(text) { _, which -> onClick(which) }
}

fun AlertDialog.Builder.negativeButton(@StringRes resId: Int, onClick: (which: Int) -> Unit = {}) {
    this.setNegativeButton(resId) { _, which -> onClick(which) }
}
