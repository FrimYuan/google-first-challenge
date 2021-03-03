package com.example.androiddevchallenge.ui.activity

import android.content.Intent
import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.*
import androidx.compose.material.*
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
                                    if (!isAdopt){
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