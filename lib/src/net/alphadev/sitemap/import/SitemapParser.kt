package net.alphadev.sitemap.import

import kotlinx.serialization.decodeFromString
import net.alphadev.sitemap.format.SitemapIndex
import nl.adaptivity.xmlutil.serialization.XML

fun parseSitemap(input: String): SitemapIndex? = try {
    XML().decodeFromString<SitemapIndex>(input)
} catch (e: Throwable) {
    null
}
