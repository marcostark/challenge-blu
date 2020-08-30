package domain

data class Account(
    val number: String?,
    val digit: Int?,
    var balance: Double = 0.0,
    var bonus: Double = 0.0
) {

    fun getNumberAndDigit(): String {
        return String.format("$number-$digit")
    }
}
