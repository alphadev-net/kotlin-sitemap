package net.alphadev.sitemap.demo

import net.alphadev.sitemap.format.UrlSet
import net.alphadev.sitemap.import.parseUrlSet
import io.ktor.client.HttpClient
import io.ktor.client.request.get
import io.ktor.client.statement.bodyAsText

suspend fun main() {
    val sitemapData = loadSitemapContents()
    val sitemap = parseUrlSet(sitemapData ?: return)
    printSitemapOverview(sitemap ?: return)
}

private suspend fun loadSitemapContents(): String {
    val client = HttpClient()
        return client.get("https://jan.alphadev.net/sitemap.xml")
            .bodyAsText()
}

private fun printSitemapOverview(sitemap: UrlSet) {
    sitemap.urls.associate { it.lastModified to it.location }
        .toSortedMap(nullsLast())
        .forEach { (lastModified, location) ->
            println("$location: $lastModified")
        }
}
