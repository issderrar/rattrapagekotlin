class Device {
    var year: Int = 0
    var device: String? = null
    var commande: Int = 0
    var impressions: Int = 0
    var clics: Int = 0
    var cost: Int = 0
    var pm: Int = 0
    var ca: Int = 0
    var network: Int = 0
    var month: String? = null


    constructor(
        year: Int,
        device: String?,
        commande: Int,
        impressions: Int,
        clics: Int,
        cost: Int,
        pm: Int,
        ca: Int,
        network: Int,
        month: String?
    ) {
        this.year = year
        this.device = device
        this.commande = commande
        this.impressions = impressions
        this.clics = clics
        this.cost = cost
        this.pm = pm
        this.ca = ca
        this.network = network
        this.month = month
    }

    override fun toString(): String {
        return "Appareil [year=" + year + ", device=" + device + ", commande=" + commande + ", impressions=" + impressions + "" + ", clics=" + clics + ", cost=" + cost + ", pm=" + pm + ", ca=" + ca + ", network=" + network + ", month=" + month + "]"
    }
}

