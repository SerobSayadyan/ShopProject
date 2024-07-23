package ShopProject

import grails.gorm.transactions.Transactional

@Transactional
class WarehouseService {


    void addProductToWarehouse(Warehouse warehouse, Product product, int quantity) {
        def warehouseProduct = warehouse.products.find { it.product == product }
        if (warehouseProduct) {
            warehouseProduct.quantity += quantity
        } else {
            warehouse.addToProducts(new WarehouseProduct(product: product, quantity: quantity))
        }
    }

    boolean removeProductFromWarehouse(Warehouse warehouse, Product product, int quantity, Shop shop) {
        def warehouseProduct = warehouse.products.find { it.product == product }
        if (warehouseProduct && warehouseProduct.quantity >= quantity) {
            warehouseProduct.quantity -= quantity
            def shopProduct = shop.products.find { it.product == product }
            if (shopProduct) {
                shopProduct.quantity += quantity
            } else {
                shop.addToProducts(new ShopProduct(product: product, quantity: quantity))
            }
            return true
        }
        return false
    }
}
