package gui.commerce

class MysteryBoxItem {

    String name

    static belongsTo = [edition: MysteryBoxEdition]
    static hasMany = [products: Product]

    static constraints = {
      name nullable: false, blank: false, maxSize: 150
    }
}
