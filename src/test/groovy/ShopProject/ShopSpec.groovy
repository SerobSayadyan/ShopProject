package ShopProject

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class ShopSpec extends Specification implements DomainUnitTest<Shop> {

     void "test domain constraints"() {
        when:
        Shop domain = new Shop()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
