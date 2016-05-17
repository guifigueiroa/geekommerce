package gui.commerce

class Product {

    String name
    double value
    byte[] image
    Date dateCreated
    Date lastUpdated

    static belongsTo = [type: ProductType]

    static constraints = {
      name nullable: false, blank: false, maxSize: 150
      value nullable: false, max: 10000.0d, scale: 2
      type nullable: false
      image nullable: true, maxSize: 65536
    }
}
