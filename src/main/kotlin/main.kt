import repository.impl.TransactionFileRepository
import service.impl.AccountService
import service.impl.TransactionService
import utils.Constants
import utils.ExtractPrinter
import utils.TransactionPrinter

fun main() {
    println("Challenge Blu by Bs2")

//    val scanner = Scanner(System.`in`)
//    println("Insira o caminho do arquivo de transações")
//    val pathFile: String = scanner.nextLine()
    val pathFile = "/home/marcos/Documentos/transactions.csv"

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

    println("----------------------------------------------------------------")
    if(extract.isNotEmpty()) {
        println("Arquivo de extrato salvo em: ${Constants.PATH_RESOURCES}/${Constants.EXTRACT_FILENAME}")
    }
    // Ler aquivo de extrato e visualizar
    val extractPrinter: ExtractPrinter
//    val extractPathFile = Utils.loadFilesResource("extract.csv")
//    val extractRepository = ExtractFileRepository(extractPathFile)
//    val extractService = ExtractService(extractRepository)
//    val extractList = extractService.findAll()
    extractPrinter = ExtractPrinter(extract)
    extractPrinter.print()
}