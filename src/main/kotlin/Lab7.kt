class Lab7 {

    init {
        //Завдання 1
        print("Please write your amount of variables:")
        val amountOfVariables = readln().toInt()
        calc_and_print_fibonacci_numbers(amountOfVariables)

        //Завдання 2
        print("\nPlease write n: ")
        val n = readln().toInt()
        print(calc_factorial(n))

        //Завдання 3
        print("\n\nPlease write natural number: ")
        val naturalNumber = readln().toInt()
        print(calc_count_of_digits(naturalNumber))

    }

    fun fibonacci(num: Int): Int {
        if (num == 0 || num == 1)
            return num
        else
            return fibonacci(num - 1) + fibonacci(num - 2)
    }

    fun calc_and_print_fibonacci_numbers(amountOfVariables: Int){
        for(i in 0 until amountOfVariables) {
            print("$i - ${fibonacci(i)}\n")
        }
    }

    fun calc_factorial(n: Int, temp: Int = n): Int {
        if (n <= 0)
            return 0;

        if(temp == 1)
            return n
        else
            return calc_factorial(n*(temp-1), temp-1)
    }

    fun calc_count_of_digits(i: Int): Int {
        var counter = 1
        var subtractor = 10

        while(i - subtractor >= 0) {
            counter++
            subtractor *= 10
        }

        return counter
    }
}

fun main(args: Array<String>) {
    Lab7()
}