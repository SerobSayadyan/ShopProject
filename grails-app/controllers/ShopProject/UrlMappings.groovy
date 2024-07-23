package ShopProject

class UrlMappings {
    static mappings = {
        "/products"(controller: 'product', action: 'index', method: 'GET')
        "/products/$id"(controller: 'product', action: 'show', method: 'GET')
        "/products"(controller: 'product', action: 'create', method: 'POST')
        "/products/$id"(controller: 'product', action: 'update', method: 'PUT')
        "/products/$id"(controller: 'product', action: 'delete', method: 'DELETE')


        "/shops"(controller: 'shop', action: 'index', method: 'GET')
        "/shops"(controller: 'shop', action: 'create', method: 'POST')
        "/shops/$id"(controller: 'shop', action: 'show', method: 'GET')
        "/shops/$id"(controller: 'shop', action: 'update', method: 'PUT')
        "/shops/$id"(controller: 'shop', action: 'delete', method: 'DELETE')

        "/warehouses"(controller: 'warehouse', action: 'create', method: 'POST')
        "/warehouses/$id"(controller: 'warehouse', action: 'show', method: 'GET')
        "/warehouses/$id"(controller: 'warehouse', action: 'update', method: 'PUT')
        "/warehouses/$id"(controller: 'warehouse', action: 'delete', method: 'DELETE')

        "/"(view: '/index')

        "500"(view: '/error')
        "404"(view: '/notFound')
    }
}
