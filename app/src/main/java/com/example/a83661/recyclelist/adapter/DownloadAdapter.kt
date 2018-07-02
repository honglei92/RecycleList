package com.example.a83661.recyclelist.adapter

import android.content.Context
import android.util.Log
import android.view.View
import android.view.ViewGroup
import android.widget.BaseAdapter
import android.widget.ProgressBar
import android.widget.TextView
import com.example.a83661.recyclelist.R
import com.example.a83661.recyclelist.entity.DownloadEntity

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
        fun get(id: Int): View {
            if (id== R.id.progressBar){
                return progressView
            }
            return null!!
        }

        lateinit var urltv: TextView
        lateinit var progressView: ProgressBar
    }

}