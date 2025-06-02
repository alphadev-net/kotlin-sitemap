package net.alphadev.sitemap.import

import kotlinx.io.readString
import net.alphadev.sitemap.readResource
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
}
