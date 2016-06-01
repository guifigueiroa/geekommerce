package gui.commerce

import grails.test.mixin.TestFor
import grails.test.mixin.Mock
import spock.lang.Specification
import spock.lang.Shared

/**
 * See the API for {@link grails.test.mixin.web.ControllerUnitTestMixin} for usage instructions
 */
@TestFor(UserController)
@Mock(User)
class UserControllerSpec extends Specification {

    @Shared email
    @Shared password
    @Shared wrongPassword
    @Shared user

    def setupSpec() {
      email = "guilherme.mfigueiroa@gmail.com"
      password = "abcd1234"
      wrongPassword = "senhaErrada"
      user = new User(email: email, password: PasswordCodec.encode(password))
    }

    def setup() {
        String.metaClass.encodeAsPassword = {
          PasswordCodec.encode(delegate)
        }

        // Mock for method
        User.metaClass.'static'.findByEmail = { email -> user }
    }

    void "Test the save action correctly persists an instance"() {

        when:"The save action is executed with an invalid instance"
            request.contentType = FORM_CONTENT_TYPE
            request.method = 'POST'
            controller.save()

        then:"The create view is rendered again with the correct model"
            response.redirectedUrl == '/user/create'

        when:"The save action is executed with a valid instance"
            response.reset()
            controller.params.email = email
            controller.params.password = password
            controller.params.confirmPassword = password
            controller.save()

        then:"A redirect is issued to the show action"
            response.redirectedUrl == '/'
            controller.flash.message != null
            User.count() == 1
    }

    void "Test that doLogin action logs in user"(){

        when:"The doLogin action is executed with invalid information"
            response.reset()
            controller.params.email = password
            controller.params.password = wrongPassword
            controller.doLogin()

        then:"The login view is rendered again"
            response.redirectedUrl == '/user/login'
            controller.flash.message != null
            session.user == null

        when:"The doLogin action is executed with valid user"
            response.reset()
            controller.params.email = email
            controller.params.password = password
            controller.doLogin()

        then:"User logs in"
            response.redirectedUrl == '/'
            session.user != null
    }

    void "Test that login action returns to home when logged in"() {
        when:"The login action is executed"
            response.reset()
            session.user = user
            controller.login()

        then:"returns to home"
            response.redirectedUrl == '/'
    }

    void "Tests that logout action works"() {
        when:"The logout action is executed and user is logged in"
            response.reset()
            session.user = user
            controller.logout()

        then:"Session ends"
            session.user == null
            response.redirectedUrl == '/user/login'
    }
}
