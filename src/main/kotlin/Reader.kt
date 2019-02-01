import java.io.BufferedReader
import java.io.FileReader
import java.io.IOException
import java.util.*

val APPAREIL_YEAR_IDX = 0
val APPAREIL_DEVICE_IDX = 1
val APPAREIL_COMMANDE_IDX = 2
val APPAREIL_IMPRESSION_IDX = 3
val APPAREIL_CLICS_IDX = 4
val APPAREIL_COST_IDX = 5
val APPAREIL_PM_IDX = 6
val APPAREIL_CA_IDX = 7
val APPAREIL_NETWORK_IDX = 8
val APPAREIL_MONTH_IDX = 9


fun main(args: Array<String>?) {
    var fileReader: BufferedReader? = null

    try {
        val devices = ArrayList<Device>()
        var line: String?

        fileReader = BufferedReader(FileReader("data_csv.csv"))

        // Read CSV header
        fileReader.readLine()

        // Read the file line by line starting from the second line
        line = fileReader.readLine()
        while (line != null) {
            val tokens = line.split(",")
            if (tokens.size > 0) {
                val device = Device(
                    Integer.parseInt(tokens[APPAREIL_YEAR_IDX]),
                    tokens[APPAREIL_DEVICE_IDX],
                    Integer.parseInt(tokens[APPAREIL_COMMANDE_IDX]),
                    Integer.parseInt(tokens[APPAREIL_IMPRESSION_IDX]),
                    Integer.parseInt(tokens[APPAREIL_CLICS_IDX]),
                    Integer.parseInt(tokens[APPAREIL_COST_IDX]),
                    Integer.parseInt(tokens[APPAREIL_PM_IDX]),
                    Integer.parseInt(tokens[APPAREIL_NETWORK_IDX]),
                    Integer.parseInt(tokens[APPAREIL_CA_IDX]),
                    tokens[APPAREIL_MONTH_IDX]
                )
                devices.add(device)
            }

            line = fileReader.readLine()
        }

        // Print the new customer list
        for (device in devices) {
            println(device)
        }
    } catch (e: Exception) {
        println("Reading CSV Error!")
        e.printStackTrace()
    } finally {
        try {
            fileReader!!.close()
        } catch (e: IOException) {
            println("Closing fileReader Error!")
            e.printStackTrace()
        }
    }
}
