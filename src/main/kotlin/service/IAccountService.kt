package service

import domain.Account
import domain.Transaction

interface IAccountService {
    fun updateBalance(transaction: Transaction, bonus: Double): Account
}
