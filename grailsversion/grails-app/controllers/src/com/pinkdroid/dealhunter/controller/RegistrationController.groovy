package src.com.pinkdroid.dealhunter.controller

import src.com.pinkdroid.dealhunter.db.DatabaseHelper
import javax.annotation.PostConstruct
import src.com.pinkdroid.dealhunter.model.User

public class RegistrationController {

    static defaultAction = "register"

	DatabaseHelper dbHelper

	def register() {
        return
	}

    def handleRegister(User user) {
        session.username = user.username

        //TODO : Call to DB Save

        redirect(controller: "dashboard")
    }

    @PostConstruct public void init() {
        dbHelper = new DatabaseHelper()
    }

}
