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

import androidx.lifecycle.ViewModel
import com.example.androiddevchallenge.data.Dog

class DogViewModel : ViewModel() {
    private val dataList = run {
        listOf(
            Dog(
                "滚滚",
                "小狗",
                "母",
                "上海",
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103021648434984.jpg",
            ),
            Dog(
                "汤圆",
                "小狗",
                "公",
                "南昌",
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103021642417259.jpg",
            ),

            Dog(
                "十六",
                "小狗",
                "母",
                "北京",
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103021651525447.jpg",
            ),

            Dog(
                "史努比",
                "小狗",
                "公",
                "上海",
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103020022398727.jpg",
            ),

            Dog(
                "多肉",
                "小狗",
                "母",
                "南昌",
                "https://img.chonganjia.cn/diary/adopt/202012/31/202012311700271509.jpg",
            ),

            Dog(
                "小黑",
                "小狗",
                "母",
                "上海",
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103021601025383.jpg",
            ),

            Dog(
                "小一",
                "小狗",
                "母",
                "北京",
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103021528324951.jpg",
            ),

            Dog(
                "旺财",
                "小狗",
                "公",
                "上海",
                "https://img.chonganjia.cn/diary/adopt/202102/26/202102262106112199.jpg",
            ),

            Dog(
                "星星",
                "小狗",
                "公",
                "北京",
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103021212019049.jpg",
            ),
        )
    }

    fun getData(): List<Dog> {
        return dataList
    }
}
