package utils

import domain.Extract

class ExtractPrinter(
    private val accounts: List<Extract>
) {
    fun print() {
        println("------------------------------- EXTRATO ------------------------------")
        if(accounts.isNotEmpty()) {
            for( account in accounts) {
                println("Conta: ${account.account.getNumberAndDigit()} | Total de Depositos: ${account.account.balance} | Total de Bônus: ${account.account.bonus}")
            }
        } else {
            println("Nenhuma há extrato disponível")
        }
    }
}