package repository

import domain.Extract
import domain.Transaction

interface ITransactionRepository {

    /**
     * @description Busca todas as transações em uma
     * determinada base
     * @return Lista de transações
     * */
    fun findAll(): List<Transaction>

    /**
     * @description Realiza persistencia de um determinado conteudo
     * @param targetFileName Caminho onde o arquivo será armazenado
     * @param append Se será reescrita ou um merge de informações
     * */
    fun save (rows: List<List<String>>, targetFileName: String, append: Boolean = false)

    fun extract (): List<Extract>
}