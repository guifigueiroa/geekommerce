package gui.commerce

class GeekTagLib {
    static namespace = 'geek'
    static defaultEncodeAs = [taglib:'html', hasErrors:'raw']
    static encodeAsForTags = [messages: [taglib:'raw'], li: [taglib:'raw']]


    def messages = {attrs, body ->
      out << g.hasErrors() {
        out << "<div id=\"red\" role=\"status\">"
        out << g.eachError() {
          out << "<b>${g.message(error: it)}</b>"
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
      if(controllerName == "productType"){
        active = "menu.buy"
      }

      if(body().contains(g.message(code: active))){
        out << "<li class=\"active\">"
      } else {
        out << "<li>"
      }

      out << body()
      out << "</li>"
    }
}
