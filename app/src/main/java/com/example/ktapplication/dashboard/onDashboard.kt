package com.example.ktapplication.OnBoarding

import androidx.compose.animation.Crossfade
import androidx.compose.foundation.*
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Favorite
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
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.example.ktapplication.R
import com.example.ktapplication.ui.theme.*

@Preview
@Composable
fun onDashboardView() {
    var itemList = listOf("Favourite", "Recommended", "Popular","Top Search")
    var text by remember { mutableStateOf("") }

    
    Surface(
        modifier = Modifier.fillMaxSize().padding(16.dp))
    {
        Column(
            modifier = Modifier.verticalScroll(rememberScrollState())
        ) {
            Spacer(modifier = Modifier.height(24.dp))

            Row(
                verticalAlignment = Alignment.Top,
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(horizontal = 12.dp)
            ) {

                Image(
                    painter = painterResource(id = R.drawable.menu),
                    contentDescription ="Menu Image" ,
                    modifier = Modifier.size(24.dp),

                )

                Image(
                    painter = painterResource(id = R.drawable.profile),
                    contentDescription = "User Profile",
                    contentScale = ContentScale.Crop,
                    modifier = Modifier.size(32.dp)
                )
            }

            Spacer(modifier = Modifier.height(36.dp))
            Text(
                text = "Become an expert through learning!",
                fontWeight = FontWeight.Bold,
                fontSize = 20.sp,
                color = MaterialTheme.colors.onBackground
            )
            Spacer(modifier = Modifier.height(16.dp))
            Text(
                text = "What do you want to learn today?",
                textAlign = TextAlign.Center,
                color = MaterialTheme.colors.onBackground,
                fontSize = 14.sp
            )
            Spacer(modifier = Modifier.height(16.dp))
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
                        color = lightSilver
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
            LazyRow(modifier = Modifier.fillMaxWidth()) {
                items(itemList.size) { item ->
                    Box(
                        modifier = Modifier
                            .border(
                                color = if (item == 0) gold else Color.Transparent,
                                width = 2.dp,
                                shape = RoundedCornerShape(24.dp)
                            )
                    ) {
                        Text(
                            modifier = Modifier
                                .padding(
                                    start = 16.dp,
                                    end = 16.dp,
                                    top = 8.dp,
                                    bottom = 8.dp
                                ),
                            text = itemList[item],
                            color = if (item == 0) gold else Color.LightGray
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight()
            ) {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f)
                        .wrapContentHeight()
                        .clip(RoundedCornerShape(16.dp))
                        .background(navajoWhite)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(white)
                                    .padding(4.dp),
                            ) {
                                Icon(
                                    modifier = Modifier.size(16.dp, 16.dp),
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = stringResource(R.string.text_heart_icon),
                                    tint = Color.Red
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(100.dp),
                                painter = painterResource(R.drawable.interior),
                                contentDescription = "Interior design",
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))
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
                                    text = "Interior Design",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = black,
                                )
                                Text(
                                    text = "Tshs.10000/Month",
                                    fontSize = 12.sp,
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
                                    modifier = Modifier.size(20.dp, 20.dp),
                                    imageVector = Icons.Default.Add,
                                    contentDescription = stringResource(R.string.text_add_icon),
                                    tint = white
                                )
                            }

                        }

                    }
                }
                Spacer(modifier = Modifier.width(16.dp))
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .weight(0.5f)
                        .wrapContentHeight()
                        .clip(RoundedCornerShape(16.dp))
                        .background(water)
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(16.dp)
                    ) {
                        Row(
                            horizontalArrangement = Arrangement.End,
                            verticalAlignment = Alignment.CenterVertically,
                            modifier = Modifier
                                .fillMaxWidth()
                        ) {
                            Box(
                                modifier = Modifier
                                    .clip(CircleShape)
                                    .background(white)
                                    .padding(4.dp),
                            ) {
                                Icon(
                                    modifier = Modifier.size(16.dp, 16.dp),
                                    imageVector = Icons.Default.Favorite,
                                    contentDescription = stringResource(R.string.text_heart_icon),
                                    tint = Color.Red
                                )
                            }
                        }
                        Spacer(modifier = Modifier.height(8.dp))
                        Box(
                            modifier = Modifier.fillMaxWidth(),
                            contentAlignment = Alignment.Center
                        ) {
                            Image(
                                modifier = Modifier
                                    .size(100.dp),
                                painter = painterResource(R.drawable.arts),
                                contentDescription = "Arts",
                            )
                        }

                        Spacer(modifier = Modifier.height(16.dp))
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
                                    text = "Fine Arts",
                                    fontSize = 14.sp,
                                    fontWeight = FontWeight.Bold,
                                    color = black,
                                )
                                Text(
                                    text = "Tshs.10000/Month",
                                    fontSize = 12.sp,
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
                                    modifier = Modifier.size(20.dp, 20.dp),
                                    imageVector = Icons.Default.Add,
                                    contentDescription = stringResource(R.string.text_add_icon),
                                    tint = white
                                )
                            }

                        }

                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
            Row(
                horizontalArrangement = Arrangement.SpaceBetween,
                modifier = Modifier
                    .fillMaxWidth()
            ) {
                Text(
                    text = "What are you looking for",
                    fontWeight = FontWeight.Bold,
                    fontSize = 16.sp,
                    color = MaterialTheme.colors.onBackground,
                )
                Text(
                    text = "See more",
                    fontSize = 14.sp,
                    color = gold,
                )
            }
            Spacer(modifier = Modifier.height(24.dp))
            Card(
                modifier = Modifier
                    .fillMaxWidth()
                    .wrapContentHeight(),
                shape = RoundedCornerShape(16.dp)
            ) {
                Row(
                    horizontalArrangement = Arrangement.Center,
                    verticalAlignment = Alignment.CenterVertically,
                    modifier = Modifier
                        .fillMaxWidth()
                        .wrapContentHeight()
                        .padding(8.dp)
                ) {
                    Box(
                        modifier = Modifier
                            .weight(0.2f)
                            .height(64.dp)
                            .clip(RoundedCornerShape(12.dp))
                            .background(lightBlue),
                        contentAlignment = Alignment.Center
                    ) {
                        Image(
                            modifier = Modifier.padding(8.dp),
                            painter = painterResource(R.drawable.ux),
                            contentDescription = "Ux",
                        )
                    }
                    Spacer(modifier = Modifier.width(8.dp))
                    Column(
                        verticalArrangement = Arrangement.SpaceEvenly,
                        horizontalAlignment = Alignment.Start,
                        modifier = Modifier
                            .weight(0.55f)
                            .wrapContentHeight()
                    ) {
                        Text(
                            text = "UX Design",
                            fontWeight = FontWeight.Bold,
                            fontSize = 14.sp,
                            color = MaterialTheme.colors.onBackground,
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Become Competent in UX design",
                            fontSize = 12.sp,
                            color = MaterialTheme.colors.onBackground,
                        )
                    }
                    Column(
                        verticalArrangement = Arrangement.Center,
                        horizontalAlignment = Alignment.CenterHorizontally,
                        modifier = Modifier
                            .weight(0.25f)
                            .wrapContentHeight()
                    ) {
                        Text(
                            text = "Tshs.19000/Month",
                            fontWeight = FontWeight.Bold,
                            fontSize = 12.sp,
                            color = gold,
                        )
                     
                    }
                }
            }
            Spacer(modifier = Modifier.height(24.dp))
        }

    }
    }