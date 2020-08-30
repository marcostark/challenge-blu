package utils

import domain.Transaction

class TransactionPrinter(
    private val transaction: List<Transaction>
) {
    fun print() {
        return println(transaction)
    }
}