package domain

class Extract(
        val account: Account
) {
    override fun toString(): String {
        return "Extract: Account: ${account.getNumberAndDigit()} | Total de Depositos: ${account.balance} | Total de Bônus: ${account.bonus}"
    }
}
