package ShopProject

import grails.gorm.transactions.Transactional

@Transactional
class ShopService {


    void sellProduct(Shop shop, Product product, int quantity) {
        if (shop.products[product] >= quantity) {
            shop.products[product] -= quantity
        }
    }

    void removeExpiredProducts() {
        def expiredProducts = Product.findAllByExpiryDateLessThan(new Date())
        expiredProducts.each { product ->
            product.warehouseProducts.each { wp ->
                def warehouse = wp.warehouse
                def warehouseProduct = warehouse.products.find { it.product == product }
                if (warehouseProduct) {
                    warehouseProduct.quantity += wp.quantity
                } else {
                    warehouse.addToProducts(new WarehouseProduct(product: product, quantity: wp.quantity))
                }
                wp.delete(flush: true)
            }
            product.delete(flush: true)
        }
    }
}
