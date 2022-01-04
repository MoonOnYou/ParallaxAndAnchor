package com.example.verticalviewpager

import android.content.Context
import android.os.Build
import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.widget.ImageView
import android.widget.LinearLayout
import android.widget.TextView
import androidx.annotation.RequiresApi
import androidx.appcompat.app.AppCompatActivity
import androidx.constraintlayout.widget.ConstraintLayout
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
    var parallax : ConstraintLayout? = null
    var layoutTab : LinearLayout? = null
    var textViewHotelTitle : TextView? = null
    var imageView : ImageView? = null
    var toolbar : androidx.appcompat.widget.Toolbar? = null


    var isSelected : Boolean = false



    @RequiresApi(Build.VERSION_CODES.M)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        findViewById()
        setupListener()
        setImageViewPager()
        inflaterToAddView()

        scrollable?.viewTreeObserver?.addOnScrollChangedListener {

            if (isSelected) {
                if (scrollable?.scrollY == recycler?.get(0)?.y!!.toInt() + 1) {
                        isSelected = false
                }
            } else {

                when (scrollable?.scrollY) {
                    0 -> {
                        layoutTab?.visibility = View.GONE
                        textViewHotelTitle?.visibility = View.GONE
                        toolbar?.setBackgroundColor(getColor(R.color.tr))
                    }

                    in recycler?.get(0)?.y!!.toInt()..recycler?.get(1)?.y!!.toInt() - 1 -> {
                        layoutTab?.visibility = View.VISIBLE
                        tab1?.setBackgroundColor(getColor(R.color.white))
                        tab2?.setBackgroundColor(getColor(R.color.purple_500))
                        tab3?.setBackgroundColor(getColor(R.color.purple_500))
                        textViewHotelTitle?.visibility = View.VISIBLE
                        toolbar?.setBackgroundColor(getColor(R.color.white))
                    }

                    in recycler?.get(1)?.y!!.toInt()..recycler?.get(2)?.y!!.toInt() - 1 -> {
                        layoutTab?.visibility = View.VISIBLE
                        tab1?.setBackgroundColor(getColor(R.color.purple_500))
                        tab2?.setBackgroundColor(getColor(R.color.white))
                        tab3?.setBackgroundColor(getColor(R.color.purple_500))
                        textViewHotelTitle?.visibility = View.VISIBLE
                        toolbar?.setBackgroundColor(getColor(R.color.white))
                    }
                    in recycler?.get(2)?.y!!.toInt()..(recycler?.get(2)?.y!!.toInt() + recycler?.get(2)?.height!!) - 1 -> {
                        layoutTab?.visibility = View.VISIBLE
                        tab1?.setBackgroundColor(getColor(R.color.purple_500))
                        tab2?.setBackgroundColor(getColor(R.color.purple_500))
                        tab3?.setBackgroundColor(getColor(R.color.white))
                        textViewHotelTitle?.visibility = View.VISIBLE
                        toolbar?.setBackgroundColor(getColor(R.color.white))
                    }
                }
            }
        }

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
        parallax = findViewById(R.id.parallax)
        layoutTab = findViewById(R.id.layoutTab)
        textViewHotelTitle = findViewById(R.id.textViewHotelTitle)
        imageView = findViewById(R.id.imageView)
        toolbar = findViewById(R.id.toolbar)
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

    @RequiresApi(Build.VERSION_CODES.M)
    val clickListener = View.OnClickListener { v ->
        isSelected = true
        when(v.id) {
            R.id.tab1 -> {
                scrollable?.smoothScrollTo(0, recycler?.get(0)?.y!!.toInt() + 1)
                tab1?.setBackgroundColor(getColor(R.color.white))
                tab2?.setBackgroundColor(getColor(R.color.purple_500))
                tab3?.setBackgroundColor(getColor(R.color.purple_500))
            }
            R.id.tab2 -> {
                scrollable?.smoothScrollTo(0, recycler?.get(1)?.y!!.toInt())
                tab1?.setBackgroundColor(getColor(R.color.purple_500))
                tab2?.setBackgroundColor(getColor(R.color.white))
                tab3?.setBackgroundColor(getColor(R.color.purple_500))
            }
            R.id.tab3 -> {
                scrollable?.smoothScrollTo(0, recycler?.get(2)?.y!!.toInt())
                tab1?.setBackgroundColor(getColor(R.color.purple_500))
                tab2?.setBackgroundColor(getColor(R.color.purple_500))
                tab3?.setBackgroundColor(getColor(R.color.white))
            }
        }
    }
}