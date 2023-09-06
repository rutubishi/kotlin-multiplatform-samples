package presentation.components

import androidx.compose.foundation.layout.padding
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.AnnotatedString
import androidx.compose.ui.text.font.FontWeight
import presentation.theme.half_padding

@Composable
fun AppHeader(
    header: String = "",
    annotatedHeader: AnnotatedString? =  null
) {
    val annotated = !annotatedHeader.isNullOrBlank()

    if(annotated){
        Text(
            text = annotatedHeader!!,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(vertical = half_padding)
        )
    }else{
        Text(
            text = header,
            style = MaterialTheme.typography.bodyLarge,
            fontWeight = FontWeight.Bold,
            modifier = Modifier
                .padding(vertical = half_padding)
        )
    }


}