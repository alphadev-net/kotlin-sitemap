package net.alphadev.sitemap.import

import de.sipgate.dachlatten.io.readResource
import kotlinx.io.readString
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