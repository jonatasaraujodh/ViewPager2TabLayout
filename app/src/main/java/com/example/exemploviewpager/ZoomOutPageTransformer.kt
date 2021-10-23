package com.example.exemploviewpager

import android.view.View
import androidx.viewpager2.widget.ViewPager2

private const val MIN_SCALE = 0.75f
private const val MIN_ALPHA = 0.5f

class ZoomOutPageTransformer: ViewPager2.PageTransformer {
    override fun transformPage(page: View, position: Float) {

        page.apply {
            val pageWidth = width
            val pageHeight = height
            when {
                position < -1 -> { // [-Infinity,-1)
                    // This page is way off-screen to the left.
                    alpha = 0f
                }
                position <= 1 -> {
                    // Modify the default slide transition to shrink the page as well
                    val scaleFactor = Math.max(MIN_SCALE, 1 - Math.abs(position))
                    val vertMargin = pageHeight * (1 - scaleFactor) / 2
                    val horizMargin = pageWidth * (1 - scaleFactor) / 2

                    translationX = if (position < 0) {
                        horizMargin - vertMargin / 2
                    } else {
                        horizMargin + vertMargin / 2
                    }

                    // Scale the page down (between MIN_SCALE and 1)
                    scaleX = scaleFactor
                    scaleY = scaleFactor

                    // Fade the page relative to its size.
                    alpha = (MIN_ALPHA +
                            (((scaleFactor - MIN_SCALE) / (1 - MIN_SCALE)) * (1 - MIN_ALPHA)))
                }
                else -> { // (1,+Infinity]
                    // This page is way off-screen to the right.
                    alpha = 0f
                }
            }
        }

//        page.apply {
//            val pageWidth = width
//            when {
//                position < -1 -> { // [-Infinity,-1)
//                    // This page is way off-screen to the left.
//                    alpha = 0f
//                }
//                position <= 0 -> { // [-1,0]
//                    // Use the default slide transition when moving to the left page
//                    alpha = 1f
//                    translationX = 0f
//                    translationZ = 0f
//                    scaleX = 1f
//                    scaleY = 1f
//                }
//                position <= 1 -> { // (0,1]
//                    // Fade the page out.
//                    alpha = 1 - position
//
//                    // Counteract the default slide transition
//                    translationX = pageWidth * -position
//                    // Move it behind the left page
//                    translationZ = -1f
//
//                    // Scale the page down (between MIN_SCALE and 1)
//                    val scaleFactor = (MIN_SCALE + (1 - MIN_SCALE) * (1 - Math.abs(position)))
//                    scaleX = scaleFactor
//                    scaleY = scaleFactor
//                }
//                else -> { // (1,+Infinity]
//                    // This page is way off-screen to the right.
//                    alpha = 0f
//                }
//            }
//        }

    }
}