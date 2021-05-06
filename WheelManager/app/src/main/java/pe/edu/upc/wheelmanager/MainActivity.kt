package pe.edu.upc.wheelmanager

import android.icu.text.CaseMap
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import androidx.appcompat.app.ActionBarDrawerToggle
import androidx.core.view.GravityCompat
import androidx.fragment.app.Fragment
import com.google.android.material.navigation.NavigationView
import kotlinx.android.synthetic.main.activity_main.*
import kotlinx.android.synthetic.main.content_main.*

class MainActivity : AppCompatActivity(),NavigationView.OnNavigationItemSelectedListener {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_main)
        setSupportActionBar(toolbar)

        val toggle = ActionBarDrawerToggle(this,drawerLayout,toolbar,R.string.open,R.string.close)
        toggle.isDrawerIndicatorEnabled = true
        drawerLayout.addDrawerListener(toggle)
        toggle.syncState()

        nav_menu.setNavigationItemSelectedListener(this)

        setToolbarTitle("WM")
        changeFragment(Home())

    }

    override fun onNavigationItemSelected(item: MenuItem): Boolean {
        drawerLayout.closeDrawer(GravityCompat.START)

        when(item.itemId){
            R.id.home ->{
                setToolbarTitle("WM")
                changeFragment(Home())
            }

            R.id.revolutionize ->{
                setToolbarTitle("WM")
                changeFragment(revolutionize())
            }

            R.id.benefits ->{
                setToolbarTitle("WM")
                changeFragment(Benefits())
            }

            R.id.about ->{
                setToolbarTitle("WM")
                changeFragment(About())
            }

            R.id.subscription ->{
                setToolbarTitle("WM")
                changeFragment(SubscriptionPlans())
            }
        }
        return true
    }

    fun setToolbarTitle(title:String){
        supportActionBar?.title = title
    }

    fun changeFragment(frag:Fragment){
        val fragment = supportFragmentManager.beginTransaction()
        //fragment container , and fragment itself
        fragment.replace(R.id.fragment_container,frag).commit()
    }
}