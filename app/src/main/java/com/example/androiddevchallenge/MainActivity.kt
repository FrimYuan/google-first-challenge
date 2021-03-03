/*
 * Copyright 2021 The Android Open Source Project
 *
 * Licensed under the Apache License, Version 2.0 (the "License");
 * you may not use this file except in compliance with the License.
 * You may obtain a copy of the License at
 *
 *     https://www.apache.org/licenses/LICENSE-2.0
 *
 * Unless required by applicable law or agreed to in writing, software
 * distributed under the License is distributed on an "AS IS" BASIS,
 * WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
 * See the License for the specific language governing permissions and
 * limitations under the License.
 */
package com.example.androiddevchallenge

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.background
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.lifecycle.viewmodel.compose.viewModel
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.ui.activity.DogDetailActivity
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.view.DogList

class MainActivity : AppCompatActivity() {
    private val viewModel: DogViewModel by viewModels()
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            MyTheme {
                MyApp(
                    jumpDetail = { pos, dog ->
                        Intent(this, DogDetailActivity::class.java).apply {
                            putExtra("pos", pos)
                            putExtra("data", dog)
                            startActivityForResult(this, 111)
                        }
                    }
                )
            }
        }
    }

    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)
        when (resultCode) {
            111 -> {
                val pos: Int? = data?.getIntExtra("pos", -1)
                val isAdopt: Boolean? = data?.getBooleanExtra("isAdopt", false)
                pos?.let {
                    if (pos != -1) {
                        isAdopt?.let {
                            viewModel.getData()[pos].isAdopt = isAdopt
                        }
                    }
                }
            }
        }
    }
}

// Start building your app here!
@Composable
fun MyApp(viewModel: DogViewModel = viewModel(), jumpDetail: (position: Int, dog: Dog) -> Unit) {
    Surface(Modifier.background(color = Color.Green)) {
        DogList(
            data = viewModel.getData(), jumpDetail
        )
    }
}
