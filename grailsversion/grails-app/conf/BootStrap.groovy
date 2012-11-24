import src.com.pinkdroid.dealhunter.model.Deal

class BootStrap {

    def init = { servletContext ->
        Deal.metaClass.validate = { }
    }
    def destroy = {
    }
}
