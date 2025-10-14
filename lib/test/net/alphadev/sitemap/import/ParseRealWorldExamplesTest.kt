package net.alphadev.sitemap.import

import de.sipgate.dachlatten.io.readResource
import kotlinx.io.readString
import kotlin.test.Test
import kotlin.test.assertEquals
import kotlin.test.assertNotNull

class ParseRealWorldExamplesTest {

    @Test
    fun testWordpressOrgSitemapParsesCorrectly() {
        readResource("wordpress.org.sitemap.xml") {
            val parsed = parseSitemapIndex(it.readString())

            assertNotNull(parsed)
            assertEquals(3, parsed.sitemaps.size)
        }
    }

    @Test
    fun testSitemapsOrgSitemapParsesCorrectly() {
        readResource("sitemaps.org.sitemap.xml") {
            val parsed = parseUrlSet(it.readString())

            assertNotNull(parsed)
            assertEquals(84, parsed.urls.size)
        }
    }

    @Test
    fun testYoastComSitemapParsesCorrectly() {
        readResource("yoast.com.sitemap.xml") {
            val parsed = parseSitemapIndex(it.readString())

            assertNotNull(parsed)
            assertEquals(22, parsed.sitemaps.size)
        }
    }

    @Test
    fun testYoastComOtherSitemapParsesCorrectly() {
        readResource("yoast.com.sitemap2.xml") {
            val parsed = parseUrlSet(it.readString())

            assertNotNull(parsed)
            assertEquals(66, parsed.urls.size)

            val firstUrl = parsed.urls[0]
            assertEquals(1, firstUrl.images.size)
            assertEquals("https://yoast.com/app/uploads/2018/01/what_is_ux_2400x1350.jpg", firstUrl.images[0].location)

            assertEquals(7, parsed.urls[1].images.size)
        }
    }
}
