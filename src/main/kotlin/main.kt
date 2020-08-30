import repository.impl.TransactionFileRepository
import service.impl.AccountService
import service.impl.TransactionService
import utils.TransactionPrinter
import utils.Utils

fun main() {
    println("Challenge Blu by Bs2")
    val pathFile = Utils.loadResource("transactions.csv")

    val filePersistence = TransactionFileRepository(pathFile)

    // Carregar arquivo na memoria
    val transactionPrinter: TransactionPrinter

    val accountService = AccountService()

    // Injetando servicos via construtor
    val transactionService = TransactionService(filePersistence, accountService)

    // Buscar todas as transações
    val transactionsList = transactionService.findAll()
    transactionPrinter = TransactionPrinter(transactionsList)
    transactionPrinter.print()

    // Executar as operações de deposito
    val extract = transactionService.processTransaction(transactionsList)
}