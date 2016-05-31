package gui.commerce

class User {

    String email
    byte[] password

    static constraints = {
      email email: true, unique: true
      password blank: false, password: true
    }

    String toString(){
      "${email}"
    }
}
