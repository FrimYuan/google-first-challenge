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
package com.example.androiddevchallenge.ui.activity

import android.content.Intent
import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.material.Icon
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.material.Button
import androidx.compose.material.ButtonDefaults
import androidx.compose.material.Scaffold
import androidx.compose.material.TopAppBar
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.R
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.ui.theme.MyTheme
import com.example.androiddevchallenge.ui.theme.itemBg
import dev.chrisbanes.accompanist.coil.CoilImage

class DogDetailActivity : AppCompatActivity() {
    private var pos: Int? = null
    private var dog: Dog? = null
    private var isAdopt: Boolean by mutableStateOf(false)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        getData()
        setContent {
            Scaffold(topBar = {
                TopAppBar(
                    navigationIcon = {
                        Button(
                            onClick = { exit() },
                            colors = ButtonDefaults.buttonColors(
                                disabledBackgroundColor = Color.Transparent,
                                disabledContentColor = Color.Transparent
                            )
                        ) {
                            Icon(
                                painter = painterResource(id = R.drawable.back),
                                contentDescription = "返回",
                                modifier = Modifier.size(30.dp),
                            )
                        }
                    },
                    title = {
                        Text(
                            text = dog?.name ?: "",
                        )
                    },
                )
            }) {
                MyTheme {
                    dog?.let {
                        Column(horizontalAlignment = Alignment.CenterHorizontally) {
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(10.dp)
                            ) {
                                CoilImage(
                                    data = it.netPhoto,
                                    contentDescription = "this is ${it.name}",
                                    contentScale = ContentScale.Crop,
                                    modifier = Modifier.height(300.dp)
                                )
                            }
                            Card(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(start = 10.dp, end = 10.dp),
                                backgroundColor = itemBg
                            ) {
                                Row(modifier = Modifier.padding(10.dp)) {
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = "年龄:${it.age}",
                                        )
                                        Text(
                                            text = "性别:${it.gender}",
                                        )
                                    }
                                    Column(modifier = Modifier.weight(1f)) {
                                        Text(
                                            text = "品种:${it.species}",
                                        )
                                        Text(
                                            text = "位置:${it.location}",
                                        )
                                    }
                                }
                            }
                            Button(
                                onClick = {
                                    if (!isAdopt) {
                                        isAdopt = true

                                    }
                                },
                                enabled = !isAdopt,
                                modifier = Modifier.padding(top = 10.dp)
                            ) {
                                Text(
                                    text = if (isAdopt) "已领养" else "领养",
                                )
                            }
                        }
                    }
                }
            }
        }
    }

    private fun exit() {
        val intent = Intent()
        intent.putExtra("pos", pos)
        intent.putExtra("isAdopt", isAdopt)
        setResult(111, intent)
        finish()
    }

    private fun getData() {
        intent?.let {
            pos = it.getIntExtra("pos", -1)
            dog = it.getParcelableExtra("data")
            isAdopt = dog?.isAdopt ?: false
        }
    }
}