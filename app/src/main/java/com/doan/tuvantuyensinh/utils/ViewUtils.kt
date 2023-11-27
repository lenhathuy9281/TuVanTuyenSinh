package com.doan.tuvantuyensinh.utils

import android.app.Activity
import android.content.Context
import android.view.inputmethod.InputMethodManager
import android.content.res.Resources
import android.graphics.drawable.Drawable
import androidx.core.content.res.ResourcesCompat

fun Activity.hideKeyboard(){
    currentFocus?.let { view ->
        val imm = getSystemService(Context.INPUT_METHOD_SERVICE) as? InputMethodManager
        imm?.hideSoftInputFromWindow(view.windowToken, 0)
    }
}

fun Context.getDrawableFromString(resourceName: String): Drawable? {
    val res: Resources = this.resources

    // Extract resource name from the input string
    val resName = resourceName.substringAfterLast("/").substringBeforeLast(".")

    // Get the resource identifier (R.drawable.*)
    val resId: Int = res.getIdentifier(resName, "drawable", this.packageName)

    // Check if the resource exists
    return if (resId != 0) {
        // Return the drawable
        ResourcesCompat.getDrawable(res, resId, this.theme)
//        res.getDrawable(resId, this.theme)
    } else {
        // Resource not found
        null
    }
}