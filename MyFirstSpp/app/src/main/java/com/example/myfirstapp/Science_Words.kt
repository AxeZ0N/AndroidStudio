import android.content.res.AssetManager
import android.content.res.Resources
import androidx.annotation.RawRes
import com.example.myfirstapp.R
import java.io.BufferedReader
import java.io.File
import java.util.*


class Science_Words constructor() {

    val res = Resources.getSystem()

    val prefixList = listOf("Curie",
        "Oppenheimer",
        "Sagan",
        "Feynman",
        "Einstein",
        "Boltzmann")

    val midfixList = listOf("Alpha",
            "Beta",
            "Gamma",
            "Excluding",
            "Vibration",
            "Square",
            "Opposite")

    val suffixList = listOf("Law",
            "Space",
            "Constant",
            "Enrichment",
            "Theory",
            "Diagram",
            "Ray")


    fun Resources.getRawTextFile(@RawRes id: Int) =
        openRawResource(id).bufferedReader().use { it.readLines() }


    fun generate(): String {
        val randPrefix = prefixList.get(Random().nextInt(prefixList.size))
        val randMidfix = midfixList.get(Random().nextInt(midfixList.size))
        val randSuffix = suffixList.get(Random().nextInt(suffixList.size))

        val hyphen =
            if ((Random().nextInt(3) + 1) % 3 == 0) "-" + prefixList.get(Random().nextInt(prefixList.size)) else ""

        return "$randPrefix$hyphen $randMidfix $randSuffix"

    }

}
