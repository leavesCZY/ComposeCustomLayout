package github.leavesczy.customlayout

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.material.Divider
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Surface
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import github.leavesczy.customlayout.ui.theme.ComposeCustomLayoutTheme

/**
 * @Author: leavesCZY
 * @Desc:
 * @Github：https://github.com/leavesCZY
 */
class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            ComposeCustomLayoutTheme {
                Surface(
                    modifier = Modifier
                        .fillMaxSize()
                        .wrapContentSize(align = Alignment.Center),
                    color = MaterialTheme.colors.background
                ) {
                    CustomLayout2()
                }
            }
        }
    }

}

@Composable
private fun CustomLayout1() {
    CustomLayout1(
        modifier = Modifier
            .background(color = Color.Yellow)
    ) {
        Spacer(
            modifier = Modifier
                .background(color = Color.Green)
                .size(size = 40.dp)
        )
        Spacer(
            modifier = Modifier
                .background(color = Color.Cyan)
                .size(size = 40.dp)
        )
        Spacer(
            modifier = Modifier
                .background(color = Color.Magenta)
                .size(size = 40.dp)
        )
        Spacer(
            modifier = Modifier
                .background(color = Color.Red)
                .size(size = 40.dp)
        )
    }
}

@Composable
private fun CustomLayout2() {
    CustomLayout2(
        modifier = Modifier
            .height(intrinsicSize = IntrinsicSize.Min)
            .background(color = Color.Yellow)
    ) {
        Spacer(
            modifier = Modifier
                .background(color = Color.Green)
                .size(size = 40.dp)
        )
        Spacer(
            modifier = Modifier
                .background(color = Color.Cyan)
                .size(size = 40.dp)
        )
        Divider(
            modifier = Modifier
                .width(width = 6.dp)
                .fillMaxHeight()
                .matchParentHeight(),
            color = Color.Black
        )
        Spacer(
            modifier = Modifier
                .background(color = Color.Magenta)
                .size(size = 40.dp)
        )
        Spacer(
            modifier = Modifier
                .background(color = Color.Red)
                .size(size = 40.dp)
        )
    }
}