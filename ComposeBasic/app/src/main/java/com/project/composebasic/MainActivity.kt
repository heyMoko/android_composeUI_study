package com.project.composebasic

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.project.composebasic.ui.theme.ComposeBasicTheme

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeBasicTheme {
                // A surface container using the 'background' color from the theme
                Surface(color = MaterialTheme.colors.background) {
                    Greeting("Android")
                }
            }
        }
    }
}

@Composable
fun Greeting(name: String) {
    // topbar 설정 (헥스코드로 색지정시 0xff이후 헥스코드를 붙여줌)
    Scaffold(topBar = {
        TopAppBar(
            title = { Text("moKo Compose Practice") },
            backgroundColor = Color(0xffEC9CD3)
        )
    },
        floatingActionButton = {
            FloatingActionButton(onClick = {}) {
                Text("추가")
            }
        }
    ) {
        // Text(text = "하이 $name!")
        MyComposableView()
    }
}

@Composable
fun MyRowItem() {
    Row(
        Modifier
            .padding(10.dp)
            .fillMaxWidth()
            .background(Color(0xffeaffd0)),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Text(
            text = "안녕하세요?!",
            Modifier
                .padding(all = 10.dp)
                .background(Color.Yellow)
        )
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요?!")
        Spacer(modifier = Modifier.size(10.dp))
        Text(text = "안녕하세요?!")
    }
}

@Composable
fun MyComposableView() {
    // horizontal linearlayout과 비슷

    Column(
        Modifier
            .background(Color.Green)
            .verticalScroll(rememberScrollState())
    ) {
      for(i in 0..20) {
          MyRowItem()
      }
    }
}

@Preview(showBackground = true)
@Composable
fun DefaultPreview() {
    ComposeBasicTheme {
        Greeting("안드입니다")
    }
}