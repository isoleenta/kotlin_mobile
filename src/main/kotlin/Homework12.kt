class Homework12 {
    init {
        println("Please write your string: ")
        val str = readln() // "www, 4r34r,R44,344.ergerger,  Agergee3333,"

        /*
        1. Повертає кількість слів (в слові можуть зустрічатися:
        тільки літери;
        тільки символи;
        літери+символи+цифри;
        літери+символи;
        літери+цифри;
        символи(окрім крапки та коми)+цифри;
        якщо відділені пропусками символи цифри, або цифри та кома чи крапка, то даний ланцюжок є числом)
        **/
        firstFunction(str)

        //2. Повертає кількість чисел
        secondFunction(str)

        //3. Повертає стрічку в якій прибрані усі символи крім літер
        thirdFunction(str)

        //4. Повертає стрічку в якій множинні проміжки перетворені в один проміжок ("А  пр" = "А пр")
        fourthFunction(str)

        //5. Повертає стрічку яка містить лише слова, що починаються з великої літери ("А  пр" = "А")
        fifthFunction(str)
    }

    fun firstFunction(_str: String) {
        var str = _str
        str = str.replace("(([.,]+|\\s+)\\d+([.,]+|\\s+))".toRegex(), "")
        str = str.replace("(\\s+ [.,]+\\s+)".toRegex(), "")
        str = str.replace("(\\s+$|[.,]+$)".toRegex(), "")

        val words = str.trim()
        val numberOfInputWords = words.split("([.,]\\s+)|(\\s+|[.,])".toRegex()).size

        println("Count of words: $numberOfInputWords")
    }

    fun secondFunction(_str: String) {
        var str = _str
        str = str.replace("(\\s+ [.,]+\\s+)".toRegex(), "")
        str = str.replace("(\\s+$|[.,]+$)".toRegex(), "")

        val words = str.trim()
        val numberOfInputWords = words.split("(([.,]+|\\s+)\\d+([.,]+|\\s+))".toRegex()).size

        println("Count of numbers: $numberOfInputWords")
    }

    fun thirdFunction(_str: String) {
        var str = _str
        str = str.replace("[^a-zA-Z]+".toRegex(), "")

        println("String only with latin characters: $str")
    }

    fun fourthFunction(_str: String) {
        var str = _str
        str = str.replace("\\s+".toRegex(), " ")

        println("String with only one space between words: $str")
    }

    fun fifthFunction(str: String) {
        var line = "";
        val words = str.trim().split("([.,]\\s+)|(\\s+|[.,])".toRegex())
        for(word in words){
            if("^[A-Z]".toRegex().find(word)?.value != null)
                line += "$word "
        }
        println("String only with word that starts with uppercase latin characters: $line")
    }
}

fun main(args: Array<String>) {
    Homework12()
}