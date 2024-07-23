package ShopProject

import grails.testing.services.ServiceUnitTest
import spock.lang.Specification

class ProductServiceServiceSpec extends Specification implements ServiceUnitTest<ProductService> {

     void "test something"() {
        expect:
        service.doSomething()
     }
}
