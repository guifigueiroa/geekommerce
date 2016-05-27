package gui.commerce

class MysteryBoxEdition {

    Date date
    String theme
    byte[] image

    static hasMany = [items: MysteryBoxItem]
    static belongsTo = [box: MysteryBox]

    static constraints = {
      date nullable: false, blank: false
      theme nullable: false, blank: false, maxSize: 150
      image nullable: false, maxSize: 2**20
    }

    static mapping = {
      items fetch: 'join'
    }
}
