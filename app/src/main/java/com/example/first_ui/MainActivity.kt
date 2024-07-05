package com.example.first_ui

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.grid.GridCells
import androidx.compose.foundation.lazy.grid.LazyVerticalGrid
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Check
import androidx.compose.material3.HorizontalDivider
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Slider
import androidx.compose.material3.Switch
import androidx.compose.material3.SwitchDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableFloatStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Color.Companion.Black
import androidx.compose.ui.graphics.Color.Companion.Green
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.core.app.NotificationCompat.Style
import com.example.first_ui.ui.theme.Beige1
import com.example.first_ui.ui.theme.BlueViolet1
import com.example.first_ui.ui.theme.ButtonGreen
import com.example.first_ui.ui.theme.DarkerButtonGreen
import com.example.first_ui.ui.theme.DeepGreen
import com.example.first_ui.ui.theme.First_UITheme
import com.example.first_ui.ui.theme.LightGreen1
import com.example.first_ui.ui.theme.OrangeYellow1
import com.example.first_ui.ui.theme.TextWhite
import com.example.first_ui.ui.theme.skyblue1

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        //enableEdgeToEdge()
        setContent {
            First_UITheme {
                Homescreen()

            }
        }
    }
}
@Composable
fun Homescreen(){
    Box(modifier = Modifier
        .fillMaxSize()
        .background(color = DeepGreen)) {
        Column {
            Greeting()
            ChipSection(
                chips = listOf(
                    "Python",
                    "Data Science",
                    "Algorithm",
                    "Machine Learning",
                    "Deep Learning"
                )
            )
            SuggetionSection()
            HorizontalDivider(
                modifier = Modifier.padding(vertical = 3.dp),
                thickness = 1.dp,
                color = Color.DarkGray
            )
            CourseSection()
            Card1()
            SliderMinimalExample()
            SwitchWithIconExample()

        }
    }
}
@Composable
fun Greeting(
    name: String = "Geeks"
) {
    // here we just arrange the views
    Row(
        horizontalArrangement = Arrangement.SpaceBetween,
        verticalAlignment = Alignment.CenterVertically,
        modifier = Modifier
            .fillMaxWidth()
            .padding(15.dp)
    ) {
        Column(
            verticalArrangement = Arrangement.Center
        ) {
            // heading text view
            Text(
                text = "Good morning, $name",
                style = MaterialTheme.typography.bodySmall
            )
            Text(
                text = "Wish you have a good day!",
                style = MaterialTheme.typography.bodyLarge
            )
        }
        // search icon
        Icon(
            painter = painterResource(id = R.drawable.ic_search),
            contentDescription = "Search",
            tint = Color.White,
            modifier = Modifier.size(24.dp)
        )
    }
}
@Composable
fun ChipSection(
    chips: List<String>
) {
    var selectedChipIndex by remember {
        mutableStateOf(0)
    }
    LazyRow {
        items(chips.size) {
            Box(
                contentAlignment = Alignment.Center,
                modifier = Modifier
                    .padding(start = 10.dp, top = 15.dp, bottom = 15.dp)
                    .clickable {
                        selectedChipIndex = it
                    }
                    .clip(RoundedCornerShape(5.dp))
                    .background(
                        if (selectedChipIndex == it) ButtonGreen
                        else DarkerButtonGreen
                    )
                    .padding(15.dp)
            ) {
                Text(text = chips[it], color = TextWhite)
            }
        }
    }
}
@Composable
fun SuggetionSection(color : Color = ButtonGreen) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween,
        modifier = Modifier
            .padding(15.dp)
            .clip(RoundedCornerShape(10.dp))
            .fillMaxWidth()
            .background(color = color)
            .padding(horizontal = 10.dp, vertical = 25.dp)
    ) {
        Column {
            Text(text = "Problem of the day", style = MaterialTheme.typography.bodyMedium)
            Text(
                text = "Vertical Width of a Binary Tree",
                style = MaterialTheme.typography.bodyLarge,
                color = Color.White
            )

        }
        Box(
            contentAlignment = Alignment.Center,
            modifier = Modifier
                .clip(RoundedCornerShape(10.dp))
                .background(color = Black)
                .padding(horizontal = 25.dp, vertical = 15.dp)

        ) {
            Text(text = "Solve Problem")

        }
    }
}
@Composable
fun CourseSection() {
    Row(modifier = Modifier.fillMaxWidth()) {
        Text(
            text = "courses",
            style = MaterialTheme.typography.bodySmall,
            modifier = Modifier.padding(15.dp)
        )

    }
}
@Preview
@Composable
fun SliderMinimalExample() {
    var sliderPosition by remember { mutableFloatStateOf(0f) }
    Row {
        Slider(
            value = sliderPosition,
            onValueChange = { sliderPosition = it }
        )
        Text(text = sliderPosition.toString())
    }
}
@Composable
fun SwitchWithIconExample() {
    var checked by remember { mutableStateOf(true) }

    Switch(
        checked = checked,
        onCheckedChange = {
            checked = it
        },
        thumbContent = if (checked) {
            {
                Icon(
                    imageVector = Icons.Filled.Check,
                    contentDescription = null,
                    modifier = Modifier.size(SwitchDefaults.IconSize),
                )
            }
        } else {
            null
        }
    )
}
@Composable
fun Card1(color : Color = skyblue1,
          color2: Color = Black) {


    Card(colors = CardDefaults.cardColors(containerColor = color, contentColor = color2) ,
        modifier = Modifier
            .size(width = 200.dp, height = 200.dp)
            .padding(16.dp)
    ) {
        Text(
            text = "geek of the year",
            modifier = Modifier
                .padding(horizontal = 15.dp, vertical = 15.dp).fillMaxSize(),
            textAlign = TextAlign.Center,
        )
    }
}




@Preview(showBackground = true)
@Composable
fun HomescreenPreview() {
    First_UITheme {
        Homescreen()
    }
}
