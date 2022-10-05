import kotlin.math.pow
import kotlin.math.sqrt

class Lab6 {
    init {
        print("Please write your variables \na = ")
        val a = readln().toDouble()
        print("b = ")
        val b = readln().toDouble()
        print("c = ")
        val c = readln().toDouble()
        print("d = ")
        val d = readln().toDouble()
        print("x = ")
        val x = readln().toDouble()
        print("y = ")
        val y = readln().toDouble()
        println()

        //1. Обчисліть значення функції та виведіть його на екран.
        calculateValueOfFirstFunction(a, b, c, d)
        calculateValueOfSecondFunction(x)
        calculateValueOfThirdFunction(a, b, c, x)

        //2. Розв'яжіть рівняння та виведіть на екран результат.
        solveFirstEquation(y)
        solveSecondEquation(a, b, c, y)
        solveThirdEquation(a, c, y)
    }

    fun calculateValueOfFirstFunction(vararg numbers: Double) {
        var max: Double = numbers[0]

        for(number in numbers){
            max = kotlin.math.max(number, max)
        }

        println("y = MAX(a, b, c, d) \ny = $max\n")

    }

    fun calculateValueOfSecondFunction(x: Double){
        val solve = x.pow(4)
        println("y = x^4 :\ny = $solve\n")
    }

    fun calculateValueOfThirdFunction(a: Double, b: Double, c: Double, x: Double) {
        val solve = a * x.pow(2) + b * x + c
        println("y = ax^2 + bx + c :\ny = $solve\n")
    }


    fun solveFirstEquation(y: Double){
        val x1 = y.pow(1/4.toDouble())
        val x2 = -x1

        println("y = x^4 :\nx1 = $x1; x2 = $x2\n")
    }

    fun solveSecondEquation(a: Double, b: Double, _c: Double, y: Double) {
        println("y = ax^2 + bx + c :")
        val c = _c - y

        val discriminant: Double = discriminant(a, b, c)
        if(discriminant < 0){
            println("discriminant < 0\n")
            return
        }

        val sqrtOfDiscriminant = sqrt(discriminant);

        val x1 = (-b + sqrtOfDiscriminant) / (2 * a)
        val x2 = (-b - sqrtOfDiscriminant) / (2 * a)

        println("x1 = $x1; x2 = $x2\n")
    }

    fun discriminant(a: Double, b: Double, c: Double): Double {
        return b.pow(2) - 4 * a * c
    }

    fun solveThirdEquation(a: Double, c: Double, y: Double){
        val solution = (y - c) / a
        println("y = ax + c :\nx = $solution\n")
    }
}