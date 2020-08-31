package service

import domain.Account
import domain.Transaction

interface IAccountService {
    /**
     * @description Realiza um deposito em uma conta a partir de
     * uma transação
     * @param transaction Contém a conta e o valor da transação
     * @param bonus Bonus de acordo com o tipo de conta
     * */
    fun deposit(transaction: Transaction, bonus: Double): Account
}
