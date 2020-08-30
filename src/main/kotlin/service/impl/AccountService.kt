package service.impl

import domain.Account
import domain.Transaction
import service.IAccountService

class AccountService: IAccountService {

    override fun deposit(transaction: Transaction, bonus: Double): Account {
        val account = transaction.account
        account.balance = transaction.value.toDouble()
        return account
    }
}
