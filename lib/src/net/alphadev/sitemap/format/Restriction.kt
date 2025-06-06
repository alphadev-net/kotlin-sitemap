package net.alphadev.sitemap.format

import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlValue

@Serializable
data class Restriction(
    val relationship: String,

    @XmlValue
    val locations: String,
)
