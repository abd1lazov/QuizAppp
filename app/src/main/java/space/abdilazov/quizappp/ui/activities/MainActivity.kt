package space.abdilazov.quizappp.ui.activities

import android.view.LayoutInflater
import android.view.View
import androidx.navigation.fragment.NavHostFragment
import androidx.navigation.ui.setupWithNavController
import org.koin.androidx.viewmodel.ext.android.viewModel
import space.abdilazov.quizappp.R
import space.abdilazov.quizappp.core.ui.BaseActivity
import space.abdilazov.quizappp.databinding.ActivityMainBinding
import space.abdilazov.quizappp.ui.fragments.mainFragment.MainViewModel

class MainActivity: BaseActivity<ActivityMainBinding>() {

    private val viewModel: MainViewModel by viewModel()

    override fun setupUI() {
        val navHostFragment =
            supportFragmentManager.findFragmentById(R.id.fragment_container) as NavHostFragment
        val navController = navHostFragment.navController

        binding.bottomNavView.setupWithNavController(navController)

        navController.addOnDestinationChangedListener { _, destination, _ ->
            when (destination.id) {
                R.id.mainFragment -> showBottomNav()
                R.id.settingsFragment -> showBottomNav()
                R.id.historyFragment -> showBottomNav()
                R.id.gameFragment -> hideBottomNav()
                else -> hideBottomNav()
            }
        }
    }

    private fun showBottomNav() {
        binding.bottomNavView.visibility = View.VISIBLE
    }

    private fun hideBottomNav() {
        binding.bottomNavView.visibility = View.GONE
    }

    override fun setupLiveData() {

    }

    override fun inflateBinding(from: LayoutInflater): ActivityMainBinding {
        return ActivityMainBinding.inflate(layoutInflater)
    }
}