package gui.commerce

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Mixin(ControllerUtil)
@Transactional(readOnly = true)
class MysteryBoxEditionController {

    def create() {
      respond new MysteryBoxEdition(params)
    }

    @Transactional
    def save(MysteryBoxEdition edition) {
      saveObj(edition, transactionStatus)
    }
}
