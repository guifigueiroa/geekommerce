package gui.commerce

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(MysteryBoxController)
@Mock(MysteryBox)
class MysteryBoxControllerSpec extends Specification {

    def populateValidParams(params) {
        params["name"] = "Electronics"
        params["url"] = "www.mybox.com.br"
        params["defaultProducts"] = "2 tees, 1 botton"
        params["image"] = [0, 2, 6, 1, 7] as byte[]
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.mysteryBoxList
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.mysteryBox!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def mysteryBox = new MysteryBox()
            mysteryBox.validate()
            controller.save(mysteryBox)

        then:"The create view is rendered again with the correct model"
            model.mysteryBox!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            mysteryBox = new MysteryBox(params)

            controller.save(mysteryBox)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/mysteryBox/index'
            controller.flash.message != null
            MysteryBox.count() == 1
    }
}
