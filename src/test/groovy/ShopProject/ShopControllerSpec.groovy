package ShopProject

import grails.testing.web.controllers.ControllerUnitTest
import spock.lang.Specification

class ShopControllerSpec extends Specification implements ControllerUnitTest<ShopController> {

     void "test index action"() {
        when:
        controller.index()

        then:
        status == 200

     }
}
