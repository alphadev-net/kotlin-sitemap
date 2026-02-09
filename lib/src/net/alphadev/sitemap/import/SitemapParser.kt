package net.alphadev.sitemap.import

import kotlinx.serialization.decodeFromString
import net.alphadev.sitemap.format.SitemapIndex
import net.alphadev.sitemap.format.UrlSet
import nl.adaptivity.xmlutil.serialization.XML
import kotlin.time.ExperimentalTime

public fun parseSitemapIndex(input: String): SitemapIndex? = try {
    XML().decodeFromString<SitemapIndex>(input)
} catch (e: Throwable) {
    null
}

@ExperimentalTime
public fun parseUrlSet(input: String): UrlSet? = try {
    XML().decodeFromString<UrlSet>(input)
} catch (e: Throwable) {
    null
}