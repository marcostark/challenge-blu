import repository.impl.ExtractFileRepository
import repository.impl.TransactionFileRepository
import service.impl.AccountService
import service.impl.ExtractService
import service.impl.TransactionService
import utils.ExtractPrinter
import utils.TransactionPrinter
import utils.Utils
import java.util.*

fun main() {
    println("Challenge Blu by Bs2")

    val scanner = Scanner(System.`in`)
    println("Insira o caminho do arquivo de transações")
    val pathFile: String = scanner.nextLine()

    //Caso queira carregar o arquivo diretamente da pasta resources
    //val pathFile = Utils.loadResource("transactions.csv")

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

    // Ler aquivo de extrato e visualizar
    val extractPrinter: ExtractPrinter

    val extractPathFile = Utils.loadFilesResource("extract.csv")
    val extractRepository = ExtractFileRepository(extractPathFile)
    val extractService = ExtractService(extractRepository)
    val extractList = extractService.findAll()
    extractPrinter = ExtractPrinter(extractList)
    extractPrinter.print()
}