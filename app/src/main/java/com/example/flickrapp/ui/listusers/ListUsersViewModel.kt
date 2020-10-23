package com.example.flickrapp.ui.listusers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.flickrapp.data.UserItem
import com.example.flickrapp.repository.Repository
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import javax.inject.Inject

class ListUsersViewModel @Inject
constructor(
        private val repository: Repository
) : ViewModel() {


    var disposable = CompositeDisposable()

    private val _users = MutableLiveData<List<UserItem>>()
    val users: LiveData<List<UserItem>> = _users

    private val _isViewLoading = MutableLiveData<Boolean>()
    val isViewLoading: LiveData<Boolean> = _isViewLoading

    val onMessageError: SingleLiveEvent<Any> = SingleLiveEvent()

    fun getUsers() {
        disposable.add(
                repository.getUsers()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {
                                    _users.value = it
                                }, {

                                }
                        )
        )
    }

    override fun onCleared() {
        disposable.clear()
    }
}