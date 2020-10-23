package com.example.flickrapp.ui.listusers

import android.os.Bundle
import android.util.Log
import android.view.LayoutInflater
import android.view.View
import android.view.ViewGroup
import androidx.fragment.app.Fragment
import androidx.lifecycle.ViewModelProvider
import androidx.recyclerview.widget.LinearLayoutManager
import com.example.flickrapp.R
import com.example.flickrapp.di.AppComponent.Companion.create
import com.example.flickrapp.di.AppModule
import com.example.flickrapp.di.viewmodel.DaggerViewModelComponent
import com.example.flickrapp.ui.adapter.ListUsersAdapter
import com.example.flickrapp.ui.userdetails.UserCardFragment
import kotlinx.android.synthetic.main.list_users_fragment.*
import javax.inject.Inject

class ListUsersFragment : Fragment() {

    companion object {
        fun newInstance() = ListUsersFragment()
        const val AVATAR_URL = "image_url"
        const val FIRST_NAME = "first_name"
        const val LAST_NAME = "last_name"
        const val EMAIL = "email"
    }

    @Inject
    lateinit var viewModelFactory: ViewModelProvider.Factory

    private lateinit var viewModel: ListUsersViewModel
    private lateinit var adapter: ListUsersAdapter

    override fun onCreateView(inflater: LayoutInflater, container: ViewGroup?,
                              savedInstanceState: Bundle?): View? {
        return inflater.inflate(R.layout.list_users_fragment, container, false)
    }

    override fun onViewCreated(view: View, savedInstanceState: Bundle?) {
        super.onViewCreated(view, savedInstanceState)

        DaggerViewModelComponent.builder()
                .appModule(AppModule(requireContext()))
                .build()
                .inject(this)

        viewModel = ViewModelProvider(
                this,
                viewModelFactory
        ).get(ListUsersViewModel::class.java)

        setupRecyclerView()

        viewModel.getUsers()
        viewModel.users.observe(
                viewLifecycleOwner,
                {
                    adapter.update(it)
                })
    }

    private fun setupRecyclerView() {
        adapter =
                ListUsersAdapter(
                        requireContext(),
                        mutableListOf(),
                        userClick = {
                            val bundle = Bundle()
                            bundle.apply {
                                Log.d("kan", it.avatar)
                                putString(AVATAR_URL, it.avatar)
                                putString(FIRST_NAME, it.first_name)
                                putString(LAST_NAME, it.last_name)
                                putString(EMAIL, it.email)
                            }
                            val userCardFragment = UserCardFragment()
                            userCardFragment.arguments = bundle
                            parentFragmentManager
                                    .beginTransaction()
                                    .replace(R.id.fragmentContainer, userCardFragment)
                                    .addToBackStack(null)
                                    .commit()
                        }
                )
        listUsersRV.layoutManager = LinearLayoutManager(context)
        listUsersRV.adapter = adapter
    }
}