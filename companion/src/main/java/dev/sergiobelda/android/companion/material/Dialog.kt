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

package dev.sergiobelda.android.companion.material

import android.content.Context
import android.graphics.drawable.Drawable
import android.view.View
import android.widget.ListAdapter
import androidx.annotation.ArrayRes
import androidx.annotation.DrawableRes
import androidx.annotation.StringRes
import androidx.annotation.StyleRes
import androidx.appcompat.app.AlertDialog
import androidx.core.content.ContextCompat
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

// region Title
fun AlertDialog.Builder.title(title: String) {
    this.setTitle(title)
}

fun AlertDialog.Builder.title(@StringRes resId: Int) {
    this.setTitle(resId)
}
// endregion

// region Icon
fun AlertDialog.Builder.icon(@DrawableRes drawableResId: Int) {
    this.setIcon(drawableResId)
}

fun AlertDialog.Builder.icon(drawable: Drawable) {
    this.setIcon(drawable)
}
// endregion

// region Message
fun AlertDialog.Builder.message(message: String) {
    this.setMessage(message)
}

fun AlertDialog.Builder.message(@StringRes resId: Int) {
    this.setMessage(context.getString(resId))
}
// endregion

// region Single Choice Items
fun AlertDialog.Builder.singleChoiceItems(
    items: Array<CharSequence>,
    checkedItem: Int, onClick: (which: Int) -> Unit = {}
) {
    this.setSingleChoiceItems(items, checkedItem) { _, which -> onClick(which) }
}

fun AlertDialog.Builder.singleChoiceItems(
    @ArrayRes arrayResId: Int,
    checkedItem: Int,
    onClick: (item: Int) -> Unit = {}
) {
    this.setSingleChoiceItems(arrayResId, checkedItem) { _, item -> onClick(item) }
}

fun AlertDialog.Builder.singleChoiceItems(
    adapter: ListAdapter,
    checkedItem: Int,
    onClick: (item: Int) -> Unit = {}
) {
    this.setSingleChoiceItems(adapter, checkedItem) { _, item -> onClick(item) }
}
// endregion

// region Multiple Choice Items
fun AlertDialog.Builder.multipleChoiceItems(
    items: Array<CharSequence>,
    checkedItem: BooleanArray,
    onClick: (item: Int, isChecked: Boolean) -> Unit = { _, _ -> }
) {
    this.setMultiChoiceItems(items, checkedItem) { _, item, isChecked -> onClick(item, isChecked) }
}

fun AlertDialog.Builder.multipleChoiceItems(
    @ArrayRes arrayResId: Int,
    checkedItem: BooleanArray,
    onClick: (item: Int, isChecked: Boolean) -> Unit = { _, _ -> }
) {
    this.setMultiChoiceItems(arrayResId, checkedItem) { _, item, isChecked -> onClick(item, isChecked) }
}
// endregion

// region Positive Button
fun AlertDialog.Builder.positiveButton(text: String, onClick: (which: Int) -> Unit = {}) {
    this.setPositiveButton(text) { _, which -> onClick(which) }
}

fun AlertDialog.Builder.positiveButton(@StringRes resId: Int, onClick: (which: Int) -> Unit = {}) {
    this.setPositiveButton(resId) { _, which -> onClick(which) }
}

fun AlertDialog.Builder.positiveButtonIcon(drawable: Drawable) {
    this.setPositiveButtonIcon(drawable)
}

fun AlertDialog.Builder.positiveButtonIcon(@DrawableRes drawableResId: Int) {
    this.setPositiveButtonIcon(ContextCompat.getDrawable(this.context, drawableResId))
}
// endregion

// region Neutral Button
fun AlertDialog.Builder.neutralButton(text: String, onClick: (which: Int) -> Unit = {}) {
    this.setNeutralButton(text) { _, which -> onClick(which) }
}

fun AlertDialog.Builder.neutralButton(@StringRes resId: Int, onClick: (which: Int) -> Unit = {}) {
    this.setNeutralButton(resId) { _, which -> onClick(which) }
}

fun AlertDialog.Builder.neutralButtonIcon(drawable: Drawable) {
    this.setNeutralButtonIcon(drawable)
}

fun AlertDialog.Builder.neutralButtonIcon(@DrawableRes drawableResId: Int) {
    this.setNeutralButtonIcon(ContextCompat.getDrawable(this.context, drawableResId))
}
// endregion

// region Negative Button
fun AlertDialog.Builder.negativeButton(text: String, onClick: (which: Int) -> Unit = {}) {
    this.setNegativeButton(text) { _, which -> onClick(which) }
}

fun AlertDialog.Builder.negativeButton(@StringRes resId: Int, onClick: (which: Int) -> Unit = {}) {
    this.setNegativeButton(resId) { _, which -> onClick(which) }
}

fun AlertDialog.Builder.negativeButtonIcon(drawable: Drawable) {
    this.setNegativeButtonIcon(drawable)
}

fun AlertDialog.Builder.negativeButtonIcon(@DrawableRes drawableResId: Int) {
    this.setNegativeButtonIcon(ContextCompat.getDrawable(this.context, drawableResId))
}
// endregion

// region View
fun AlertDialog.Builder.view(view: View) {
    this.setView(view)
}

fun AlertDialog.Builder.view(layoutResId: Int) {
    this.setView(layoutResId)
}
// endregion

var AlertDialog.Builder.isCancelable: Boolean
    get() = true
    set(value) {
        this.setCancelable(value)
    }
