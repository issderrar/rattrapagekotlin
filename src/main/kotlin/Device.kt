class Device(
    var year: Int,
    var device: String?,
    var commande: Int,
    var impressions: Int,
    var clics: Int,
    var cost: Int,
    var pm: Int,
    var ca: Int,
    var month: String?
) {


    override fun toString(): String {
        return "Appareil [year=$year, device=$device, commande=$commande, impressions=$impressions, clics=$clics, cost=$cost, pm=$pm, ca=$ca, month=$month]"
    }
}

