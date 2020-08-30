package service.impl

import domain.Extract
import repository.IExtractRepository
import service.IExtractService

class ExtractService(
    private val filePersitence: IExtractRepository
): IExtractService {

    override fun findAll(): List<Extract> {
        return filePersitence.findAll()
    }
}