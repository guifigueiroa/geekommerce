import static org.springframework.http.HttpStatus.*

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

  def saveObj(obj, transactionStatus, onSuccess=null) {
    onSuccess = onSuccess ?: {redirect action: "index", method: "GET"}
    if(obj.save(flush:true)) {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: "${getName(obj)}.label"), obj.id])
                onSuccess()
            }
            json {
              respond obj, [status: CREATED, formats:['json']]
            }
            '*' { respond obj, [status: CREATED] }
        }
      } else {
        transactionStatus.setRollbackOnly()
        if(obj?.hasErrors()) {
          request.withFormat {
            json { respond obj.errors, [status: UNPROCESSABLE_ENTITY, formats:['json']] }
            '*' { respond obj.errors, view:'create' }
          }

        } else {
          notFound(onSuccess)
        }
      }
  }

  private String getName(Object obj) {
    String className = obj.getClass().getSimpleName().toString()
    return className[0].toLowerCase() + className.drop(1)
  }
}
