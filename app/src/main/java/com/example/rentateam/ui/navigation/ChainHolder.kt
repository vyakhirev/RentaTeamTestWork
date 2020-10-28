package com.example.rentateam.ui.navigation

import androidx.fragment.app.Fragment
import java.lang.ref.WeakReference

interface ChainHolder {
    val chain: MutableList<WeakReference<Fragment>>
}

