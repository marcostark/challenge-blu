package repository.impl

import org.junit.jupiter.api.Assertions.*
import org.junit.jupiter.api.Test
import utils.Constants
import utils.Utils

internal class ExtractFileRepositoryTest {

    private val pathFile = Utils.loadFilesResource("extract.csv")

    private val extractFileRepository = ExtractFileRepository(pathFile)

    @Test
    fun testFindAllTransaction() {
        val extract = extractFileRepository.findAll()
        assertNotNull(extract)
    }
}