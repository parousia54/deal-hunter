package dealhunter

import org.springframework.dao.DataIntegrityViolationException
import src.com.pinkdroid.dealhunter.model.Deal

class DealController {

    static allowedMethods = [save: "POST", update: "POST", delete: "POST"]

    def index() {
        redirect(action: "list", params: params)
    }

    def list() {
        params.max = Math.min(params.max ? params.int('max') : 10, 100)
        def dealList = []
        def dealTotal = 0
        //TODO : Replace Deal.list() with mongo call, total count for pagination
        [dealInstanceList: dealList, dealInstanceTotal: dealTotal]
    }

    def create() {
        [dealInstance: new Deal(params)]
    }

    def save(Deal deal) {
        //TODO : Save call
		flash.message = message(code: 'default.created.message', args: [message(code: 'deal.label', default: 'Deal'), deal.id])
        redirect(action: "show", id: deal.id)
    }

    def show() {
        //TODO : Fetch Deal
        def deal = null
        [dealInstance: deal]
    }

    def edit() {
       //TODO : Fetch Deal and assign it to deal Instance
        def deal = null
        [dealInstance: deal]
    }

    def update(Deal deal) {
        //TODO : Code to update

        redirect(action: "show", id: deal.id)
    }

    def delete(Deal deal) {
            //TODO : Delete call
			flash.message = message(code: 'default.deleted.message', args: [message(code: 'deal.label', default: 'Deal'), params.id])
            redirect(action: "list")

    }
}
