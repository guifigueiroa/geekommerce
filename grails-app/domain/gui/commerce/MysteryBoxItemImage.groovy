package gui.commerce

class Image {

    byte[] image

    static belongsTo = [item: MysteryBoxItem]

    static constraints = {
      image nullable: false, maxSize: 65536
    }
}
