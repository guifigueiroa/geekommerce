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
      saveObj(mysteryBox, transactionStatus)
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
