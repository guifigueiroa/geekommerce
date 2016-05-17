package gui.commerce

class ProductType {

    String name

    static constraints = {
      name nullable:true, blank: false, maxSize: 64, unique: true
    }
}
