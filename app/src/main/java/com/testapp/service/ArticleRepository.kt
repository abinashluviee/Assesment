package com.testapp.service

import com.testapp.pojo.NewsHeadlinesPojo
import javax.inject.Inject
import javax.inject.Singleton

@Singleton
class ArticleRepository @Inject constructor(val apiService: ApiInterface) {

    suspend fun getArticles(country:String,apiKey:String): NewsHeadlinesPojo =
        apiService.getTopHeadlines(country,apiKey)

}