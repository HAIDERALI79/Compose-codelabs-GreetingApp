package com.example.greeting

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.runtime.getValue
import androidx.compose.runtime.setValue
import androidx.compose.runtime.Composable
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.example.greeting.ui.theme.ExpandableCard
import com.example.greeting.ui.theme.GreetingTheme
import com.example.greeting.ui.theme.insparation

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            GreetingTheme {
                Surface(
                    modifier = Modifier.fillMaxSize()
                ) {
                    var onBoard by remember { mutableStateOf(false) }

                    if (onBoard)
                        OnScreenBoard(continueClick = { onBoard = false })
                    else Greeting(continueClick = { onBoard = true })
                }
            }
        }
    }
}

@Composable
fun OnScreenBoard(continueClick: () -> Unit) {
    Column(
        modifier = Modifier.fillMaxSize(),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Center

    ) {
        Text(
            "welcome to My App!",
            modifier = Modifier.padding(bottom = 25.dp),
            style = MaterialTheme.typography.h4, fontFamily = insparation,
            fontWeight = FontWeight.Bold
        )
        Button(
            onClick = continueClick
        ) {
            Text("Open Greeting names")
        }
    }
}

@Composable
private fun Greeting(continueClick: () -> Unit) {
    val names: List<String> = List(100) { "$it" }
    Column(
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        LazyColumn(
            modifier = Modifier.padding(top = 5.dp, start = 5.dp, end = 5.dp, bottom = 1.dp).weight(90f)
        ) {
            items(names) { name ->
                GreetingNames(name)

            }
        }

        Button(

            onClick = continueClick,
            modifier = Modifier.fillMaxSize().weight(10f).padding(top = 1.dp, start = 5.dp, end = 5.dp, bottom = 5.dp),
            shape = RoundedCornerShape(5.dp),
        )
        {
            Text("return to Main Menu")
        }
    }


}

//@OptIn(ExperimentalMaterialApi::class)
@Composable
private fun GreetingNames(name: String) {
    ExpandableCard(
        "this is header, ",
        "Compose Previews are great to check " +
                "quickly how a composable layout looks like",
        name
    )

}

@Preview(showBackground = true, widthDp = 320, heightDp = 580)
@Composable
fun DefaultPreview() {
    GreetingTheme {
        Greeting { }
    }
}


//  /*  var visibility by rememberSaveable { mutableStateOf(false) }
//    val extraPadding: Dp by animateDpAsState(
//        if (visibility) 48.dp else 0.dp, spring(stiffness = Spring.StiffnessMedium)
//    )
//
//    Card(
//
//        modifier = Modifier.fillMaxSize().padding(bottom = 4.dp).animateContentSize(
//            animationSpec = tween(
//                delayMillis = 400,
//                easing = LinearOutSlowInEasing
//            )
//        ).padding(8.dp),
//        backgroundColor = Color.Black,
//        shape = RoundedCornerShape(5.dp)
//    )
//    {
//        Row(
//            modifier = Modifier.padding(bottom = extraPadding)
//        ) {
//
//            Column(
//                modifier = Modifier.weight(1f).padding(8.dp),
//            ) {
//
//                Text("this is name")
//                Text(name, modifier = Modifier.padding(bottom = 7.dp))
//
//            }
//            IconButton(
//                onClick = { visibility = !visibility }
//            ) {
//                if (visibility) {
//                    Icon(
//                        painter = painterResource(R.drawable.ic_baseline_expand_less_24),
//                        contentDescription = "show more"
//                    )
//                } else Icon(
//                    painter = painterResource(R.drawable.ic_baseline_expand_more_24), contentDescription = "show less"
//                )
//                //   painter = painterResource(R.drawable.ic_baseline_expand_less_24),contentDescription = "show less")
//
//                //      if (visibility) Text("⌃") else Text("⌄")
//
//
//            }
//            if (visibility) {
//                Text(
//                    text = "this is text suppose in expandable area",
//                    //  fontSize = 16.dp,
//                    textAlign = TextAlign.Start,
//                    //     modifier = Modifier.fillMaxSize(),
//                    //    color = Color
//
//                )
//            }
//        }*/

//     var count by remember { mutableStateOf(0) }
//Card(
//            modifier = Modifier.fillMaxWidth().clickable { }.padding(15.dp),
//            elevation = 10.dp,
//            // onClick ={ count++},
//            //    contentColor = contentColorFor(backgroundColor = MaterialTheme.colors.primary)
//        ) {
//            Column(
//                modifier = Modifier.padding(15.dp)
//            ) {
//                Text("this is card and have count of $count")
//            }
//        }

// }
