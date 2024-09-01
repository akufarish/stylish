package com.example.stylish

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import com.example.stylish.adapter.PromoCarouselAdapter
import com.example.stylish.adapter.TypeAdapter
import com.example.stylish.databinding.ActivityMainBinding
import com.example.stylish.models.PromoCarousel
import com.example.stylish.models.Type

class MainActivity : AppCompatActivity() {
    private var _binding: ActivityMainBinding? = null
    private val binding get() = _binding

    private val promoCarousel = arrayListOf(
        R.drawable.promo1,
        R.drawable.promo1,
        R.drawable.promo1,
    )

    private val typeImage = arrayListOf(
        R.drawable.jawa,
        R.drawable.jawa,
        R.drawable.jawa,
        R.drawable.jawa,
        R.drawable.jawa,
        R.drawable.jawa,
    )

    private val typeName = arrayListOf(
        "Fashion",
        "Fashion",
        "Fashion",
        "Fashion",
        "Fashion",
        "Fashion",
    )

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        _binding = ActivityMainBinding.inflate(layoutInflater)
        setContentView(binding?.root)

        val typeAdapter = TypeAdapter(this@MainActivity)
        val promoAdapter = PromoCarouselAdapter(this@MainActivity)
        val typeData = arrayListOf<Type>()
        val promoData = arrayListOf<PromoCarousel>()

        for (i in promoCarousel.indices) {
            val promo = PromoCarousel(
                image = promoCarousel[i]
            )
            promoData.add(promo)
        }

        for (i in typeImage.indices) {
            val type = Type(
                image = typeImage[i],
                type = typeName[i]
            )
            typeData.add(type)
        }


        typeAdapter.setData(typeData)
        promoAdapter.setData(promoData)

        binding?.apply {
            binding?.promoViewPager?.apply {
                adapter = promoAdapter
                wormDotsIndicator.attachTo(promoViewPager)
            }

            binding?.typeRecyclerView?.apply {
                adapter = typeAdapter
            }
        }
    }

    override fun onDestroy() {
        super.onDestroy()
        _binding = null
    }
}