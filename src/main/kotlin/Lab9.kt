import java.time.LocalDate
import java.time.temporal.ChronoUnit

/**
 * This class describe Student entity
 * @author Vladyslav Shchrebyna
 *
*/
class Student {
    private val name: String
    private val surname: String
    private val phoneNumber: String
    private val studentBilletNumber: String
    private val university: University
    private val birthday: LocalDate

    constructor(
        name: String,
        surname: String,
        phoneNumber: String,
        studentBilletNumber: String,
        university: University,
        birthday: LocalDate
    ) {
        this.name = name
        this.surname = surname
        this.phoneNumber = phoneNumber
        this.studentBilletNumber = studentBilletNumber
        this.university = university
        this.birthday = birthday
    }

    /**
     * This method showing main info about student
     */
    public fun showStudentBriefInfo() {
        println("${this.name} ${this.surname} has  phone ${this.phoneNumber} and ${calcAge()} years old")
    }

    /**
     * This method calculate age of student
     */
    private fun calcAge() : Long {
        val years = ChronoUnit.YEARS.between(birthday, LocalDate.now())

        return years
    }

    /**
     * This method show all info about student
     * @return string with info about student
     */
    override fun toString(): String {
        return "Student parameters: name='$name', surname='$surname', phoneNumber='$phoneNumber', \n" +
                "studentBilletNumber='$studentBilletNumber', university=$university, birthday=$birthday)"
    }
}


/**
 * This class describe University entity
 * @author Vladyslav Shchrebyna
 *
 */
class University {
    private val name: String
    private val city: String
    private val country: String

    constructor(name: String, city: String, country: String) {
        this.name = name
        this.city = city
        this.country = country
    }

    /**
     * This method show all info about university
     * @return string with info about university
     */
    override fun toString(): String {
        return "'$name in $city, $country'"
    }
}


fun main() {
    val university = University("НТУУ «КПІ»", "Kyiv", "Ukraine")
    val student = Student("Vlad",
        "Shcherbyna",
        "+380993344411",
        "aa333oo",
        university,
        LocalDate.of(2001, 7, 7)
    )

    println(student)
    println()
    student.showStudentBriefInfo()
}