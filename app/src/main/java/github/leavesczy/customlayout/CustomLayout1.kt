package github.leavesczy.customlayout

import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.layout.*
import androidx.compose.ui.unit.Constraints
import androidx.compose.ui.unit.IntOffset

/**
 * @Author: leavesCZY
 * @Desc:
 * @Github：https://github.com/leavesCZY
 */
@Composable
fun CustomLayout1(
    modifier: Modifier = Modifier,
    content: @Composable () -> Unit
) {
    Layout(
        content = content,
        modifier = modifier,
        measurePolicy = object : MeasurePolicy {
            override fun MeasureScope.measure(
                measurables: List<Measurable>,
                constraints: Constraints
            ): MeasureResult {
                if (measurables.isEmpty()) {
                    return layout(
                        constraints.minWidth,
                        constraints.minHeight
                    ) {}
                }
                log {
                    "constraints: $constraints"
                }
                //第一步
                val contentConstraints = constraints.copy(minWidth = 0, minHeight = 0)
                val placeables = arrayOfNulls<Placeable>(measurables.size)
                var layoutWidth = 0
                var layoutHeight = 0
                //第二步，测量所有子项，累加所有子项的宽高值
                measurables.forEachIndexed { index, measurable ->
                    val placeable = measurable.measure(contentConstraints)
                    placeables[index] = placeable
                    layoutWidth += placeable.width
                    layoutHeight += placeable.height
                }
                log {
                    "layoutWidth: $layoutWidth layoutHeight: $layoutHeight"
                }
                //第三步，传递布局自身所占据的宽高
                return layout(layoutWidth, layoutHeight) {
                    var top = 0
                    var left = 0
                    //第四步，计算每个子项应该放置的坐标值
                    placeables.forEach { placeable ->
                        if (placeable != null) {
                            placeable.place(position = IntOffset(x = left, y = top))
                            top += placeable.height
                            left += placeable.width
                        }
                    }
                }
            }
        }
    )
}