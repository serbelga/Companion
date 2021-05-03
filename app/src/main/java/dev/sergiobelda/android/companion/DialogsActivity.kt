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

package dev.sergiobelda.android.companion

import android.os.Bundle
import android.widget.Toast
import androidx.appcompat.app.AppCompatActivity
import dev.sergiobelda.android.companion.databinding.ActivityDialogsBinding
import dev.sergiobelda.android.companion.material.*

class DialogsActivity : AppCompatActivity() {
    private lateinit var binding: ActivityDialogsBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDialogsBinding.inflate(layoutInflater)
        setContentView(binding.root)

        binding.simpleDialog.setOnClickListener {
            simpleDialog()
        }
        binding.singleChoiceItemsDialog.setOnClickListener {
            singleChoiceItemsDialog()
        }
        binding.multipleChoiceItemsDialog.setOnClickListener {
            multipleChoiceItemsDialog()
        }
        binding.centeredDialog.setOnClickListener {
            centeredDialog()
        }
    }

    private fun simpleDialog() =
        createMaterialDialog(this) {
            title(R.string.simple_dialog)
            message(R.string.lorem_ipsum_short)
            positiveButton(R.string.ok) {
                Toast.makeText(
                        this@DialogsActivity,
                        "Positive button click",
                        Toast.LENGTH_SHORT
                ).show()
            }
            negativeButton("Cancel")
        }.show()

    private fun singleChoiceItemsDialog() =
        createMaterialDialog(
                this
        ) {
            title(R.string.single_choice_items)
            singleChoiceItems(R.array.items, checkedItem = 0) {
                Toast.makeText(this@DialogsActivity, "Selected: $it", Toast.LENGTH_SHORT).show()
            }
            positiveButton(R.string.ok)
            negativeButton(R.string.cancel)
        }.show()

    private fun multipleChoiceItemsDialog() {
        val map = mapOf<CharSequence, Boolean>(
            "Item 0" to true,
            "Item 1" to false,
            "Item 2" to true
        )
        createMaterialDialog(this) {
            isCancelable = false
            title(R.string.multiple_choice_items_dialog)
            multipleChoiceItems(map.keys.toTypedArray(), map.values.toBooleanArray()) { item, isChecked ->
                Toast.makeText(this@DialogsActivity, "Item $item: $isChecked", Toast.LENGTH_SHORT).show()
            }
            positiveButton(R.string.ok)
        }.show()
    }

    private fun centeredDialog() {
        createMaterialDialog(
            this,
            R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog_Centered
        ) {
            icon(R.drawable.ic_baseline_file_24)
            title(R.string.centered_dialog)
            message(R.string.lorem_ipsum_long)
            positiveButton(R.string.ok)
            neutralButton(R.string.other)
        }.show()
    }
}
