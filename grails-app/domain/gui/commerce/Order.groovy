package gui.commerce

class Order {

    static hasMany = [items: OrderItem]

    static constraints = {

    }

    static mapping = {
      table "`order`"
    }
}
