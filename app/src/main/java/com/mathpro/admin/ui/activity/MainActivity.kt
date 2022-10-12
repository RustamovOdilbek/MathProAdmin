package com.mathpro.admin.ui.activity

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.util.Log
import androidx.navigation.NavController
import androidx.navigation.NavGraph
import androidx.navigation.Navigation
import androidx.navigation.fragment.NavHostFragment
import com.mathpro.admin.R
import com.mathpro.admin.databinding.ActivityMainBinding
import com.mathpro.admin.helper.SharedPref
import com.mathpro.admin.utils.KeyValues.LOG_IN

class MainActivity : AppCompatActivity() {
    private val TAG = "MainActivity"
    private lateinit var binding: ActivityMainBinding
    private lateinit var navController: NavController
    private lateinit var sharedPref: SharedPref

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding.root)
        navController = Navigation.findNavController(this, R.id.nav_host_fragment)

        getWindow().setBackgroundDrawableResource(R.drawable.layout_splash_background)


        val navHostFragment = supportFragmentManager.findFragmentById(R.id.nav_host_fragment) as NavHostFragment
        val inflater = navHostFragment.navController.navInflater
        val graph = inflater.inflate(R.navigation.nav_graph)

        sharedPref = SharedPref(this)
        Log.d(TAG, "onCreate: ${sharedPref.getLogIn(LOG_IN)}")
        if (sharedPref.getLogIn(LOG_IN)){
            graph.setStartDestination(R.id.homeFragment)
        }else {
            graph.setStartDestination(R.id.registrationFragment)
        }

        val navController = navHostFragment.navController
        navController.setGraph(graph, intent.extras)
    }
}