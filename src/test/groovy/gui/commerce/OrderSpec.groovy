package gui.commerce

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import spock.lang.Shared

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(Order)
@Mock([Order, OrderItem, Product, ProductType])
class OrderSpec extends Specification {

    @Shared orderItems

    def setupSpec() {
      ProductType t = new ProductType(name: "Electronics")
      Product p1 = new Product(name: "TV", type: t , value: 2.99)
      Product p2 = new Product(name: "Videogame", type: t , value: 2.99)
      orderItems = [] as List
      orderItems << new OrderItem(product: p1, quantity: 1)
      orderItems << new OrderItem(product: p2, quantity: 1)
    }

    def cleanup() {
    }

    void "test validations"() {
        expect:
          new Order(items: items).validate() == result
        where:
            items    | result
          orderItems | true
          null       | false
          [] as List | false
    }
}
