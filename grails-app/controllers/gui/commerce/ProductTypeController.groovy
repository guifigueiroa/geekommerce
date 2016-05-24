package gui.commerce

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Mixin(ControllerUtil)
@Transactional(readOnly = true)
class ProductTypeController {

    static allowedMethods = [save: "POST", delete: "DELETE"]

    def index(Integer max) {
      params.max = Math.min(max ?: 10, 100)
      respond ProductType.list(params)
    }

    def create() {
      respond new ProductType(params)
    }

    @Transactional
    def save(ProductType productType) {
      if(productType?.save(flush:true)) {
        request.withFormat {
            form multipartForm {
                flash.message = message(code: 'default.created.message', args: [message(code: 'productType.label', default: 'ProductType'), productType.id])
                redirect action: "index", method: "GET"
            }
            '*' { respond productType, [status: CREATED] }
        }
      } else {
        transactionStatus.setRollbackOnly()
        if(productType?.hasErrors())
          respond productType.errors, view:'create'
        else
          notFound({redirect action: "index", method: "GET"})
      }
    }
}
