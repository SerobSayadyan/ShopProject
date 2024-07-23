package ShopProject

import org.springframework.validation.BindingResult

class ShopController {
    ShopService shopService

    def index() {
        shopService.removeExpiredProducts()
        respond Shop.list()
    }

    def show(Long id) {
        shopService.removeExpiredProducts()
        respond Shop.get(id)
    }

    def create() {
        shopService.removeExpiredProducts()
        respond new Shop(params)
    }

    def save(Shop shop) {
        shopService.removeExpiredProducts()
        if (shop.save()) {
            flash.message = "Shop ${shop.name} created."
            redirect action: "show", id: shop.id
        } else {
            render view: "create", model: [shop: shop]
        }
    }

    def edit(Long id) {
        respond Shop.get(id)
    }

    def update(Long id) {
        shopService.removeExpiredProducts()
        Shop shop = Shop.get(id)
        if (shop) {
            shop.properties = params as BindingResult
            if (shop.save()) {
                flash.message = "Shop ${shop.name} updated."
                redirect action: "show", id: shop.id
            } else {
                render view: "edit", model: [shop: shop]
            }
        } else {
            flash.message = "Shop not found."
            redirect action: "index"
        }
    }

    def delete(Long id) {
        Shop shop = Shop.get(id)
        if (shop) {
            shop.delete()
            flash.message = "Shop ${shop.name} deleted."
        } else {
            flash.message = "Shop not found."
        }
        redirect action: "index"
    }

    def sellProduct(Long shopId, Long productId, int quantity) {
        Shop shop = Shop.get(shopId)
        Product product = Product.get(productId)
        if (shop && product) {
            shopService.sellProduct(shop, product, quantity)
            flash.message = "Sold ${quantity} of ${product.name} from ${shop.name}."
        } else {
            flash.message = "Shop or Product not found."
        }
        redirect action: "show", id: shopId
    }


}
