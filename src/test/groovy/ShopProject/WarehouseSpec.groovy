package ShopProject

import grails.testing.gorm.DomainUnitTest
import spock.lang.Specification

class WarehouseSpec extends Specification implements DomainUnitTest<Warehouse> {

     void "test domain constraints"() {
        when:
        Warehouse domain = new Warehouse()
        //TODO: Set domain props here

        then:
        domain.validate()
     }
}
