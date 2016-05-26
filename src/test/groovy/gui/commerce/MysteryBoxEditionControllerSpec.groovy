package gui.commerce

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(MysteryBoxEditionController)
@Mock(MysteryBoxEdition)
class MysteryBoxEditionControllerSpec extends Specification {

    def populateValidParams(params) {
        def boxParams = [] as HashMap
        boxParams["name"] = "Electronics"
        boxParams["url"] = "www.mybox.com.br"
        boxParams["defaultProducts"] = "2 tees, 1 botton"
        boxParams["image"] = [0, 2, 6, 1, 7] as byte[]

        params["theme"] = "Adventure Time"
        params["date"] = new Date()
        params["image"] = [0, 2, 6, 1, 7] as byte[]
        params["box"] = new MysteryBox(boxParams)
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.mysteryBoxEdition!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def mysteryBoxEdition = new MysteryBoxEdition()
            mysteryBoxEdition.validate()
            controller.save(mysteryBoxEdition)

        then:"The create view is rendered again with the correct model"
            model.mysteryBoxEdition!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            mysteryBoxEdition = new MysteryBoxEdition(params)

            controller.save(mysteryBoxEdition)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/mysteryBox/index'
            controller.flash.message != null
            MysteryBoxEdition.count() == 1
    }
}
