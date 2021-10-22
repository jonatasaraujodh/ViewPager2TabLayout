package com.example.exemploviewpager

import android.graphics.drawable.AnimationDrawable
import android.os.Bundle
import androidx.fragment.app.Fragment
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import android.widget.ImageView


class Fragment01 : Fragment() {

    private lateinit var rocketAnimation: AnimationDrawable

    override fun onCreateView(
        inflater: LayoutInflater, container: ViewGroup?,
        savedInstanceState: Bundle?
    ): View? {
        val view =  inflater.inflate(R.layout.fragment_01, container, false)

        return view
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        val rocketImage = view.findViewById<ImageView>(R.id.iv_fg_01).apply {
            setBackgroundResource(R.drawable.lista_animacao)
            rocketAnimation = background as AnimationDrawable
            rocketAnimation.start()
        }
//        rocketImage.setOnClickListener {
//            if (rocketAnimation.isOneShot) {
//                rocketAnimation.isOneShot = false
//            } else {
//                rocketAnimation.isOneShot = true
//            }
//        }

        val rocketImage2 = view.findViewById<ImageView>(R.id.iv_fg_02).apply {
            setBackgroundResource(R.drawable.lista_animacao_img)
            rocketAnimation = background as AnimationDrawable
            rocketAnimation.start()
        }

    }


}