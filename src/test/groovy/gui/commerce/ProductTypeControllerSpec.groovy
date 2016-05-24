package gui.commerce

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(ProductTypeController)
@Mock(ProductType)
class ProductTypeControllerSpec extends Specification {

    def populateValidParams(params) {
        params["name"] = "Electronics"
    }

    void "Test the index action returns the correct model"() {

        when:"The index action is executed"
            controller.index()

        then:"The model is correct"
            !model.productTypeList
    }

    void "Test the create action returns the correct model"() {
        when:"The create action is executed"
            controller.create()

        then:"The model is correctly created"
            model.productType!= null
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            def productType = new ProductType()
            productType.validate()
            controller.save(productType)

        then:"The create view is rendered again with the correct model"
            model.productType!= null
            view == 'create'

        when:"The save action is executed with a valid instance"
            response.reset()
            populateValidParams(params)
            productType = new ProductType(params)

            controller.save(productType)

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/productType/index'
            controller.flash.message != null
            ProductType.count() == 1
    }
}
