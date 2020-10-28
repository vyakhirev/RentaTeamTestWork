package com.example.rentateam.ui.usercard

import android.os.Bundle
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import com.bumptech.glide.Glide
import com.example.rentateam.R
import kotlinx.android.synthetic.main.user_card_fragment.*

class UserCardFragment : Fragment() {

    companion object {
        const val AVATAR_URL = "image_url"
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
        const val EMAIL = "email"
    }

    private lateinit var viewModel: UserCardViewModel

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.user_card_fragment, container, false)
    }

    override fun onActivityCreated(savedInstanceState: Bundle?) {
        super.onActivityCreated(savedInstanceState)

        viewModel = ViewModelProvider(this).get(UserCardViewModel::class.java)
        // TODO: Use the ViewModel
    }
    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        first_name_onDetails_TV.text = arguments?.getString(FIRST_NAME) + " " + arguments?.getString(LAST_NAME)
//        last_name_onDetails_TV.text=arguments?.getString(LAST_NAME)
        email_TV.text = arguments?.getString(EMAIL)

        Glide.with(avatar_IV)
                .load(arguments?.getString(AVATAR_URL))
                .centerCrop()
                .into(avatar_IV)


    }
}