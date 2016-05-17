package gui.commerce

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import spock.lang.Shared


/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Product)
@Mock([ProductType, Product])
class ProductSpec extends Specification {

    @Shared electronics
    @Shared image

    def setupSpec() {
      electronics = new ProductType(name: "Electronics")
      image = new byte[0]
    }

    def cleanup() {
    }

    void "test validations"() {
        expect:
          new Product(name: name,
                      type: type,
                      value: value,
                      image: image).validate() == result
        where:
          name  |     type     | value | image | result
          "TV"  | electronics  | 10.99 | image | true
          "TV"  | electronics  |  2.99 | null  | true
          null  | electronics  | 99.99 | image | false
          "TV"  | null         | 56.00 | image | false
          "TV"  | electronics  |  null | image | false
          "TV"  | electronics  | 10002 | image | false
    }
}
