package ShopProject

class Shop implements Serializable {

    String code
    String name
    String address

    static hasMany = [products: ShopProduct]

    static constraints = {
        code unique: true, nullable: false
        name nullable: false
        address nullable: false
    }
}

