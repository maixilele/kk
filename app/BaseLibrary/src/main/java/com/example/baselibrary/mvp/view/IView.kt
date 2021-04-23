package com.example.baselibrary.mvp.view

/**
 *
 */
public interface IView {
    fun showLoading()
    fun hideLoading()
    fun showToast(msg: String?)
}