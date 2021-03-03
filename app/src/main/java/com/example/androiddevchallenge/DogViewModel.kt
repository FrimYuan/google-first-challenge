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
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103021648434984.jpg"
            ),
            Dog(
                "汤圆",
                "小狗",
                "公",
                "南昌",
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103021642417259.jpg"
            ),

            Dog(
                "十六",
                "小狗",
                "母",
                "北京",
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103021651525447.jpg"
            ),

            Dog(
                "史努比",
                "小狗",
                "公",
                "上海",
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103020022398727.jpg"
            ),


            Dog(
                "多肉",
                "小狗",
                "母",
                "南昌",
                "https://img.chonganjia.cn/diary/adopt/202012/31/202012311700271509.jpg"
            ),


            Dog(
                "小黑",
                "小狗",
                "母",
                "上海",
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103021601025383.jpg"
            ),


            Dog(
                "小一",
                "小狗",
                "母",
                "北京",
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103021528324951.jpg"
            ),

            Dog(
                "旺财",
                "小狗",
                "公",
                "上海",
                "https://img.chonganjia.cn/diary/adopt/202102/26/202102262106112199.jpg"
            ),

            Dog(
                "星星",
                "小狗",
                "公",
                "北京",
                "https://img.chonganjia.cn/diary/adopt/202103/02/202103021212019049.jpg"
            ),
        )
    }

    fun getData(): List<Dog> {
        return dataList
    }
}