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
    @Shared aURL

    def setupSpec() {
      electronics = new ProductType(name: "Electronics")
      aURL = "http://www.google.com"
    }

    def cleanup() {
    }

    void "test validations"() {
        expect:
          new Product(name: name,
                      type: type,
                      value: value,
                      url: url).validate() == result
        where:
          name  |     type     | value | url  | result
          "TV"  | electronics  | 10.99 | aURL | true
          null  | electronics  | 99.99 | aURL | false
          "TV"  | null         | 56.00 | aURL | false
          "TV"  | electronics  |  null | aURL | false
          "TV"  | electronics  | 10.99 | null | false
          "TV"  | electronics  | 10002 | aURL | false
    }
}
