package ShopProject

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class WarehouseControllerSpec extends Specification implements ControllerUnitTest<WarehouseController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
