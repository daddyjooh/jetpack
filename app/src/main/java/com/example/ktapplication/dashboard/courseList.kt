package com.example.ktapplication.dashboard


import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Search
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.compose.rememberNavController
import com.example.ktapplication.R
import com.example.ktapplication.model.Courses
import com.example.ktapplication.ui.theme.*

@ExperimentalMaterialApi
@Composable
fun CourseListView() {
    val navController = rememberNavController()

    var text by remember { mutableStateOf("") }
    val courseItemList = listOf(
        Courses(R.drawable.interior, "Interior Designs", "Tshs.10k/M", seashell),
        Courses(R.drawable.arts, "Fine Arts", "Tshs.10k/M", aliceBlue),
        Courses(R.drawable.ux, "UX Designs", "Tshs.10k/M", cultured),
        Courses(R.drawable.calligraph, "Calligraphy & Lettering", "Tshs.10k/M", azureishWhite),
        Courses(R.drawable.photographs, "Photographs", "Tshs.10k/M", seashell),
        Courses(R.drawable.animation, "3D Animations", "Tshs.10k/M", aliceBlue)
    )


    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        LazyColumn {
            item {
                Spacer(modifier = Modifier.height(24.dp))
                Row(
                    verticalAlignment = Alignment.Top,
                    horizontalArrangement = Arrangement.SpaceBetween,
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(horizontal = 12.dp)
                ) {
                    Image(
                        modifier = Modifier.size(16.dp),
                        painter = painterResource(id = R.drawable.left_arrow),
                        contentDescription = "Back Arrow Image"
                    )
                    Text(
                        text = "Here is our provided course list",
                        fontWeight = FontWeight.Bold,
                        fontSize = 16.sp
                    )
                    Image(
                        modifier = Modifier.size(24.dp),
                        painter = painterResource(id = R.drawable.filter),
                        contentDescription = "Filter Image",
                        contentScale = ContentScale.Crop
                    )
                }
                Spacer(modifier = Modifier.height(36.dp))
                TextField(
                    modifier = Modifier
                        .fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors(
                        backgroundColor = ghostWhite,
                        focusedIndicatorColor = Color.Transparent,
                        unfocusedIndicatorColor = Color.Transparent,
                    ),
                    value = text,
                    shape = RoundedCornerShape(32.dp),
                    singleLine = true,
                    onValueChange = { text = it },
                    placeholder = {
                        Text(
                            text = "Search here",
                            color = platinum
                        )
                    },
                    leadingIcon = {
                        Icon(
                            imageVector = Icons.Filled.Search,
                            contentDescription = stringResource(R.string.text_search_icon),
                            tint = lightSilver
                        )
                    },
                )
                Spacer(modifier = Modifier.height(24.dp))
            }
            items(courseItemList.windowed(2, 2, true)) { sublist ->
                Row(modifier = Modifier.fillMaxWidth()) {
                    sublist.forEach { item ->
                        Card(
                            modifier = Modifier
                                .fillParentMaxWidth(0.5f)
                                .padding(4.dp),
                            shape = RoundedCornerShape(16.dp),
                            backgroundColor = item.cardBg,
                            onClick = {
                            }
                        ) {
                            Column(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .padding(16.dp)
                            ) {
                                Box(
                                    modifier = Modifier
                                        .fillMaxWidth()
                                        .padding(4.dp),
                                    contentAlignment = Alignment.Center
                                ) {
                                    Image(
                                        modifier = Modifier
                                            .size(84.dp),
                                        painter = painterResource(item.image),
                                        contentDescription = "Vegetable",
                                    )
                                }
                                Spacer(modifier = Modifier.height(24.dp))
                                Row(
                                    verticalAlignment = Alignment.CenterVertically,
                                    horizontalArrangement = Arrangement.SpaceBetween,
                                    modifier = Modifier
                                        .fillMaxWidth()
                                ) {

                                    Column(
                                        modifier = Modifier
                                            .wrapContentHeight()
                                    ) {
                                        Text(
                                            text = item.name,
                                            fontSize = 13.sp,
                                            fontWeight = FontWeight.Bold,
                                            color = black,
                                        )
                                        Text(
                                            text = item.price,
                                            fontSize = 11.sp,
                                            color = black,
                                        )
                                    }
                                    Box(
                                        modifier = Modifier
                                            .clip(RoundedCornerShape(8.dp))
                                            .background(gold)
                                            .padding(4.dp),
                                        contentAlignment = Alignment.Center
                                    ) {
                                        Icon(
                                            modifier = Modifier.size(16.dp, 16.dp),
                                            imageVector = Icons.Default.Add,
                                            contentDescription = stringResource(R.string.text_add_icon),
                                            tint = white
                                        )
                                    }

                                }

                            }
                        }
                    }
                }

            }
        }

    }
}