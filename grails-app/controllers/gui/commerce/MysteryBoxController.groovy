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

    def image(long id) {
      MysteryBox box = MysteryBox.get(id)
      // qual o tipo do arquivo baixado?
      response.setContentType('image/png')
      // definimos o nome do arquivo
      response.setHeader('Content-disposition', 'attachment;filename=image')
      // o tamanho do arquivo baixado
      response.setHeader('Content-Length', box.image.length.toString())
      // finalmente, o download
      response.outputStream << box.image
    }
}
