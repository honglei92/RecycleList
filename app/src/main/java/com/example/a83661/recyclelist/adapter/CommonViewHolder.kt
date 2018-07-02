package com.example.a83661.recyclelist.adapter

import android.view.View
import com.example.a83661.recyclelist.adapter.DownloadAdapter.ViewHolder

/**
 * viewHolder转化为convert view
 */
class CommonViewHolder {
    companion object {
        fun <T : View> get(view: View, id: Int): View? {
            var viewHolder: ViewHolder = view.tag as ViewHolder
            //if rootView didn't use for cache collection
            if (viewHolder == null) {
                viewHolder = DownloadAdapter.ViewHolder()
                view.setTag(viewHolder)
            }
            var childView: View = viewHolder.get(id)
            if (childView == null) {
                childView = view.findViewById(id)
            }
            return childView
        }
    }
}
