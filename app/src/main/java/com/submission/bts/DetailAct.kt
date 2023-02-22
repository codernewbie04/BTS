package com.submission.bts

import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.view.MenuItem
import android.widget.Toast
import com.squareup.picasso.Picasso
import com.submission.bts.databinding.ActivityDetailBinding
import com.submission.bts.model.TempatWisata

class DetailAct : AppCompatActivity() {
    private lateinit var binding : ActivityDetailBinding

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        binding = ActivityDetailBinding.inflate(layoutInflater)
        setContentView(binding.root)

        val wisata = intent.getParcelableExtra<TempatWisata>("TEMPAT_WISATA")


        supportActionBar!!.title= wisata?.name
        supportActionBar?.setDisplayHomeAsUpEnabled(true)
        supportActionBar?.setDisplayShowHomeEnabled(true)
        Picasso.get().load(wisata?.img)
            .into(binding.ivWisata)
        binding.tvTitle.text = wisata?.name
        binding.tvOpen.text = wisata?.open
        binding.tvAddress.text = wisata?.address
        binding.tvDescription.text = wisata?.description
    }

    override fun onOptionsItemSelected(item: MenuItem): Boolean {
        if (item.itemId == android.R.id.home) {
            onBackPressed()
            return true
        }
        return super.onOptionsItemSelected(item)
    }
}