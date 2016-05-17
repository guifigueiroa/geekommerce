package gui.commerce

class OrderItem {

    Product product
    int quantity

    static belongsTo = [order: Order]

    static constraints = {
      product nullable: false
      quantity nullable: false, min: 1, max: 100
    }
}
