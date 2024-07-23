package ShopProject


import org.slf4j.Logger
import org.slf4j.LoggerFactory

import javax.transaction.Transactional

@Transactional
class ProductService {

    private static final Logger LOGGER = LoggerFactory.getLogger(ProductService.class)

    def findAll() {
        return Product.list()
    }

    def get(Long id) {
        return Product.findById(id)
    }

    def create(Product product) {
        return product.save(true);
    }

    def update(Product product) {
        return product.save(true);
    }

    def delete(Long id) {
        Product product = Product.findById(id)
        if (product) {
            product.delete()
            LOGGER.info("Product deleted successfully: ${product}")
        } else {
            LOGGER.error("Product with id '${id}' not found")
            throw new RuntimeException("Product with id '${id}' not found")
        }
    }
}
