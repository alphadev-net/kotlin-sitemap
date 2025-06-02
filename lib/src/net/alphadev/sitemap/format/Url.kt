package net.alphadev.sitemap.format

import kotlinx.serialization.SerialName
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName

@Serializable
@XmlSerialName("url", namespace = "http://www.sitemaps.org/schemas/sitemap/0.9", prefix = "")
data class Url(

    @XmlElement
    @XmlSerialName("loc")
    val location: String,

    @XmlElement
    @XmlSerialName("lastmod")
    val lastModified: String,
)