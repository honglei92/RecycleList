package com.example.a83661.recyclelist

import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import com.example.a83661.recyclelist.entity.DownloadEntity

class MainActivity : AppCompatActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {
        var list: ArrayList<DownloadEntity> = ArrayList()
        for (i in 0 until 10) {
            var entity = DownloadEntity("https://dldir1.qq.com/qqfile/qq/TIM2.2.5/20881/TIM2.2.5.exe")
            list.add(entity)
        }
    }
}
