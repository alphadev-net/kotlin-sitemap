package net.alphadev.sitemap.format

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlValue

@Serializable
data class Price(
    val currency: String,

    @XmlValue
    val amount: String,
)
