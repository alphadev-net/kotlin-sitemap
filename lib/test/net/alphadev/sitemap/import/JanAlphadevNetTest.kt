package net.alphadev.sitemap.import

import kotlinx.io.readString
import net.alphadev.sitemap.readResource
import kotlin.test.Test
import kotlin.test.assertNotNull

class JanAlphadevNetTest {
    @Test
    fun testJanAlphadevNetSitemapParsesCorrectlyEvenWithWeirdFormatting() {
        readResource("jan.alphadev.net.weird.sitemap.xml") {
            val parsed = parseUrlSet(it.readString())

            assertNotNull(parsed)
        }
    }
}