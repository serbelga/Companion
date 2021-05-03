# Companion

A collection of Android extensions and utilities.

```gradle
implementation "dev.sergiobelda.android.companion:companion:0.1.0"
```

## Dialogs

```kotlin
createMaterialDialog(context = requireContext()) {
    title(R.string...)
    singleChoiceItems(items, checkedItem) {
        checkedItem = it
    }
    positiveButton(getString(R.string.accept)) {
        // Do something
    }
    negativeButton(getString(R.string.cancel))
}.show()
```

### Centered

```kotlin
createMaterialDialog(
    requireContext(),
    R.style.ThemeOverlay_MaterialComponents_MaterialAlertDialog_Centered
) {
    title(R.string...)
    icon(R.drawable...)
    message(R.string...)
    positiveButton(getString(R.string.accept)) {
        // Do something
    }
    negativeButton(getString(R.string.cancel))
}.show()
```

## Extensions

## Util

## License

```
Copyright 2021 Sergio Belda

Licensed under the Apache License, Version 2.0 (the "License");
you may not use this file except in compliance with the License.
You may obtain a copy of the License at

    http://www.apache.org/licenses/LICENSE-2.0

Unless required by applicable law or agreed to in writing, software
distributed under the License is distributed on an "AS IS" BASIS,
WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
See the License for the specific language governing permissions and
limitations under the License.
```
