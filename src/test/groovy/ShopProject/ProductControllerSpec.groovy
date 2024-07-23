package ShopProject

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class ProductControllerSpec extends Specification implements ControllerUnitTest<ProductController> {

     void "test index action"() {
        when:
        controller.getAll()

        then:
        status == 200

     }
}
