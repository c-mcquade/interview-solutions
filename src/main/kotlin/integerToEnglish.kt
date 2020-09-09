internal class IntegerToEnglish {
    fun one(num: Int): String {
        when (num) {
            1 -> return "One"
            2 -> return "Two"
            3 -> return "Three"
            4 -> return "Four"
            5 -> return "Five"
            6 -> return "Six"
            7 -> return "Seven"
            8 -> return "Eight"
            9 -> return "Nine"
        }
        return ""
    }

    fun twoLessThan20(num: Int): String {
        when (num) {
            10 -> return "Ten"
            11 -> return "Eleven"
            12 -> return "Twelve"
            13 -> return "Thirteen"
            14 -> return "Fourteen"
            15 -> return "Fifteen"
            16 -> return "Sixteen"
            17 -> return "Seventeen"
            18 -> return "Eighteen"
            19 -> return "Nineteen"
        }
        return ""
    }

    fun ten(num: Int): String {
        when (num) {
            2 -> return "Twenty"
            3 -> return "Thirty"
            4 -> return "Forty"
            5 -> return "Fifty"
            6 -> return "Sixty"
            7 -> return "Seventy"
            8 -> return "Eighty"
            9 -> return "Ninety"
        }
        return ""
    }

    fun two(num: Int): String {
        return if (num == 0) "" else if (num < 10) one(num) else if (num < 20) twoLessThan20(num) else {
            val tenner = num / 10
            val rest = num - tenner * 10
            if (rest != 0) ten(tenner) + " " + one(rest) else ten(tenner)
        }
    }

    fun three(num: Int): String {
        val hundred = num / 100
        val rest = num - hundred * 100
        var res = ""
        if (hundred * rest != 0) res = one(hundred) + " Hundred " + two(rest) else if (hundred == 0 && rest != 0) res =
            two(rest) else if (hundred != 0 && rest == 0) res = one(hundred) + " Hundred"
        return res
    }

    fun numberToWords(num: Int): String {
        if (num == 0) return "Zero"
        val billion = num / 1000000000
        val million = (num - billion * 1000000000) / 1000000
        val thousand = (num - billion * 1000000000 - million * 1000000) / 1000
        val rest = num - billion * 1000000000 - million * 1000000 - thousand * 1000
        var result = ""
        if (billion != 0) result = three(billion) + " Billion"
        if (million != 0) {
            if (!result.isEmpty()) result += " "
            result += three(million) + " Million"
        }
        if (thousand != 0) {
            if (!result.isEmpty()) result += " "
            result += three(thousand) + " Thousand"
        }
        if (rest != 0) {
            if (!result.isEmpty()) result += " "
            result += three(rest)
        }
        return result
    }
}