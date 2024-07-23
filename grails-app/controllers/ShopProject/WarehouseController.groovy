package ShopProject

class WarehouseController {
    WarehouseService warehouseService

    def index() {
        respond Warehouse.list()
    }

    def show(Long id) {
        respond Warehouse.get(id)
    }

    def create() {
        respond new Warehouse(params)
    }

    def save(Warehouse warehouse) {
        if (warehouse.save()) {
            flash.message = "Warehouse ${warehouse.name} created."
            redirect action: "show", id: warehouse.id
        } else {
            render view: "create", model: [warehouse: warehouse]
        }
    }

    def edit(Long id) {
        respond Warehouse.get(id)
    }

    def update(Long id) {
        Warehouse warehouse = Warehouse.get(id)
        if (warehouse) {
            warehouse.properties = params
            if (warehouse.save()) {
                flash.message = "Warehouse ${warehouse.name} updated."
                redirect action: "show", id: warehouse.id
            } else {
                render view: "edit", model: [warehouse: warehouse]
            }
        } else {
            flash.message = "Warehouse not found."
            redirect action: "index"
        }
    }

    def delete(Long id) {
        Warehouse warehouse = Warehouse.get(id)
        if (warehouse) {
            warehouse.delete()
            flash.message = "Warehouse ${warehouse.name} deleted."
        } else {
            flash.message = "Warehouse not found."
        }
        redirect action: "index"
    }
}
