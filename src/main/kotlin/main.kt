import repository.impl.TransactionFileRepository
import service.impl.TransactionService
import utils.TransactionPrinter
import utils.Utils

fun main() {
    println("Challenge Blu by Bs2")
    val pathFile = Utils.loadResource("transactions.csv")

    val filePersistence = TransactionFileRepository(pathFile)

    // Carregar arquivo na memoria
    val transactionPrinter: TransactionPrinter

    // Injetando servicos via construtor
    val transactionService = TransactionService(filePersistence)

    // Buscar todas as transações
    val transactionsList = transactionService.findAll()
    transactionPrinter = TransactionPrinter(transactionsList)
    transactionPrinter.print()
}