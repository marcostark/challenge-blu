package service

import domain.Extract

interface IExtractService {

    fun findAll(): List<Extract>

}