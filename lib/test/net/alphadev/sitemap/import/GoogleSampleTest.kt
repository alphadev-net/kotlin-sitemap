package net.alphadev.sitemap.import

import kotlinx.io.readString
import net.alphadev.sitemap.readResource
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

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
}