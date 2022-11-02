import java.io.File

class Homework14 {
    init {
        // 1. Написати програму, що замінює підстрічку в файлі заданою стрічкою
        print("Please write string that you would like change: ")
        val str1 = readln()
        print("Please write string that replaces your previous string: ")
        val str2 = readln()
        firstFunction("src/main/kotlin/text_file.txt", str1, str2)

        //2. Написати програму, що копіює зміст текстового файлу в інший з розширення ".bak". Назва файлу вводиться користувачем.
        print("Please write name of file that you would like to copy: ")
        val filename1 = readln()
        print("Please write name of copied file: ")
        val filename2 = readln()
        secondFunction(filename1, filename2)

        //3. Написати програму, що відкриває файл на читання і формує два інших файли.
        //   Перший файл формується з непарних стрічок початкового файлу, а інший з парних.
        print("Please write name of file that you would like to copy: ")
        val filename3 = readln()
        thirdFunction(filename1)

        //4. Здійснити шифрування файлу використовуючи зсув символів.
        print("Please write name of file that you would like to encode: ")
        val filename4 = readln()
        fourthFunction(filename4)

        //5. Здійснити розшифрування файлу зашифрованого вище
        fifthFunction(filename4)
    }



    fun firstFunction(fileName: String, str1: String, str2: String) {
        var str = File(fileName).readText(Charsets.UTF_8)
        str = str.replace(str1, str2)
        File(fileName).writeText(str)
    }

    fun secondFunction(filename1: String, filename2: String) {
        var str = File("src/main/kotlin/$filename1.txt").readText(Charsets.UTF_8)
        File("src/main/kotlin/$filename2.bat").writeText(str)
    }

    fun thirdFunction(filename1: String) {
        var count = 1
        var str_odd  = ""
        var str_even  = ""
        var str = File("src/main/kotlin/$filename1.txt").useLines { lines ->
            for (it in lines) {
                if(count % 2 == 0)
                    str_odd += it + "\n"
                else
                    str_even += it + "\n"
                count++
            }
        }
        File("src/main/kotlin/$filename1" + "_odd.txt").writeText(str_odd)
        File("src/main/kotlin/$filename1" + "_even.txt").writeText(str_even)
    }

    fun fourthFunction(filename: String) {
        var str = File("src/main/kotlin/$filename.txt").readText(Charsets.UTF_8)
        var str2 = ""
        str.forEach { c: Char -> str2 += Char(c.code + 5)}
        File("src/main/kotlin/$filename.txt").writeText(str2)
    }

    fun fifthFunction(filename: String) {
        var str = File("src/main/kotlin/$filename.txt").readText(Charsets.UTF_8)
        var str2 = ""
        str.forEach { c: Char -> str2 += Char(c.code - 5)}
        File("src/main/kotlin/$filename.txt").writeText(str2)
    }
}

fun main(args: Array<String>) {
    Homework14()
}