package gui.commerce

class MysteryBoxEditionController {

    def create() {
      respond new MysteryBoxEdition(params)
    }
}
