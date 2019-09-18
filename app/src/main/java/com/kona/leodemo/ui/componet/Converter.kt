package com.kona.leodemo.ui.componet

/**
 * Copyright (c) 2017 Fueled. All rights reserved.
 * @author chetansachdeva on 09/04/18
 */
object Converter {

    @JvmStatic
    fun toInt(any: Any?): Int {
        if(any==null) {
            return 0
        }
        return any as Int
    }
}