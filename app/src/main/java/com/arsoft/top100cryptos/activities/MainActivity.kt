package com.arsoft.top100cryptos.activities

import android.content.Intent
import android.support.v7.app.AppCompatActivity
import android.os.Bundle
import android.view.Menu
import android.view.MenuItem
import com.arsoft.top100cryptos.R
import com.arsoft.top100cryptos.fragments.CurrenciesListFragment
import com.google.android.gms.ads.AdRequest
import com.google.android.gms.ads.InterstitialAd

class MainActivity : AppCompatActivity() {

    private lateinit var mInterstitialAd: InterstitialAd

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)

        mInterstitialAd = InterstitialAd(this)
        mInterstitialAd.adUnitId = "ca-app-pub-6637942520165301/3277274922"
        mInterstitialAd.loadAd(AdRequest.Builder().build())

        if (savedInstanceState == null) {
            supportFragmentManager
                .beginTransaction()
                .add(R.id.container, CurrenciesListFragment(), null)
                .commit()
        }

    }

    override fun onCreateOptionsMenu(menu: Menu?): Boolean {

        menuInflater.inflate(R.menu.main_menu, menu)
        return super.onCreateOptionsMenu(menu)
    }

    override fun onOptionsItemSelected(item: MenuItem?): Boolean {

        when (item!!.itemId) {
            R.id.action_about -> {
                val intent = Intent(this, AboutActivity::class.java)
                startActivity(intent)
            }
        }
        return super.onOptionsItemSelected(item)
    }

    private fun showAd() {
        if (mInterstitialAd.isLoaded) {
            mInterstitialAd.show()
        }
    }

    override fun onBackPressed() {
        super.onBackPressed()
        showAd()
    }
}
