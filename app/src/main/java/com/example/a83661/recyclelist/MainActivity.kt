package com.example.a83661.recyclelist

import android.content.Context
import android.os.Bundle
import android.support.v7.app.AppCompatActivity
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ProgressBar
import android.widget.TextView
import android.widget.Toast
import com.example.a83661.recyclelist.entity.DownloadEntity
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity() {
    val context: Context = this@MainActivity
    var list: ArrayList<DownloadEntity> = ArrayList()
    lateinit var downloadAdapter: DownloadAdapter

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
        downloadAdapter = DownloadAdapter(context, list)
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
//            val view=DownloadAdapter.ViewHolder.get
            /**
             * 方法三、adapter.getView
             */
            val view = resourceList.getChildAt(position - firstVisiablePosition)
            downloadAdapter.getView(position, view, resourceList)

        }
    }

    class DownloadAdapter(val context: Context, var list: ArrayList<DownloadEntity>) : BaseAdapter() {
        override fun getView(p0: Int, p1: View?, p2: ViewGroup?): View {
            Log.d("honglei92", "execute：" + p0)
            var viewHolder: ViewHolder
            var view: View
            if (p1 == null) {
                viewHolder = ViewHolder()
                view = View.inflate(context, R.layout.item_download, null)
                viewHolder.urltv = view.findViewById(R.id.urlTv)
                viewHolder.progressView = view.findViewById(R.id.progressBar)
                view.tag = viewHolder
            } else {
                view = p1
                viewHolder = p1.tag as ViewHolder
            }
            viewHolder.urltv.text = list.get(p0).url
            viewHolder.progressView.progress = list.get(p0).progress
            return view
        }

        override fun getItem(p0: Int): Any {
            return list.get(p0)
        }

        override fun getItemId(p0: Int): Long {
            return p0.toLong()
        }

        override fun getCount(): Int {
            return list.size
        }

        class ViewHolder {
            lateinit var urltv: TextView
            lateinit var progressView: ProgressBar
        }

    }
}
