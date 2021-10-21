package com.project.compose_fundamental_tutorial

import android.os.Bundle
import android.widget.Toast
import androidx.compose.ui.Modifier
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.CutCornerShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.foundation.text.ClickableText
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.draw.clip
import androidx.compose.ui.geometry.Size
import androidx.compose.ui.graphics.*
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.*
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.text.style.TextOverflow
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Density
import androidx.compose.ui.unit.LayoutDirection
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.project.compose_fundamental_tutorial.ui.theme.Compose_fundamental_tutorialTheme
import kotlin.random.Random

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            Compose_fundamental_tutorialTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
              //      Greeting("Android")
                    ShapeContainer()
                }
            }
        }
    }
}

@Composable
fun Container() {
    Row(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        horizontalArrangement = Arrangement.SpaceEvenly,
        verticalAlignment = Alignment.CenterVertically
    ) {
        DummyBox()
        DummyBox()
        DummyBox()
    }
}

@Composable
fun BoxContainer() {
    Box(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.BottomCenter,
        propagateMinConstraints = false
    ) {
        DummyBox(modifier = Modifier.size(200.dp), color = Color.Green)
        DummyBox(modifier = Modifier.size(150.dp), color = Color.Yellow)
        DummyBox(color = Color.Blue)
    }
}

@Composable
fun BoxWithConstraintContainer() {
    BoxWithConstraints(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        contentAlignment = Alignment.Center,
        propagateMinConstraints = false
    ) {

        if(this.minHeight > 400.dp) {
            DummyBox(modifier = Modifier.size(200.dp), color = Color.Green)
        } else {
            DummyBox(modifier = Modifier.size(200.dp), color = Color.Yellow)
        }
        Text(text = "minHeight ${this.minHeight}")
//        Column {
//            BoxWithConstraintItem(modifier = Modifier
//                .size(200.dp)
//                .background(Color.Yellow)
//            )
//            BoxWithConstraintItem(modifier = Modifier
//                .size(300.dp)
//                .background(Color.Green)
//            )
//        }

//        DummyBox(modifier = Modifier.size(200.dp), color = Color.Green)
//        DummyBox(modifier = Modifier.size(150.dp), color = Color.Yellow)
//        DummyBox(color = Color.Blue)
    }
}

@Composable
fun BoxWithConstraintItem(modifier: Modifier = Modifier) {
    BoxWithConstraints(
        modifier = Modifier,
        contentAlignment = Alignment.Center,
        propagateMinConstraints = false
    ) {
        if(this.minWidth > 200.dp) {
            Text(text = "이것은 크다")
        } else {
            Text(text = "이것은 작다")
        }
    }
}

@Composable
fun VerticalContainer() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceAround,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DummyBox()
        DummyBox()
        DummyBox()
    }
}

//text: String,
//modifier: Modifier = Modifier,
//color: Color = Color.Unspecified,
//fontSize: TextUnit = TextUnit.Unspecified,
//fontStyle: FontStyle? = null,
//fontWeight: FontWeight? = null,
//fontFamily: FontFamily? = null,
//letterSpacing: TextUnit = TextUnit.Unspecified,
//textDecoration: TextDecoration? = null,
//textAlign: TextAlign? = null,
//lineHeight: TextUnit = TextUnit.Unspecified,
//overflow: TextOverflow = TextOverflow.Clip,
//softWrap: Boolean = true,
//maxLines: Int = Int.MAX_VALUE,
//onTextLayout: (TextLayoutResult) -> Unit = {},
//style: TextStyle = LocalTextStyle.current

@Composable
fun TextContainer(
) {

    val name = "모코"

    var words = stringResource(id = R.string.dummy_short_text)
    var wordsArray = words.split(" ")

    Column(
        verticalArrangement = Arrangement.spacedBy(10.dp),
        modifier = Modifier
            .fillMaxSize()
            .verticalScroll(rememberScrollState())
            .padding(10.dp)
    ) {
        Text(text = "안녕하세요? 오늘도 빡코딩~! $name",
            style = TextStyle(
                textAlign = TextAlign.Center
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
        )
        Text(text = "안녕하세요? 오늘도 빡코딩~! $name",
            style = TextStyle(
                textAlign = TextAlign.Start
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow))
        Text(text = "안녕하세요? 오늘도 빡코딩~! $name",
            style = TextStyle(
                textAlign = TextAlign.End
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow))
        Text(text = stringResource(id = R.string.dummy_short_text),
            maxLines = 3,
            overflow = TextOverflow.Ellipsis,
            style = TextStyle(
                textAlign = TextAlign.Justify,
                textDecoration = TextDecoration.combine(
                    listOf(
                        TextDecoration.LineThrough,
                        TextDecoration.Underline,
                    )
                )
            ),
            fontWeight = FontWeight.W200,
            fontSize = 20.sp,
            fontFamily = FontFamily.Monospace,
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow)
        )
        Text(text = stringResource(id = R.string.dummy_short_text),
            style = TextStyle(
                textAlign = TextAlign.Start,
                fontFamily = FontFamily(
                    Font(R.font.cafe24,
                weight = FontWeight.ExtraBold)),
                //줄높이
                lineHeight = 40.sp
            ),
            modifier = Modifier
                .fillMaxWidth()
                .background(Color.Yellow))
        Text(text = buildAnnotatedString {
            append("안녕하세요?")
            withStyle(style = SpanStyle(color = Color.Blue,
                                fontSize = 40.sp,
                                fontWeight = FontWeight.ExtraBold)
            ) {
                append("개발하는 모코입니다")
            }
            append("빡!코딩")
        })
        Text(text = buildAnnotatedString {
            wordsArray.forEach{
                if(it.contains("황금")) {
                    withStyle(style = SpanStyle(color = Color.Blue,
                        fontSize = 30.sp,
                        fontWeight = FontWeight.ExtraBold)
                    ) {
                        append("$it ")
                    }
                } else {
                    append("$it ")
                }
            }
        })

        ClickableText(text = AnnotatedString("클릭미!"),
            onClick = {
            })
        Text(text = stringResource(id = R.string.dummy_long_text),
            style = TextStyle(lineHeight = 20.sp)
        )
    }
}

@Composable
fun DummyBox(modifier: Modifier = Modifier, color: Color? = null) {

    val red = Random.nextInt(256)
    val green = Random.nextInt(256)
    val blue = Random.nextInt(256)
    // color 가 있으면 해당값을 넣어주고 없으면 랜덤
    val randomColor = color?.let { it } ?: Color(red, green, blue)
    Box(modifier = modifier
        .size(100.dp)
        .background(randomColor))
}

@Composable
fun ShapeContainer() {
    Column(
        modifier = Modifier
            .background(Color.White)
            .fillMaxSize(),
        verticalArrangement = Arrangement.SpaceEvenly,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        DummyBox(modifier = Modifier
            .clip(RectangleShape)
        )
        DummyBox(modifier = Modifier
            .clip(CircleShape)
        )
        DummyBox(modifier = Modifier
            .clip(RoundedCornerShape(10.dp))
        )
        DummyBox(modifier = Modifier
            .clip(CutCornerShape(10.dp))
        )
        DummyBox(modifier = Modifier
            .clip(TriangleShape())
        )
    }
}

class TriangleShape(): Shape {
    override fun createOutline(
        size: Size,
        layoutDirection: LayoutDirection,
        density: Density
    ): Outline {
        val path = Path().apply {
            moveTo(size.width / 2f, 0f)
            lineTo(size.width, size.height)
            lineTo(0f , size.height)
            close()
        }
        return Outline.Generic(path = path)
    }
}

//@Composable
//fun Greeting(name: String) {
//    Text(text = "Hello $name!")
//}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    Compose_fundamental_tutorialTheme {
 //       Greeting("Android")
        ShapeContainer()
    }
}