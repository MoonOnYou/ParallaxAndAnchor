package com.example.verticalviewpager

import android.content.Context
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.LayoutInflater
import android.widget.LinearLayout
import android.widget.TextView
import androidx.core.view.get
import androidx.core.widget.NestedScrollView
import androidx.recyclerview.widget.RecyclerView
import androidx.viewpager.widget.ViewPager
import androidx.viewpager2.widget.ViewPager2
import com.google.android.material.tabs.TabLayout
import com.google.android.material.tabs.TabLayoutMediator

class MainActivity : AppCompatActivity() {
    private val fragmentPagerAdapter by lazy { FragmentPagerAdapter(this) }
    var fragment1 = BlankFragment1()
    var fragment2 = BlankFragment2()
    var fragment3 = BlankFragment3()
//    var pager : ViewPager2? = null
//    var tabLayout : TabLayout? = null
    var viewPagerHotelImage : ViewPager? = null
    var recycler : LinearLayout? = null
    var scrollable : NestedScrollView? = null


    var tab1 : TextView? = null


    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
//
//        pager = findViewById(R.id.pager)
//        tabLayout = findViewById(R.id.tabLayout)
        viewPagerHotelImage = findViewById(R.id.viewPagerHotelImage)
        recycler = findViewById(R.id.recycler)
        tab1 = findViewById(R.id.tab1)
        scrollable = findViewById(R.id.scrollable)


        var imageAdapter = ImageAdapter(listOf("1","2","3","4","5","6","7"))
        viewPagerHotelImage?.adapter = imageAdapter

        fragmentPagerAdapter.addFragment(fragment1)
        fragmentPagerAdapter.addFragment(fragment2)
        fragmentPagerAdapter.addFragment(fragment3)
//        pager?.adapter = fragmentPagerAdapter

        val inflater :LayoutInflater = this.getSystemService(Context.LAYOUT_INFLATER_SERVICE) as LayoutInflater
        var view1 = inflater.inflate(R.layout.fragment_blank1, null, false)
        var view2 = inflater.inflate(R.layout.fragment_blank2, null, false)
        var view3 = inflater.inflate(R.layout.fragment_blank3, null, false)

        recycler?.addView(view1)
        recycler?.addView(view2)
        recycler?.addView(view3)

        tab1?.setOnClickListener { v ->
            scrollable?.scrollTo(0, recycler?.get(1)?.y!!.toInt())
        }


//        pager?.computeScroll()

//        TabLayoutMediator(tabLayout!!, pager!!) { tab, position ->
//            tab.text = "${position}"
//        }.attach()
    }
}