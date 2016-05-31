package gui.commerce

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Mixin(ControllerUtil)
@Transactional(readOnly = true)
class MysteryBoxItemController {

    @Transactional
    def save(MysteryBoxItem item){
      saveObj(item, transactionStatus) {
        redirect controller: "mysteryBox", action: "show", method: "GET"
      }
    }
}
