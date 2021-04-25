package com.sergiobelda.android.companion

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import com.sergiobelda.android.companion.material.*

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        createMaterialDialog(this) {
            title(" ")
            message("Dialog message")
            positiveButton("Ok", onClick = {

            })
            negativeButton("Cancel")
        }.show()
    }
}
