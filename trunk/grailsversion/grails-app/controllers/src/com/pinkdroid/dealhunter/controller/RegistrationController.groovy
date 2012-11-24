package src.com.pinkdroid.dealhunter.controller

import src.com.pinkdroid.dealhunter.db.DatabaseHelper
import javax.annotation.PostConstruct
import src.com.pinkdroid.dealhunter.model.Business
import src.com.pinkdroid.dealhunter.model.Address

public class RegistrationController {

    static defaultAction = "register"

    DatabaseHelper dbHelper

    def register() {
        return
    }

    def handleRegister(Business user) {
        user.businessAddress = new Address(params.businessAddress)
        dbHelper.registerUser(user)
        session.username = user.username
        redirect(controller: "deal")
    }

    @PostConstruct public void init() {
        dbHelper = new DatabaseHelper()
    }

}
