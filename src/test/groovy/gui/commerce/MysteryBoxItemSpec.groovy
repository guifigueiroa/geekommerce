package gui.commerce

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import spock.lang.Shared

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(MysteryBoxItem)
@Mock([MysteryBox, MysteryBoxItem])
class MysteryBoxItemSpec extends Specification {

    @Shared name
    @Shared edition

    def setupSpec() {
      name = "Game of thrones Hoodie"
      def box = new MysteryBox(name: "name",
                           url: "www.aURL.com",
                           defaultProducts: "1 hoodie",
                           image: new byte[0])
      edition = new MysteryBoxEdition(theme: "Game of thrones",
            date: new Date(), image: new byte[0], box: box)
    }

    def cleanup() {
    }

    void "test validations"() {
        expect:
          new MysteryBoxItem(name: name,
            edition: edition).validate() == result
        where:
          name | edition | result
          name | edition | true
          null | edition | false
          name | null    | false
    }
}
