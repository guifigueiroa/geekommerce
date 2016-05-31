package gui.commerce

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

    def save(){
      def user = new User(params)
      if (params.password != params.confirm) {
         flash.message = g.message(code: "user.passwordDoesntMatch")
         redirect action:'create'
         return
      }

      user.password = params.password.encodeAsPassword()
      if (user.save()) {
        redirect uri:'/'
      } else {
        flash.user = user
        redirect(action:'register')
      }
    }
}
