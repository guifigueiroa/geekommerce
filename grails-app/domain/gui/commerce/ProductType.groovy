package gui.commerce

class ProductType {

    String name
    Date dateCreated
    Date lastUpdated

    static hasMany = [products: Product]

    static constraints = {
      name nullable:false, blank: false, maxSize: 64, unique: true
    }
}
