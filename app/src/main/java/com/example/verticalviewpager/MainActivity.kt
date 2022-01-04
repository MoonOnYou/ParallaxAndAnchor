package com.example.verticalviewpager

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.get
import androidx.core.widget.NestedScrollView
import androidx.viewpager.widget.ViewPager

class MainActivity : AppCompatActivity() {
    var viewPagerHotelImage : ViewPager? = null
    var recycler : LinearLayout? = null
    var scrollable : NestedScrollView? = null
    var tab1 : TextView? = null
    var tab2 : TextView? = null
    var tab3 : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById()
        setupListener()
        setImageViewPager()
        inflaterToAddView()
    }

    private fun setupListener() {
        tab1?.setOnClickListener(clickListener)
        tab2?.setOnClickListener(clickListener)
        tab3?.setOnClickListener(clickListener)
    }

    private fun findViewById() {
        viewPagerHotelImage = findViewById(R.id.viewPagerHotelImage)
        recycler = findViewById(R.id.recycler)
        tab1 = findViewById(R.id.tab1)
        tab2 = findViewById(R.id.tab2)
        tab3 = findViewById(R.id.tab3)
        scrollable = findViewById(R.id.scrollable)
    }

    private fun inflaterToAddView() {
        val inflater :LayoutInflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view1 = inflater.inflate(R.layout.layout1, null, false)
        var view2 = inflater.inflate(R.layout.layout2, null, false)
        var view3 = inflater.inflate(R.layout.layout3, null, false)

        recycler?.addView(view1)
        recycler?.addView(view2)
        recycler?.addView(view3)
    }

    private fun setImageViewPager() {
        var imageAdapter = ImageAdapter(listOf("1","2","3","4","5","6","7"))
        viewPagerHotelImage?.adapter = imageAdapter
    }

    val clickListener = View.OnClickListener { v ->
        when(v.id) {
            R.id.tab1 -> {
                scrollable?.smoothScrollTo(0, recycler?.get(0)?.y!!.toInt())
            }
            R.id.tab2 -> {
                scrollable?.smoothScrollTo(0, recycler?.get(1)?.y!!.toInt())
            }
            R.id.tab3 -> {
                scrollable?.smoothScrollTo(0, recycler?.get(2)?.y!!.toInt())
            }
        }
    }
}