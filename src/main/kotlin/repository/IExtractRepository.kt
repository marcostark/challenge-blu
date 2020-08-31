package repository

import domain.Extract

interface IExtractRepository {
    /**
     * @description Retorna uma lista conteudo informações de conta
     * bancárias, incluindo saldo e total de bônus
     * @return Extrato de contas
     * */
    fun findAll(): List<Extract>
}