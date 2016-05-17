package gui.commerce

class Product {

    String name
    double value
    byte[] image

    static belongsTo = [type: ProductType]

    static constraints = {
      name nullable: false, blank: false, maxSize: 150
      type nullable: false
      image nullable: true, maxSize: 65536
    }
}
