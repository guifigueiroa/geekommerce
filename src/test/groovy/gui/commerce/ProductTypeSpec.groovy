package gui.commerce

import grails.test.mixin.TestFor
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ProductType)
class ProductTypeSpec extends Specification {

    def setup() {
    }

    def cleanup() {
    }

    void "expect ProductType to not be null or blank"() {
        when:
          def type = ProductType(name: null)
          def type2 = ProductType(name: " ")

        then:
          type.validate() == null
          type2.validate() == null
    }
}
