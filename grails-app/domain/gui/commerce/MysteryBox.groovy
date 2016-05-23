package gui.commerce

class MysteryBox {

    String name
    String url
    String defaultProducts
    double minPrice
    boolean freight

    static hasMany = [items: MysteryBoxItem]

    static constraints = {
      name nullable: false, blank: false, maxSize: 150, unique: true
      url nullable: false, blank: false, maxSize: 150, unique: true
    }
}
