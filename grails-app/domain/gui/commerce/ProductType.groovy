package gui.commerce

class ProductType {

    String name

    static hasMany = [products: Product]

    static constraints = {
      name nullable:false, blank: false, maxSize: 64, unique: true
    }

    String toString(){
      name
    }
}
