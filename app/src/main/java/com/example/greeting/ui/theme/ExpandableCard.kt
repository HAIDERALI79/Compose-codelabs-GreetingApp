package com.example.greeting.ui.theme

import androidx.compose.animation.animateContentSize
import androidx.compose.animation.core.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ExpandLess
import androidx.compose.material.icons.filled.ExpandMore
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

@OptIn(ExperimentalMaterialApi::class)
@Composable
fun ExpandableCard(
    header: String,
    description: String,
    name: String
) {
    var visibility by rememberSaveable { mutableStateOf(false) }
    Card(

        modifier = Modifier.fillMaxSize()
            .padding(4.dp)
            .animateContentSize(
                animationSpec = spring(
                    dampingRatio = Spring.DampingRatioHighBouncy,
                    stiffness = Spring.StiffnessLow
                )

            ),
        backgroundColor = Color(221, 238, 253),
        shape = RoundedCornerShape(8.dp),
        onClick = { visibility = !visibility },
    )
    {
        Column(

        )
        {

            Row(
                modifier = Modifier.fillMaxWidth().padding(start = 20.dp, bottom = 20.dp, top = 20.dp),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceBetween
            )
            {
                Column(
                    modifier = Modifier.padding(10.dp)
                ) {
                    Text(header)
                    Text(name)

                }
                IconButton(
                    onClick = { visibility = !visibility }
                ) {
                    Icon(
                        imageVector = if (visibility) Icons.Filled.ExpandLess else Icons.Filled.ExpandMore,
                        contentDescription = if (visibility) "show less" else "show more"
                    )
                }
            }

            if (visibility) {
                Text(
                    text = description.repeat(4),
                    fontSize = 15.sp,
                    textAlign = TextAlign.Justify,
                    modifier = Modifier.fillMaxSize()
                        .padding(end = 25.dp),
                    //overflow = TextOverflow.Clip,
                    fontWeight = FontWeight.Bold,
                    maxLines = 5,
                    // lineHeight = 24.sp,

                )
            }
        }
    }
}


