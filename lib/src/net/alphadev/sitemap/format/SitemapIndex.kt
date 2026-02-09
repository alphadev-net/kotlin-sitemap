package net.alphadev.sitemap.format

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("sitemapindex", namespace = "http://www.sitemaps.org/schemas/sitemap/0.9", prefix = "")
public data class SitemapIndex(
    val sitemaps: List<Sitemap>
)
