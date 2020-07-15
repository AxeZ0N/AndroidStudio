import java.io.File
import java.util.*


class Science_Words constructor(val prefixFile: String, val midfixFile: String, val suffixFile: String) {
    val science_Words: String = ""

    fun generate(): String {

        val prefixList = File(prefixFile).useLines { it.toList() }
        val midfixList = File(midfixFile).useLines { it.toList() }
        val suffixList = File(suffixFile).useLines { it.toList() }

        val randPrefix = prefixList.get(Random().nextInt(prefixList.size))
        val randMidfix = midfixList.get(Random().nextInt(midfixList.size))
        val randSuffix = suffixList.get(Random().nextInt(suffixList.size))

        val hyphen = if ((Random().nextInt(3) + 1) % 3 == 0) "-" + prefixList.get(Random().nextInt(prefixList.size)) else ""

        return "$randPrefix$hyphen $randMidfix $randSuffix"

    }


}

fun main(args: Array<String>) {

    val sci: Science_Words = Science_Words(
        prefixFile = "C:\\Users\\reisb\\IdeaProjects\\Assignment6_Map\\Science Words\\prefix.txt",
        midfixFile = "C:\\Users\\reisb\\IdeaProjects\\Assignment6_Map\\Science Words\\midfix.txt",
        suffixFile = "C:\\Users\\reisb\\IdeaProjects\\Assignment6_Map\\Science Words\\suffix.txt"
    )

    val scienceWord = sci.generate()

    println(scienceWord)
}
