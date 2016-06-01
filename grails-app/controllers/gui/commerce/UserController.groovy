package gui.commerce

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Mixin(ControllerUtil)
@Transactional(readOnly = true)
class UserController {

    def login() {
      if (session.user) {
         redirect uri:'/'
      }
    }

    def doLogin(){
      def user = User.findByEmail(params.email)
      if (!user) {
        flash.message = g.message(code: "login.userNotFound", args: [params.email])
        redirect action:'login'
        return
      }

      if (user.password != params.password.encodeAsPassword()) {
        flash.message = g.message(code: "login.passwordIncorrect", args: [params.email])
        redirect action:'login'
        return
      }

      session.user = user
      redirect uri:'/'
    }

    def logout() {
      session.user = null
      redirect action:'login'
    }

    def create(){

    }

    @Transactional
    def save(){
      def user = new User()
      if (!params.password || params.password.allWhitespace
          || params.password != params.confirmPassword) {
         flash.message = g.message(code: "user.passwordDoesntMatch")
         redirect action:'create'
         return
      }

      user.email = params.email
      user.password = params.password?.encodeAsPassword()
      saveObj(user, transactionStatus) {
        session.user = user
        redirect uri:'/'
      }
    }
}
