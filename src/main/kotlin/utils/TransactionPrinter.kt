package utils

import domain.Transaction

class TransactionPrinter(
    private val transactions: List<Transaction>
) {
    /**
     * @description Imprime no console informações
     * de uma lista de transações
     * */
    fun print() {
        println("---------------------------- TRANSAÇÕES -------------------------------")
        if(transactions.isNotEmpty()) {
            for( transaction in transactions) {
                println("Conta: ${transaction.account.getNumberAndDigit()} | Saldo: ${transaction.account.balance} | Bônus: ${transaction.account.bonus} | Valor da Transação: ${transaction.value}")
            }
        } else {
            println("Não há transações a serem carregadas")
        }
    }
}