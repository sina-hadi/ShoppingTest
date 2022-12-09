package com.codinginflow.testproject.ui

import androidx.arch.core.executor.testing.InstantTaskExecutorRule
import com.codinginflow.testproject.MainCoroutineRule
import com.codinginflow.testproject.getOrAwaitValue
import com.codinginflow.testproject.repositories.FakeShoppingRepository
import com.codinginflow.testproject.util.Constants
import com.codinginflow.testproject.util.Status
import com.google.common.truth.Truth.assertThat
import org.junit.Before
import org.junit.Rule
import org.junit.Test

internal class ShoppingViewModelTest {

    @get:Rule
    var instantTaskExecutorRule = InstantTaskExecutorRule()

    @get:Rule
    var mainCoroutineRule = MainCoroutineRule()

    private lateinit var viewModel: ShoppingViewModel

    @Before
    fun setup() {
//        Dispatchers.setMain(Dispatchers.Unconfined)
        viewModel = ShoppingViewModel(FakeShoppingRepository())
    }

    @Test
    fun insertShoppingItemWithEmptyField_returnsError() {
        viewModel.insertShoppingItem("name", "", "3.0")

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun insertShoppingItemWithTooLongName_returnsError() {
        val string = buildString {
            for (i in 1..Constants.MAX_NAME_LENGTH + 1) {
                append(1)
            }
        }
        viewModel.insertShoppingItem(string, "5", "3.0")

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun insertShoppingItemWithTooLongPrice_returnsError() {
        val string = buildString {
            for (i in 1..Constants.MAX_PRICE_LENGTH + 1) {
                append(1)
            }
        }
        viewModel.insertShoppingItem("name", "5", string)

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun insertShoppingItemWithTooLongAmount_returnsError() {
        viewModel.insertShoppingItem("name", "3000000000", "3.0")

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.ERROR)
    }

    @Test
    fun insertShoppingItemWithValidInput_returnsSuccess() {
        viewModel.insertShoppingItem("name", "5", "3.0")

        val value = viewModel.insertShoppingItemStatus.getOrAwaitValue()

        assertThat(value.getContentIfNotHandled()?.status).isEqualTo(Status.SUCCESS)
    }

}