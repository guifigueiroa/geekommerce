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


    void "Test that the edit action returns the correct model"() {
        when:"The edit action is executed with a null domain"
            controller.edit(null)

        then:"A 404 error is returned"
            response.status == 404

        when:"A domain instance is passed to the edit action"
            populateValidParams(params)
            def mysteryBoxEdition = new MysteryBoxEdition(params)
            controller.edit(mysteryBoxEdition)

        then:"A model is populated containing the domain instance"
            model.mysteryBoxEdition == mysteryBoxEdition
    }

    void "Test the update action performs an update on a valid domain instance"() {
        when:"Update is called for a domain instance that doesn't exist"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'PUT'
            controller.update(null)

        then:"A 404 error is returned"
            response.redirectedUrl == '/mysteryBox/index'
            flash.message != null

        when:"An invalid domain instance is passed to the update action"
            response.reset()
            def mysteryBoxEdition = new MysteryBoxEdition()
            mysteryBoxEdition.id = 1 // for testing purposes
            mysteryBoxEdition.validate()
            controller.update(mysteryBoxEdition)

        then:"The edit view is rendered again with the invalid instance"
            view == 'edit'
            model.mysteryBoxEdition == mysteryBoxEdition

        when:"A valid domain instance is passed to the update action"
            response.reset()
            populateValidParams(params)
            mysteryBoxEdition = new MysteryBoxEdition(params).save(flush: true)
            controller.update(mysteryBoxEdition)

        then:"A redirect is issued to the mystery box index action"
            mysteryBoxEdition != null
            response.redirectedUrl == "/mysteryBox/index"
            flash.message != null
    }
}
