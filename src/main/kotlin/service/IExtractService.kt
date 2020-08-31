package service

import domain.Extract

interface IExtractService {

    /**
     * @description Retorna uma lista de contas
     * @return Lista de conta processadas
     * */
    fun findAll(): List<Extract>

}