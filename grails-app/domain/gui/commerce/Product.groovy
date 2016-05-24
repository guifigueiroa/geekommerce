package gui.commerce

class Product {

    String name
    double value
    Date dateCreated
    Date lastUpdated
    String url
    MysteryBoxItem boxItem

    static belongsTo = [type: ProductType]

    static constraints = {
      name nullable: false, blank: false, maxSize: 150
      value nullable: false, max: 10000.0d, scale: 2
      url nullable: false, blank: false, maxSize: 150
      boxItem nullable: true
    }
}
