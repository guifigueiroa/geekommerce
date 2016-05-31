import gui.commerce.*

class BootStrap {

    def init = { servletContext ->
      User.findOrSaveByEmailAndPassword("gui@gmail.com", "abcd1234".encodeAsPassword())
    }
    def destroy = {
    }
}
