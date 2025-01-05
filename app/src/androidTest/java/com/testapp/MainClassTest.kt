package com.testapp

import androidx.compose.ui.test.assertIsDisplayed
import androidx.compose.ui.test.junit4.createComposeRule
import androidx.compose.ui.test.onNodeWithTag
import com.testapp.pojo.ArticlesItem
import org.junit.Rule
import org.junit.Test

class MainClassTest {

    @get:Rule
    val composeTestRule = createComposeRule()

    @Test
    fun testLazyColumnDisplaysItems() {

        var mArticlesItem = ArticlesItem()

        mArticlesItem.author = "ABCNews"
        mArticlesItem.description = "JudgeinTrump's hush money case expected to sentence him to 'unconditionaldischarge' - ABC News"
        mArticlesItem.title = "JudgeinTrump's hush money case expected to sentence him to 'unconditionaldischarge' - ABC News"

        composeTestRule.setContent {
                    NewsHeadlinesCell(mArticlesItem) {

                    }
        }

        composeTestRule.waitForIdle()

        composeTestRule.onNodeWithTag("authorTestTxt").assertIsDisplayed()
        composeTestRule.onNodeWithTag("authorNameTag").assertIsDisplayed()
        composeTestRule.onNodeWithTag("descriptionTestTag").assertIsDisplayed()
        composeTestRule.onNodeWithTag("titleTestTag").assertIsDisplayed()

    }


    @Test
    fun testLazyColumnNotDisplaysItems() {

        var mArticlesItem = ArticlesItem()

        mArticlesItem.author = ""
        mArticlesItem.description = ""
        mArticlesItem.title = ""

        composeTestRule.setContent {
                    NewsHeadlinesCell(mArticlesItem) {

                    }
        }

        composeTestRule.onNodeWithTag("authorTestTxt").assertDoesNotExist()
        composeTestRule.onNodeWithTag("authorNameTag").assertDoesNotExist()
        composeTestRule.onNodeWithTag("descriptionTestTag").assertDoesNotExist()
        composeTestRule.onNodeWithTag("titleTestTag").assertDoesNotExist()

    }

}