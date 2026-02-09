package net.alphadev.sitemap.format

import kotlinx.serialization.KSerializer
import kotlinx.serialization.Serializable
import kotlinx.serialization.descriptors.PrimitiveKind
import kotlinx.serialization.descriptors.PrimitiveSerialDescriptor
import kotlinx.serialization.descriptors.SerialDescriptor
import kotlinx.serialization.encoding.Decoder
import kotlinx.serialization.encoding.Encoder
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName
import kotlin.time.ExperimentalTime

@Serializable
@XmlSerialName("url", namespace = "http://www.sitemaps.org/schemas/sitemap/0.9", prefix = "")
@ExperimentalTime
public data class Url(

    @XmlElement
    @XmlSerialName("loc")
    val location: String,

    @XmlElement
    @XmlSerialName("lastmod")
    val lastModified: String? = null,

    @XmlElement
    val images: List<Image> = emptyList(),

    val news: News? = null,

    val videos: List<Video> = emptyList(),

    @XmlElement
    @XmlSerialName("changefreq")
    val changeFreq: String? = null,

    @XmlElement
    @Serializable(with = PrioritySerializer::class)
    val priority: Float? = null
)

public object PrioritySerializer: KSerializer<Float?> {
    override val descriptor: SerialDescriptor = PrimitiveSerialDescriptor("Priority", PrimitiveKind.FLOAT)

    override fun deserialize(decoder: Decoder): Float? {
        val candidate = decoder.decodeString()
        return when {
            candidate.isEmpty() -> null
            else -> try {
                candidate.toFloat()
            } catch (_: NumberFormatException) {
                null
            }
        }
    }

    override fun serialize(encoder: Encoder, value: Float?) {
        if (value != null) {
            encoder.encodeFloat(value)
        }
    }
}