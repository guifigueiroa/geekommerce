package gui.commerce

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Mixin(ControllerUtil)
@Transactional(readOnly = true)
class MysteryBoxController {

    static allowedMethods = [save: "POST"]

    def index(Integer max) {
      params.max = Math.min(max ?: 10, 100)
      respond MysteryBox.list(params)
    }

    def create() {
      respond new MysteryBox(params)
    }

    @Transactional
    def save(MysteryBox mysteryBox) {
      if(mysteryBox.save(flush:true)) {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'mysteryBox.label', default: 'Mystery Box'), mysteryBox.id])
                redirect action: "index", method: "GET"
            }
            '*' { respond mysteryBox, [status: CREATED] }
        }
      } else {
        transactionStatus.setRollbackOnly()
        if(mysteryBox?.hasErrors())
          respond mysteryBox.errors, view:'create'
        else
          notFound({redirect action: "index", method: "GET"})
      }
    }

    def show(MysteryBox box) {
      respond box
    }

    def image(long id) {
      MysteryBox box = MysteryBox.get(id)
      response.setContentType('image/png')
      response.setHeader('Content-disposition', 'attachment;filename=image')
      response.setHeader('Content-Length', box.image.length.toString())
      response.outputStream << box.image
    }
}
