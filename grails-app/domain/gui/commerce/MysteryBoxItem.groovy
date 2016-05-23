package gui.commerce

class MysteryBoxItem {

    String name

    static belongsTo = [box: MysteryBox]
    static hasMany = [products: Product]

    static constraints = {
      name nullable: false, blank: false, maxSize: 150, unique: true
    }
}
