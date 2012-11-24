package dealhunter

class ImageController {

    def index() {
        File file = new File(params.path)
        response.outputStream << file.bytes
    }
}
