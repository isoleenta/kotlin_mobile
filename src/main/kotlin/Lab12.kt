class Lab12 {
    init {
        firstExercise()
        secondAndThirdExercises()
        fourthExercise()
        fifthExercise()
    }

    fun firstExercise() {
        print("\nPlease write one character: ")
        val string = readln()

        val regex_num = """\d{1}""".toRegex()
        println("Є цифрою від 0 до 9?: "+ regex_num.matches(string))

        val regex_lower_case_character = """[a-z]{1}""".toRegex()
        println("Є малою латинською літерою?: "+ regex_lower_case_character.matches(string))

        val regex_word_character = """[a-zA-Z]{1}""".toRegex()
        print("Є латинською літерою (великою чи малою)?: ${regex_word_character.matches(string)} ")
        if(regex_word_character.matches(string)){
            if(regex_lower_case_character.matches(string))
                println("Є малою латинською літерою")
            else
                println("Є великою латинською літерою")
        }
    }

    fun secondAndThirdExercises() {
        print("\nPlease write number between 1 and 7: ")
        val weekDay = readln().toInt()
        println("Your choose: " + Weekd.find(weekDay))
        println("Next day is: " + Weekd.find(weekDay)?.nextDay())
        println()
    }

    fun fourthExercise(){
        print("This is simple calculator\nWrite first number: ")
        val firstNum = readln().toDouble()
        print("Write second number: ")
        val secondNum = readln().toDouble()
        print("Write an one of this operator +, -, *, /: ")
        val operator = readln().get(0)

        val result: Double
        when (operator) {
            '+' -> result = firstNum + secondNum
            '-' -> result = firstNum - secondNum
            '*' -> result = firstNum * secondNum
            '/' -> result = firstNum / secondNum
            else -> {
                System.out.printf("Written operator is not supported")
                return
            }
        }

        println("$firstNum $operator $secondNum = $result")
    }

    fun fifthExercise(){
        print("\nPlease write natural number greater than 3: ")
        val n = readln().toInt()

        var a_min = n
        var b_min = n
        for(a in 0..n) {
            for(b in 0..n) {
                if((5 * a - 2 * b) == n) {
                    if(a < a_min && b < b_min){
                        a_min = a
                        b_min = b
                    }
                }
            }
        }
        if (a_min != n && b_min != n)
            println("a = $a_min \nb = $b_min")
        else
            println("Error")
    }
}

enum class Weekd(val num: Int) {
    Monday(1){
        override fun nextDay() = Tuesday
    },
    Tuesday(2){
        override fun nextDay() = Wednesday
    },
    Wednesday(3){
        override fun nextDay() = Thursday
    },
    Thursday(4){
        override fun nextDay() = Friday
    },
    Friday(5){
        override fun nextDay() = Saturday
    },
    Saturday(6){
        override fun nextDay() = Sunday
    },
    Sunday(7){
        override fun nextDay() = Monday
    };

    abstract fun nextDay(): Weekd

    companion object {
        fun find(value: Int): Weekd? = Weekd.values().find { it.num == value }
    }
}

fun main(args: Array<String>) {
    Lab12()
}