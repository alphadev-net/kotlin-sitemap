package net.alphadev.sitemap.import

import de.sipgate.dachlatten.io.readResource
import kotlinx.datetime.LocalDate
import kotlinx.io.readString
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull
import kotlin.time.Instant
import kotlin.time.Duration.Companion.seconds

class GoogleSampleTest {

    /**
     * Original can be found here:
     * https://developers.google.com/search/docs/crawling-indexing/sitemaps/image-sitemaps#example-image-sitemap
     */
    @Test
    fun testGoogleImageSitemapParsesCorrectly() {
        readResource("google.image.sample.sitemap.xml") {
            val parsed = parseUrlSet(it.readString())

            assertNotNull(parsed)
            assertEquals(2, parsed.urls.size)

            val firstEntry = parsed.urls[0]
            assertEquals(2, firstEntry.images.size)
            assertEquals("https://example.com/image.jpg", firstEntry.images[0].location)
            assertEquals("https://example.com/photo.jpg", firstEntry.images[1].location)

            val secondEntry = parsed.urls[1]
            assertEquals("https://example.com/sample2.html", secondEntry.location)
            assertEquals("https://example.com/picture.jpg", secondEntry.images[0].location)
        }
    }

    /**
     * Original can be found here:
     * https://developers.google.com/search/docs/crawling-indexing/sitemaps/news-sitemap#example-news-sitemap
     */
    @Test
    fun testGoogleNewsSitemapParsesCorrectly() {
        readResource("google.news.sample.sitemap.xml") {
            val parsed = parseUrlSet(it.readString())

            assertNotNull(parsed)
            assertEquals(1, parsed.urls.size)

            val entry = parsed.urls[0]
            assertEquals("http://www.example.org/business/article55.html", entry.location)

            val news = entry.news
            assertNotNull(news)
            assertEquals("The Example Times", news.publication.name)
            assertEquals("en", news.publication.language)

            assertEquals(LocalDate.parse("2008-12-23", LocalDate.Formats.ISO), news.publicationDate)
            assertEquals("Companies A, B in Merger Talks", news.title)
        }
    }

    /**
     * Original can be found here:
     * https://developers.google.com/search/docs/crawling-indexing/sitemaps/video-sitemaps#example-video-sitemap
     */
    @Test
    fun testGoogleVideoSitemapParsesCorrectly() {
        readResource("google.video.sample.sitemap.xml") {
            val parsed = parseUrlSet(it.readString())

            assertNotNull(parsed)
            assertEquals(1, parsed.urls.size)
            assertEquals(2, parsed.urls[0].videos.size)

            val video = parsed.urls[0].videos[0]
            assertNotNull(video)

            assertEquals(600.seconds, video.duration)
            assertEquals(Instant.fromEpochMilliseconds(1636111230000), video.expirationDate)

            assertEquals("allow", video.restriction?.relationship)
            assertEquals("IE GB US CA", video.restriction?.locations)

            assertEquals("https://www.example.com/users/grillymcgrillerson", video.uploader?.info)
            assertEquals("GrillyMcGrillerson", video.uploader?.name?.trim())
        }
    }
}