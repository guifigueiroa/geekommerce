package gui.commerce

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Mixin(ControllerUtil)
@Transactional(readOnly = true)
class ProductTypeController {

    static allowedMethods = [save: "POST"]

    def index(Integer max) {
      params.max = Math.min(max ?: 10, 100)
      respond ProductType.list(params)
    }

    def create() {
      respond new ProductType(params)
    }

    @Transactional
    def save(ProductType productType) {
      saveObj(productType, transactionStatus)
    }
}
