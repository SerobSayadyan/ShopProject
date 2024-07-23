package ShopProject

import grails.converters.JSON
import org.springframework.validation.BindingResult

@SuppressWarnings("all")
class ProductController {
    ProductService productService

    static allowedMethods = [index: "GET", show: "GET", create: "POST", update: "PUT", delete: "DELETE"]

    def index() {
        def products = productService.findAll();
        if (products) {
            render status: 201, contentType: 'application/json', text: [message: "The products list", products: products] as JSON
        } else {
            render status: 400, contentType: 'application/json', text: [message: "Error: No product has been found", errors: (products ? products.errors : null)] as JSON
        }
    }

    def show(Long id) {
        def product = productService.get(id)
        if (product) {
            render status: 201, contentType: 'application/json', text: [message: "The product", product: product] as JSON
        } else {
            render status: 400, contentType: 'application/json', text: [message: "Error while finding product", errors: (product ? product.errors : null)] as JSON
        }
    }

    def create() {
        def jsonRequest = request.JSON
        def product = new Product(jsonRequest as Map)
        if (productService.create(product)) {
            render status: 201, contentType: 'application/json', text: [message: "Product created successfully", product: product] as JSON
        } else {
            render status: 400, contentType: 'application/json', text: [message: "Error creating product", errors: product.errors] as JSON
        }
    }

    def update(Long id) {
        Product product = Product.get(id)
        if (product) {
            product.properties = params as BindingResult
            if (product.save()) {
                flash.message = "Product ${product.name} updated."
                redirect action: "show", id: product.id
            } else {
                render view: "edit", model: [product: product]
            }
        } else {
            flash.message = "Product not found."
            redirect action: "getAll"
        }
    }

    def delete(Long id) {
        Product product = Product.get(id)
        if (product) {
            product.delete()
            flash.message = "Product ${product.name} deleted."
        } else {
            flash.message = "Product not found."
        }
    }
}
