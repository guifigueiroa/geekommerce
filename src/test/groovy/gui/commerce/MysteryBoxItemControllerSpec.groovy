package gui.commerce

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(MysteryBoxItemController)
@Mock(MysteryBoxItem)
class MysteryBoxItemControllerSpec extends Specification {

    def populateValidParams(params) {
        params["name"] = "Electronics"
        def box = new MysteryBox(name: "name",
                           url: "www.aURL.com",
                           defaultProducts: "1 hoodie",
                           image: new byte[0])
        params["edition"] = new MysteryBoxEdition(theme: "Game of thrones",
            date: new Date(), image: new byte[0], box: box)

    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def mysteryBoxItem = new MysteryBoxItem()
            mysteryBoxItem.validate()
            controller.save(mysteryBoxItem)

        then:"The create view is rendered again with the correct model"
            model.mysteryBoxItem!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            mysteryBoxItem = new MysteryBoxItem(params)

            controller.save(mysteryBoxItem)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/mysteryBox/show'
            controller.flash.message != null
            MysteryBoxItem.count() == 1
    }
}
