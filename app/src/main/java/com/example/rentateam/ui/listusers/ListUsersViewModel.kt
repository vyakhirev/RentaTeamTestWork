package com.example.rentateam.ui.listusers

import androidx.lifecycle.LiveData
import androidx.lifecycle.MutableLiveData
import androidx.lifecycle.ViewModel
import com.example.rentateam.data.UserItem
import com.example.rentateam.repository.Repository
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

    private val _onMessageError = MutableLiveData<Boolean>()
    val onMessageError: LiveData<Boolean> = _onMessageError

    fun getUsers() {
        disposable.add(
                repository.getUsers()
                        .subscribeOn(Schedulers.io())
                        .observeOn(AndroidSchedulers.mainThread())
                        .subscribe(
                                {
                                    _isViewLoading.value = true
                                    Thread.sleep(1000)
                                    _users.value = it
                                    _isViewLoading.value = false
                                    _onMessageError.value = it.isEmpty()
                                }, {
                            _isViewLoading.value = false
                            _onMessageError.value = true
                        }
                        )
        )
    }

    override fun onCleared() {
        disposable.clear()
    }
}