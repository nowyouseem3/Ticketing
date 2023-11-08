package get.functions

import get.controllers.TicketFunctions
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

private fun ticketFormatter(): String{
    val idCounter = TicketFunctions().getIdCounter()
    var idFormat = arrayListOf('0','0','0','0','0','0','0')
    var idInserterFormat = idFormat.size - idCounter.length
    var ticketId = ""

    for (counterIndex in idCounter.indices){
        for (formatIndex in idFormat. indices){
            if (formatIndex >= idInserterFormat){
                val indicesVal = idCounter[counterIndex]
                idFormat[formatIndex] = indicesVal
            }
        }
        idInserterFormat ++
    }
    for (formatIndex in idFormat. indices){
        ticketId+= idFormat[formatIndex]
    }

    return ticketId
}

fun ticketIdGen(): String {
    val currentTime = LocalDateTime.now()
    val format = DateTimeFormatter.ofPattern("yyMMdd")
    val formatted = currentTime.format(format)

    return formatted + "-" + ticketFormatter()
}

fun timeDate(): String {
    val currentTime = LocalDateTime.now()
    val format = DateTimeFormatter.ofPattern("MM-dd-yyyy HH:mm:ss")

    return currentTime.format(format)
}
