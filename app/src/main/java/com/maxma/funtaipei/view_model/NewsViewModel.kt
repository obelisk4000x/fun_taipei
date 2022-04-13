package com.maxma.funtaipei.view_model

import com.maxma.funtaipei.base.ApiManager
import com.maxma.funtaipei.model.News
import io.reactivex.android.schedulers.AndroidSchedulers
import io.reactivex.disposables.CompositeDisposable
import io.reactivex.schedulers.Schedulers
import java.util.*
import kotlin.collections.ArrayList

class NewsViewModel : Observable() {
    private var newsList: List<News> = ArrayList()
    private var compositeDisposable: CompositeDisposable? = CompositeDisposable()

    init {
        fetchNewsList()
    }

    private fun fetchNewsList() {
        val disposable = ApiManager.service.getNews("en", 1)
            .subscribeOn(Schedulers.io())
            .observeOn(AndroidSchedulers.mainThread())
            .subscribe({ response ->
                updateData(response.data)
            }, { error ->
                error.printStackTrace()
            })

        compositeDisposable?.add(disposable)
    }

    private fun updateData(news: List<News>) {
        newsList = news
        setChanged()
        notifyObservers()
    }

    fun getNewsList(): List<News> {
        return newsList
    }

    fun reset() {
        if (compositeDisposable != null && !compositeDisposable!!.isDisposed) {
            compositeDisposable!!.dispose()
        }
        compositeDisposable = null
    }
}