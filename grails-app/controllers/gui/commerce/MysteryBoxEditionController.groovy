package gui.commerce

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Mixin(ControllerUtil)
@Transactional(readOnly = true)
class MysteryBoxEditionController {

    static allowedMethods = [save: "POST", update: "PUT"]

    def create() {
      respond new MysteryBoxEdition(params)
    }

    @Transactional
    def save(MysteryBoxEdition edition){
      saveObj(edition, transactionStatus) {
        redirect controller: "mysteryBox", action: "index", method: "GET"
      }
    }

    def edit(MysteryBoxEdition mysteryBoxEdition) {
        respond mysteryBoxEdition
    }

    @Transactional
    def update(MysteryBoxEdition edition){
      saveObj(edition, transactionStatus) {
        redirect controller: "mysteryBox", action: "index", method: "GET"
      }
    }
}
