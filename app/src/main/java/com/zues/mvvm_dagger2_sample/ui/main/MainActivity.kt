package com.zues.mvvm_dagger2_sample.ui.main

import android.os.Bundle
import androidx.appcompat.app.AppCompatActivity
import androidx.fragment.app.Fragment
import androidx.fragment.app.FragmentTransaction
import com.zues.mvvm_dagger2_sample.R
import com.zues.mvvm_dagger2_sample.ui.main.profile.ProfileFragment
import com.zues.mvvm_dagger2_sample.ui.main.quotes.QuotesFragment
import com.zues.mvvm_dagger2_sample.ui.views.MyTabHost
import kotlinx.android.synthetic.main.activity_main.*

class MainActivity : AppCompatActivity(), MyTabHost.MyTabSelectionListener {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        setupTabs()
    }

    private fun setupTabs() {
        tab_host.tabSelectionListener = this
        tab_host.addTab(1, "A")
        tab_host.addTab(2, "B")
        tab_host.addTab(3, "C")
        val tabAtIndex = tab_host.getTabAtIndex(0)
        tab_host.selectedTab = tabAtIndex
        tabAtIndex?.performClick()
    }

    override fun onTabSelected(tabId: Int) {
        tab_host.selectTab(tabId)
        // loadFragment For tab
        loadFragment(tabId)
    }

    private fun loadFragment(tabId: Int) {
        val fragment: Fragment = getFragmentForTabPosition(tabId)
        val transaction: FragmentTransaction = supportFragmentManager.beginTransaction()
        transaction.replace(R.id.fragment_container, fragment)
        transaction.commit()
    }

    private fun getFragmentForTabPosition(tabId: Int): Fragment {
        when (tabId) {
            1 -> return ProfileFragment()
            2 -> return QuotesFragment()
            3 -> return ProfileFragment()
            else -> return ProfileFragment()
        }
    }
}