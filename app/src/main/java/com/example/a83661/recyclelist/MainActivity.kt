package com.example.a83661.recyclelist

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.widget.ProgressBar
import android.widget.Toast
import com.example.a83661.recyclelist.adapter.CommonViewHolder
import com.example.a83661.recyclelist.adapter.DownloadAdapter
import com.example.a83661.recyclelist.entity.DownloadEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val context: Context = this@MainActivity
    var list: ArrayList<DownloadEntity> = ArrayList()
    lateinit var downloadAdapter: DownloadAdapter
    //线程池

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        initView()
    }

    private fun initView() {

        for (i in 0 until 10) {
            var entity = DownloadEntity("https://dldir1.qq.com/qqfile/qq/TIM2.2.5/20881/TIM2.2.5.exe")
            list.add(entity)
        }
        downloadAdapter = DownloadAdapter(context,list)
        resourceList.adapter = downloadAdapter
        resourceList.setOnItemClickListener { p0, p1, position, p3 ->
            Toast.makeText(context, position.toString(), Toast.LENGTH_SHORT).show()
            var entity = list.get(position)
            entity.progress = 50
            updateSingle(position)

        }
    }


    /**
     * 局部刷新
     */
    private fun updateSingle(position: Int) {
        //当前可见页首index
        val firstVisiablePosition = resourceList.firstVisiblePosition
        //当前可见页尾index
        val lastVisiablePosition = resourceList.lastVisiblePosition
        if (position in firstVisiablePosition..lastVisiablePosition) {
            /**
             * 方法一  getChildAt
             */
//            val view = resourceList.getChildAt(position - firstVisiablePosition)
//            val mProgressBar = view.findViewById<ProgressBar>(R.id.progressBar)
//            mProgressBar.progress = list.get(position).progress
            /**
             * 方法二、viewHolder
             */
            val view = resourceList.getChildAt(position - firstVisiablePosition)
            val mProgressBar: ProgressBar = CommonViewHolder.get<ProgressBar>(view, R.id.progressBar) as ProgressBar
            mProgressBar.progress = list.get(position).progress
            /**
             * 方法三、adapter.getView
             */
//            val view = resourceList.getChildAt(position - firstVisiablePosition)
//            downloadAdapter.getView(position, view, resourceList)

        }
    }


}
