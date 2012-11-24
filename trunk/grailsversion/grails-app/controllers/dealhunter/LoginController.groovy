package dealhunter

import src.com.pinkdroid.dealhunter.db.DatabaseHelper
import javax.annotation.PostConstruct
import src.com.pinkdroid.dealhunter.model.Business

class LoginController {

    DatabaseHelper dbHelper

    @PostConstruct public void init() {
        dbHelper = new DatabaseHelper()
    }

    def index() {

    }

    def handleLogin() {
        Business business = dbHelper.fetchBusiness(params.username, params.password)

        session.username = business.username
        redirect(controller: 'deal')
    }

    def logout() {
        session.username = null
        redirect(action: 'index')
    }
}
