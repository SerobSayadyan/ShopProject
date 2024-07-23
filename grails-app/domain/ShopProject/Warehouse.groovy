package ShopProject

class Warehouse implements Serializable {

    String code
    String name

    static hasMany = [products: WarehouseProduct]

    static constraints = {
        code unique: true, nullable: false
        name nullable: false
    }
}

