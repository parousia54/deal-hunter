package dealhunter

import org.springframework.dao.DataIntegrityViolationException
import src.com.pinkdroid.dealhunter.model.Deal
import src.com.pinkdroid.dealhunter.db.DatabaseHelper
import javax.annotation.PostConstruct

class DealController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    DatabaseHelper dbHelper

    @PostConstruct public void init() {
        dbHelper = new DatabaseHelper()
    }

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        List<Deal> dealList = dbHelper.getDealsforBusiness(session.username)
        [dealInstanceList: dealList]
    }

    def create() {
        [deal: new Deal()]
    }

    def save(Deal deal) {
        deal.username = session.username
        dbHelper.createDeal(deal)
        flash.message = message(code: 'default.created.message', args: [message(code: 'deal.label', default: 'Deal'), deal.id])
        redirect(action: "list")
    }

    def show() {
        Deal deal = dbHelper.getDeal(params.id)
        [deal: deal]
    }

    def edit() {
        //TODO : Fetch Deal and assign it to deal Instance
        def deal = null
        [deal: deal]
    }

    def update(Deal deal) {
        //TODO : Code to update

        redirect(action: "show", id: deal.id)
    }

    def delete() {
        //TODO : Delete call
        dbHelper.deleteDeal( params.id)
        flash.message = message(code: 'default.deleted.message', args: [message(code: 'deal.label', default: 'Deal'), params.id])
        redirect(action: "list")

    }
}
