package net.alphadev.sitemap.format

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlSerialName
import kotlin.time.ExperimentalTime

@Serializable
@XmlSerialName("urlset", namespace = "http://www.sitemaps.org/schemas/sitemap/0.9", prefix = "")
@ExperimentalTime
public data class UrlSet(
    val urls: List<Url>
)