fun main() {
    val totalCommission = calculateCommission("Visa", 76000, 100000)
    println("Итого: " + totalCommission)
}

fun calculateCommission(type: String, previousTransfers: Int, transferNow: Int): Int {
    return checkCommissionForType(type, previousTransfers, transferNow)
}

fun checkCommissionForType(type: String, previousTransfers: Int, transferNow: Int) = when (type) {
    "VK Pay" -> 0
    "Visa", "Mir" -> calculateCommissionForVisaOrMir(transferNow)
    "Mastercard", "Maestro" -> checkForLimitAndCalculate(previousTransfers, transferNow)
    else -> 0
}

fun checkForLimitAndCalculate(previousTransfers: Int, transferNow: Int): Int {
   var commissionForMasterOrMaestro = 0
    if (previousTransfers <= 75_000){
        commissionForMasterOrMaestro
    } else {
        commissionForMasterOrMaestro = ((transferNow / 100 * 0.006) + 20).toInt()
    }
    return commissionForMasterOrMaestro
}

fun calculateCommissionForVisaOrMir(transferNow: Int): Int {
    var commissionForVisaOrMir = (transferNow / 100 * 0.0075).toInt()
    if (commissionForVisaOrMir < 35) {
        commissionForVisaOrMir = 35
    }
    return commissionForVisaOrMir
}
