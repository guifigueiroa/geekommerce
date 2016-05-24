class ControllerUtil {
  def notFound(action) {
        request.withFormat {
            form multipartForm {
                flash.message = g.message(code: 'not.found.message')
                action()
            }
            '*'{ render status: NOT_FOUND }
        }
    }
}
