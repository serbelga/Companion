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

package com.sergiobelda.android.companion.material

import com.google.android.material.textfield.TextInputLayout

/**
 * Clear the error state. In addition, set isErrorEnabled to false in order
 * to avoid leaving the space reserved for error text empty.
 */
fun TextInputLayout.clearError() {
    error = null
    isErrorEnabled = false
}
