package gui.commerce

class Order {

    static hasMany = [items: OrderItem]
    Date dateCreated
    Date lastUpdated

    static constraints = {
      items validator: { val, obj ->
        if (!obj?.items || !obj?.items?.size()) {
          return 'order.validator.hasnoitems.error'
        }
      }
    }

    static mapping = {
      table "`order`"
    }
}
