package gui.commerce

import grails.test.mixin.TestFor
import spock.lang.Specification
import grails.test.mixin.Mock

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(ProductType)
@Mock(ProductType)
class ProductTypeSpec extends Specification {

    def type

    def setup() {
      type = new ProductType(name: "Some Name")
    }

    def cleanup() {
    }

    void "expect ProductType to not be null or blank"() {
        when:
          def type1 = new ProductType(name: null)
          def type2 = new ProductType(name: " ")

        then:
          type1.validate() == false
          type2.validate() == false
    }

    void "expect ProductType to save when valid"() {
      expect:
        type.save()
    }
}
