package gui.commerce

import static org.springframework.http.HttpStatus.*
import grails.transaction.Transactional

@Transactional(readOnly = true)
class ProductTypeController {

    def index(Integer max) {
      params.max = Math.min(max ?: 10, 100)
      respond ProductType.list(params)
    }
}
