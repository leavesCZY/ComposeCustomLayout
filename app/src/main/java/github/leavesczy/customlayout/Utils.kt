package github.leavesczy.customlayout

import android.util.Log

fun log(log: () -> Any) {
    Log.e("TAG", log().toString())
}