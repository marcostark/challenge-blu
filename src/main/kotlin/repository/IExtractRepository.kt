package repository

import domain.Extract

interface IExtractRepository {
    fun findAll(): List<Extract>
}