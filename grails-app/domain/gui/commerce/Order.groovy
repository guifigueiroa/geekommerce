package gui.commerce

class Order {

    static hasMany = [items: OrderItem]
    Date dateCreated
    Date lastUpdated

    static constraints = {

    }

    static mapping = {
      table "`order`"
    }

    String toString(){
      id
    }
}
