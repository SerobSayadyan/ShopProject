package ShopProject

import grails.persistence.Entity

@Entity
class Product implements Serializable {

    String code
    String name
    BigDecimal price
    Date releaseDate
    Date expiryDate

    static hasMany = [warehouseProducts: WarehouseProduct, shopProducts: ShopProduct]

    static constraints = {
        code unique: true, nullable: false
        name nullable: false
        price nullable: false, scale: 2, min: 0.0
        releaseDate nullable: false
        expiryDate nullable: true
    }

    static mapping = {
        expiryDate index: true
    }

}
