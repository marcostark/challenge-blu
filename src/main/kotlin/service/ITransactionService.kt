package service

import domain.Extract
import domain.Transaction

interface ITransactionService {

    /**
     * @description Retorna uma lista com todas as transações
     */
    fun findAll(): List<Transaction>

    /**
     * @description Processa uma lista de transações
     * @param transactions Transações a serem processadas
     * @return Uma lista conteúdo o extrato de todas as contas
     * processadas
     * */
    fun processTransaction(transactions: List<Transaction>): List<Extract>

}