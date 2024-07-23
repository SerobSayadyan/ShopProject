package ShopProject

class WarehouseProduct implements Serializable {

    Product product
    int quantity

    static belongsTo = [warehouse: Warehouse]

    static constraints = {
        product nullable: false
        quantity min: 0
    }

    static mapping = {
        id composite: ['warehouse', 'product']
    }
}