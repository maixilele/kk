package com.example.baselibrary.mvp.view.fragment

import android.view.View
import com.example.baselibrary.mvp.view.activity.IActivity

/**
 *
 */
public interface IFragment : IActivity {
    fun <T : View?> findViewById(id: Int): T
}