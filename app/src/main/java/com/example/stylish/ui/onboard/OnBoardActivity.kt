package com.example.stylish.ui.onboard

import android.content.Intent
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.WindowManager
import androidx.viewpager2.widget.ViewPager2
import com.example.stylish.R
import com.example.stylish.adapter.SplashAdapter
import com.example.stylish.databinding.ActivityOnBoardBinding
import com.example.stylish.models.Splash
import com.example.stylish.ui.auth.login.LoginActivity

class OnBoardActivity : AppCompatActivity() {
    private var _binding: ActivityOnBoardBinding? = null
    private val binding get() = _binding

    private val splashImage = arrayListOf(
        R.drawable.on_board_1,
        R.drawable.on_board_2,
        R.drawable.on_board_3,
    )

    private val splashTitle = arrayListOf(
        "Choose Products",
        "Make Payment",
        "Get Your Order"
    )

    private val splashDesc = arrayListOf(
        "Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit.",
        "Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit.",
        "Amet minim mollit non deserunt ullamco est sit aliqua dolor do amet sint. Velit officia consequat duis enim velit mollit.",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityOnBoardBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        window.setFlags(
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS,
            WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS
        )

        val splashData = arrayListOf<Splash>()

        for (i in splashImage.indices) {
            val splash = Splash(
                image = splashImage[i],
                title = splashTitle[i],
                desc = splashDesc[i]
            )
            splashData.add(splash)
        }

        val splashAdapter = SplashAdapter(this@OnBoardActivity)
        splashAdapter.setData(splashData)
        binding?.apply {
            viewPager.apply {
                orientation = ViewPager2.ORIENTATION_HORIZONTAL
                adapter = splashAdapter
                offscreenPageLimit = 3
                currentItem = 0
                wormDotsIndicator.attachTo(viewPager)

                if (currentItem == 2) {
                    binding?.nextTextButton?.text = "Get started"
                    startActivity(
                        Intent(this@OnBoardActivity, LoginActivity::class.java)
                    )
                }
            }
        }

        binding?.nextTextButton?.setOnClickListener {
            binding?.viewPager?.apply {
                if (currentItem !== 2) {
                    currentItem += 1
                } else if (currentItem == 2) {
                    binding?.nextTextButton?.text = "Get started"
                    startActivity(
                        Intent(this@OnBoardActivity, LoginActivity::class.java)
                    )
                }
            }
        }

        binding?.prevTextView?.setOnClickListener {
            binding?.viewPager?.apply {
                currentItem -= 1
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}