package gui.commerce

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import spock.lang.Shared

/**
 * See the API for {@link grails.test.mixin.domain.DomainClassUnitTestMixin} for usage instructions
 */
@TestFor(MysteryBox)
@Mock(MysteryBox)
class MysteryBoxSpec extends Specification {

    @Shared aURL
    @Shared image
    @Shared bigImage
    @Shared prod

    def setupSpec() {
      aURL = "http://www.google.com"
      prod = "2 camisetas"
      image = new byte[2**20];
      bigImage = new byte[2**20+1]
    }

    def cleanup() {
    }

    void "test validations"() {
        expect:
          new MysteryBox(name: name,
                      url: url,
                      defaultProducts: prod,
                      image: image).validate() == result
        where:
          name  | url  | image    | defaultProducts | result
          "Box" | aURL | image    | prod            |true
          null  | aURL | image    | prod            |false
          "Box" | null | image    | prod            |false
          "Box" | aURL | null     | prod            |false
          "Box" | aURL | bigImage | prod            |false

    }
}
