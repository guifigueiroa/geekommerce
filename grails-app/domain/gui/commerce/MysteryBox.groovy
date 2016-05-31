package gui.commerce

class MysteryBox {

    String name
    String url
    String defaultProducts
    double minPrice
    boolean freight
    byte[] image

    static hasMany = [editions: MysteryBoxEdition]

    static constraints = {
      name nullable: false, blank: false, maxSize: 150, unique: true
      url nullable: false, blank: false, maxSize: 150, unique: true
      defaultProducts nullable: false, blank: false, maxSize: 400
      image nullable: false, maxSize: 2**20
    }

    static mapping = {
      editions fetch: 'join'
      editions sort: 'date', order: 'desc'
    }

    String toString(){
      name
    }
}
