class Authorization {
  def checkUser() {
    if(!session.user) {
      // i.e. user not logged in
      redirect(controller:'user',action:'login')
      return false
    }
  }
}
