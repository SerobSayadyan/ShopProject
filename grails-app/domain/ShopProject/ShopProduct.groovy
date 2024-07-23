package ShopProject

import groovy.transform.EqualsAndHashCode

@EqualsAndHashCode(includes = ['shop', 'product'])
class ShopProduct implements Serializable {

    Product product
    int quantity

    static belongsTo = [shop: Shop]

    static constraints = {
        product nullable: false
        quantity min: 0
    }

    static mapping = {
        id composite: ['shop', 'product']
    }
}