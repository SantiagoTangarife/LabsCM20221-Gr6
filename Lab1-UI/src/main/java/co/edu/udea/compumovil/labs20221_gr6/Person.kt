package co.edu.udea.compumovil.labs20221_gr6

class Person(
    var firstName: String,
    var lastName: String,
    var gender: Gender? = null,
    var birthday: String,
    var educationLevel: EducationLevel? = null,
    var contactInfo: ContactInfo
) {
    enum class Gender {
        MALE,
        FEMALE,
        NO_BINARY
    }

    enum class EducationLevel {
        PRIMARY,
        SECONDARY,
        UNIVERSITARY,
        OTHER
    }
}
