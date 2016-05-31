package gui.commerce

class GeekTagLib {
    static namespace = 'geek'
    static defaultEncodeAs = [taglib:'html', hasErrors:'raw']
    static encodeAsForTags = [messages: [taglib:'raw'],
                              li: [taglib:'raw'],
                              image: [taglib:'raw']]


    def messages = {attrs, body ->
      out << g.hasErrors() {
        out << "<div id=\"red\" role=\"status\">"
        out << g.eachError() {
          out << "<b>${g.message(error: it)}</b>"
          out << "<br />"
        }
        out << "</div>"
      }

      if(flash?.message){
        out << "<div id=\"yellow\" role=\"status\">"
        out << "<b>${flash.message}</b>"
        out << "</div>"
      }
    }

    def li = {attrs, body ->
      def active = "menu.home"
      switch(controllerName) {
        case ~/^mysteryBox.*/:
          active = "menu.mysteryBoxes"
          break
        case "user":
          active = "menu.login"
          break
        case "productType":
          active = "menu.buy"
          break
      }

      if(body().contains(g.message(code: active))){
        out << "<li class=\"active\">"
      } else {
        out << "<li>"
      }

      out << body()
      out << "</li>"
    }

    def image = {attrs, body ->
      if (attrs.obj?.image) {
        def link = g.createLink(action:'image',
                                id: attrs.obj.id)
        out << "<img src=\"${link}\" ${otherAttr(attrs,"obj")}/>"
      }
    }

    def otherAttr(attrs, except=[]) {
      def otherAttr = ""
      attrs.each { prop, val ->
        if(!(prop in except))
          otherAttr += "${prop}=\"${val}\" "
      }
      return otherAttr
    }
}
