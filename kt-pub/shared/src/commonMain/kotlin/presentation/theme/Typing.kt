import androidx.compose.material3.Typography
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight

@Composable
expect fun font(
    name: String = "Krub",
    res: String,
    weight: FontWeight,
    style: FontStyle = FontStyle.Normal
): Font


@Composable
fun SetUpFont(): Typography {
    val krub_bold = FontFamily(
        font(
            res = "krub_bold",
            weight = FontWeight.Bold,
        )
    )
    val krub_regular = FontFamily(
        font(
            res = "krub_regular",
            weight = FontWeight.Normal,
        )
    )
    val krub_italic = FontFamily(
        font(
            res = "krub_italic",
            weight = FontWeight.Medium
        )
    )
    val krub_semibold = FontFamily(
        font(
            res = "krub_semibold",
            weight = FontWeight.SemiBold
        )
    )
    val krub_medium = FontFamily(
        font(
            res = "krub_medium",
            weight = FontWeight.Medium
        )
    )
    val krub_light = FontFamily(
        font(
            res = "krub_light",
            weight = FontWeight.Light
        )
    )
    val krub_extralight = FontFamily(
        font(
            res = "krub_extralight",
            weight = FontWeight.ExtraLight
        )
    )


    val typography = Typography(
        bodyLarge = TextStyle(
            fontFamily = krub_medium
        ),
        bodyMedium = TextStyle(
            fontFamily = krub_regular
        ),
        bodySmall = TextStyle(
            fontFamily = krub_italic
        ),
        titleLarge = TextStyle(
            fontFamily = krub_bold
        ),
        titleMedium = TextStyle(
            fontFamily = krub_semibold
        ),
        titleSmall = TextStyle(
            fontFamily = krub_extralight
        ),
        labelLarge = TextStyle(
            fontFamily = krub_light
        )
    )

    return typography

}


