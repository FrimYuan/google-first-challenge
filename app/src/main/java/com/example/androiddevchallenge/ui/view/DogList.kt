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
package com.example.androiddevchallenge.ui.view

import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.itemsIndexed
import androidx.compose.material.Card
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.unit.dp
import com.example.androiddevchallenge.data.Dog
import com.example.androiddevchallenge.ui.theme.itemBg
import dev.chrisbanes.accompanist.coil.CoilImage

@Composable
fun DogList(data: List<Dog>, jumpDetail: (position: Int, dog: Dog) -> Unit) {
    LazyColumn {
        itemsIndexed(data) { pos, dog ->
            DogItem(pos, dog, jumpDetail)
        }
    }
}

@Composable
fun DogItem(pos: Int, dog: Dog, click: (position: Int, dog: Dog) -> Unit) {
    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(10.dp)
            .clickable {
                click(pos, dog)
            },
    ) {
        Box(contentAlignment = Alignment.BottomCenter) {
            CoilImage(
                data = dog.netPhoto,
                contentDescription = "this is ${dog.name}",
                contentScale = ContentScale.Crop,
                modifier = Modifier.height(200.dp)
            )
            Row(
                Modifier
                    .background(itemBg)
                    .height(30.dp),
                verticalAlignment = Alignment.CenterVertically,
            ) {
                Text(
                    "名字：${dog.name}",
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )
                Text(
                    "种类：${dog.species}",
                    color = Color.White,
                    modifier = Modifier.weight(1f)
                )
            }
        }
    }
}
