package com.example.ktapplication.OnBoarding

import androidx.compose.animation.core.Spring
import androidx.compose.animation.core.animateDpAsState
import androidx.compose.animation.core.spring
import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.*
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.outlined.KeyboardArrowLeft
import androidx.compose.material.icons.outlined.KeyboardArrowRight
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import com.example.ktapplication.navigation.Screen
import com.example.ktapplication.ui.theme.streamColor
import com.google.accompanist.pager.ExperimentalPagerApi
import com.google.accompanist.pager.HorizontalPager
import com.google.accompanist.pager.rememberPagerState
import kotlinx.coroutines.launch

@ExperimentalPagerApi
@Composable
fun OnBoarding(

) {
    var pageCount by remember { mutableStateOf(0) }
    val scope = rememberCoroutineScope()



    Column(Modifier.fillMaxSize())
    {
        val navController = rememberNavController()
        TopSection(navController = rememberNavController())
         val items = OnBoardingItem.get()
         val state= rememberPagerState()
        HorizontalPager(count = 3,
            modifier = Modifier
                .fillMaxSize()
                .weight(0.8f))
        {
            page ->

            OnBoardingItem(items[page])
        }

        BottomSection(size = items.size, index = state.currentPage) {
            if (state.currentPage+1 <items.size)
                scope.launch {
                    state.scrollToPage(state.currentPage+1)

                }

        }
    }
}


@Composable
fun TopSection(navController: NavController) {

    Box(modifier = Modifier
        .fillMaxWidth()
        .padding(12.dp))
    {
        IconButton(onClick = {  }, modifier = Modifier.align(Alignment.CenterStart)) {
            Icon(Icons.Outlined.KeyboardArrowLeft,null)
            
        }


        //Skip button
        TextButton(
            onClick = {
                      navController.navigate(route = Screen.Dashboard.route)
            },
            modifier = Modifier.align(Alignment.CenterEnd)
        )
        {
            Text("Skip",
                color = streamColor,
                fontSize = 25.sp,
                fontWeight = FontWeight.Bold,
            )
        }
    }
}

@Composable
fun BoxScope.Indicators(size:Int,index:Int) {
    Row(
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(12.dp),
        modifier = Modifier.align(Alignment.CenterStart)
    ) {
        repeat(size){
            Indicator(isSelected = it == index)
        }
    }
    
}
@Composable
fun Indicator(isSelected: Boolean) {

    val width = animateDpAsState(
        targetValue = if (isSelected) 25.dp else 10.dp,
        animationSpec = spring(dampingRatio = Spring.DampingRatioHighBouncy)
    )

    Box(modifier = Modifier
        .height(10.dp)
        .width(width.value)
        .clip(CircleShape)
        .background(
            if (isSelected) streamColor
            else MaterialTheme.colors.onBackground.copy(alpha = 0.5f)
        )
        .size(if (isSelected) 25.dp else 10.dp),){

    }
}



@Composable
fun BottomSection(
    size : Int,
    index : Int,
    onNextClicked:()->Unit
) {
    Box(
        modifier = Modifier
            .fillMaxWidth()
            .padding(12.dp)
    ){
        //indicators
        Indicators(size = size, index = index)

        //NextBtn
        FloatingActionButton(onClick = onNextClicked,
            modifier = Modifier.align(Alignment.CenterEnd),
            backgroundColor = streamColor,
            contentColor = MaterialTheme.colors.onPrimary)
        {
            Icon(Icons.Outlined.KeyboardArrowRight,null)
        }
    }
}


@Composable
fun OnBoardingItem(
    item: OnBoardingItem
) {
    Column(
        horizontalAlignment = Alignment.CenterHorizontally,
        modifier = Modifier
            .fillMaxSize()
            .padding(top = 60.dp))
    {
        Image(painter = painterResource(item.image), contentDescription = null)
        Text(
            text = stringResource(item.title),
            fontSize = 30.sp,
            color = MaterialTheme.colors.onBackground,
            fontWeight = FontWeight.Bold,
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top=50.dp, end = 25.dp, start = 25.dp)
        )

        Text(
            text = stringResource(item.text),
            color = MaterialTheme.colors.onBackground.copy(alpha = 0.8f),
            textAlign = TextAlign.Center,
            modifier = Modifier.padding(top = 10.dp,end = 25.dp, start = 25.dp),
            fontSize = 20.sp

        )

    }
}


