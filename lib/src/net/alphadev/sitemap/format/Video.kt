package net.alphadev.sitemap.format

import kotlinx.datetime.Instant
import kotlinx.serialization.Serializable
import nl.adaptivity.xmlutil.serialization.XmlElement
import nl.adaptivity.xmlutil.serialization.XmlSerialName
import kotlin.time.Duration

@Serializable
@XmlSerialName("video", namespace = "http://www.google.com/schemas/sitemap-video/1.1", prefix = "video")
data class Video(
    @XmlElement
    @XmlSerialName("thumbnail_loc")
    val thumbnaillocation: String,

    @XmlElement
    val title: String,

    @XmlElement
    val description: String,

    @XmlElement
    @XmlSerialName("content_loc")
    val contentLocation: String,

    @XmlElement
    @XmlSerialName("player_loc")
    val playerLocation: String,

    @XmlElement
    @Serializable(with = SecondDurationSerializer::class)
    val duration: Duration? = null,

    @XmlElement
    @XmlSerialName("expiration_date")
    val expirationDate: Instant? = null,

    @XmlElement
    val rating: Float? = null,

    @XmlElement
    @XmlSerialName("view_count")
    val viewCount: Long? = null,

    @XmlElement
    @XmlSerialName("publication_date")
    val publicationDate: Instant? = null,

    @XmlElement
    @XmlSerialName("family_friendly")
    val isFamilyFriendly: Boolean? = null,

    @XmlSerialName("restriction")
    val restriction: Restriction? = null,

    @XmlSerialName("price")
    val price: Price? = null,

    @XmlElement
    @XmlSerialName("requires_subscription")
    val requiresSubscription: Boolean? = null,

    @XmlSerialName("uploader")
    val uploader: Uploader? = null,

    @XmlElement
    @XmlSerialName("live")
    val isLive: Boolean? = null,
)
