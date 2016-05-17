package gui.commerce

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import spock.lang.Shared

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(OrderItem)
@Mock([OrderItem, Product, ProductType])
class OrderItemSpec extends Specification {

    @Shared product
    @Shared order

    def setupSpec() {
      ProductType t = new ProductType(name: "Electronics")
      product = new Product(name: "TV", type: t , value: 2.99)
      order = new Order()
    }

    def cleanup() {
    }

    void "test validations"() {
      expect:
        new OrderItem(product: product,
                      quantity: quantity,
                      order: order).validate() == result
      where:
        product | quantity | order | result
        product |        1 | order | true
        null    |        1 | order | false
        product |        0 | order | false
        null    |        1 |  null | false
        product |      101 | order | false
    }
}
