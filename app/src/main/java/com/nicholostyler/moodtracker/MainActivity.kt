package com.nicholostyler.moodtracker

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.horizontalScroll
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.rememberScrollState
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.OutlinedCard
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Devices
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.nicholostyler.moodtracker.ui.theme.MoodTrackerTheme

class MainActivity : ComponentActivity()
{
    override fun onCreate(savedInstanceState: Bundle?)
    {
        super.onCreate(savedInstanceState)
        enableEdgeToEdge()
        setContent {
            MoodTrackerTheme {
                Scaffold(modifier = Modifier.fillMaxSize()) { innerPadding ->
                    Greeting(
                        name = "Android",
                        modifier = Modifier.padding(innerPadding)
                    )
                }
            }
        }
    }
}

@Composable
fun DashboardQuickAddMood()
{
    Column()
    {
        Text(text = "Quick Add Mood", textAlign = TextAlign.Center, modifier = Modifier.fillMaxWidth())
    }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
    )
    {
        QuickAddMoodCard(mood = "Awful")
        QuickAddMoodCard(mood = "Bad")
        QuickAddMoodCard(mood = "Ok")
        QuickAddMoodCard(mood = "Good")
        QuickAddMoodCard(mood = "Great")
    }
}

@Composable
fun QuickAddMoodCard(mood: String)
{
    Card(modifier = Modifier
        .size(height = 100.dp, width = 70.dp)
        .padding(start = 8.dp, top = 8.dp)
    )
    {
        Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
            Text(text = mood, Modifier.padding(bottom = 8.dp))
        }
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun WeekSummaryCards(dayofWeek: String, mood: String)
{
    OutlinedCard(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .size(height = 100.dp, width = 100.dp)
            .padding(start = 8.dp, top = 8.dp)
    ) {
        Text(text = mood)
        Text(text = dayofWeek)
    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun DashboardWeekSummary()
{
    Column(){
        Text(text = "Week of Aug 28")
        Row (modifier = Modifier
            .fillMaxWidth()
            .horizontalScroll(rememberScrollState())
        ) {
            WeekSummaryCards(dayofWeek = "Monday", mood = "Happy")
            WeekSummaryCards(dayofWeek = "Tuesday", mood = "Awful")
            WeekSummaryCards(dayofWeek = "Wednesday", mood = "Bad")
            WeekSummaryCards(dayofWeek = "Thursday", mood = "Good")
            WeekSummaryCards(dayofWeek = "Friday", mood = "Great")
            WeekSummaryCards(dayofWeek = "Saturday", mood = "Happy")
            WeekSummaryCards(dayofWeek = "Sunday", mood = "Happy")
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun ListOfEntries()
{
    LazyColumn {
        items(10) { index ->
            EntryCard(date = "Feb 5", title = "Snow Day", description =  "A snowy day today.")
        }

    }
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EntryCard(date: String, title: String, description: String)
{
    Card(
        onClick = { /*TODO*/ },
        modifier = Modifier
            .height(height = 100.dp)
            .fillMaxWidth()
            .padding(start = 8.dp, top = 8.dp)
    ) {
        Text(text = date)
        Text(text = title)
        Text(text = description)
    }
}


@Composable
fun DashboardPane()
{
    // Main page of the app
    Column(modifier = Modifier.fillMaxSize()){
        Text(text = "Good Morning,")
        Text(text = "Nicholos Tyler")
        DashboardQuickAddMood()
        DashboardWeekSummary()
        Text("Recent Entries")
        ListOfEntries()
    }
}

@Composable
fun Greeting(name: String, modifier: Modifier = Modifier)
{
    Text(
        text = "Hello $name!",
        modifier = modifier
    )
}

@Preview(showBackground = true, device = Devices.PIXEL_4)
@Composable
fun GreetingPreview()
{
    MoodTrackerTheme {
        DashboardPane()
    }
}