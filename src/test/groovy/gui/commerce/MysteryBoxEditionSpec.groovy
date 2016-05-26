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
class MysteryBoxEditionSpec extends Specification {

    @Shared theme
    @Shared date
    @Shared image
    @Shared bigImage
    @Shared box

    def setupSpec() {
      theme = "Game of thrones"
      date = new Date()
      image = new byte[2**20];
      bigImage = new byte[2**20+1]
      box = new MysteryBox(name: "name",
                           url: "www.aURL.com",
                           defaultProducts: "1 tee",
                           image: image)
    }

    def cleanup() {
    }

    void "test validations"() {
        expect:
          new MysteryBoxEdition(theme: theme,
            date: date, image: image, box: box).validate() == result
        where:
          theme | date | image    | box  | result
          theme | date | image    | box  | true
          null  | date | image    | box  | false
          theme | null | image    | box  | false
          theme | date | null     | box  | false
          theme | date | image    | null | false
          theme | date | bigImage | box  | false

    }
}
