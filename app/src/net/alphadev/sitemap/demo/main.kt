package net.alphadev.sitemap.demo

import net.alphadev.sitemap.format.UrlSet
import net.alphadev.sitemap.import.parseUrlSet
import okhttp3.OkHttpClient
import okhttp3.Request

fun main() {
    val sitemapData = loadSitemapContents()
    val sitemap = parseUrlSet(sitemapData ?: return)
    printSitemapOverview(sitemap ?: return)
}

private fun loadSitemapContents(): String? {
    val client = OkHttpClient()

    val request = Request.Builder()
        .url("https://jan.alphadev.net/sitemap.xml")
        .build()

    val response = client.newCall(request).execute()

    return response.body?.string()
}

private fun printSitemapOverview(sitemap: UrlSet) {
    sitemap.urls.associate { it.lastModified to it.location }
        .toSortedMap(nullsLast())
        .forEach { (lastModified, location) ->
            println("$location: $lastModified")
        }
}
