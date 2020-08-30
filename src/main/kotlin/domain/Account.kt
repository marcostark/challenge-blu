package domain

data class Account(
    val number: String,
    val digit: Int
) {
    fun getNumberAndDigit(): String {
        return String.format("$number-$digit")
    }
}
