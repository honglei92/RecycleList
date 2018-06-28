package com.example.a83661.recyclelist.entity

/**
 * 下载类实体
 */
class DownloadEntity {
    var progress: Int = 0
    lateinit var url: String

    constructor(url: String) {
        this.url = url
    }
}