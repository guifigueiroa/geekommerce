package gui.commerce

class ProductImage {

    byte[] image

    static belongsTo = [product: Product]

    static constraints = {
      image nullable: false, maxSize: 2**20
    }
}
