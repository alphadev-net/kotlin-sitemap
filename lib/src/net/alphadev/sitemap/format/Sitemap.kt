package net.alphadev.sitemap.format

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("sitemap", namespace = "http://www.sitemaps.org/schemas/sitemap/0.9", prefix = "")
public data class Sitemap(

    @XmlElement
    @XmlSerialName("loc")
    val location: String,

    @XmlElement
    @XmlSerialName("lastmod")
    val lastModified: String,
)
