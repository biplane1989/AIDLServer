package com.example.aidlserver

import android.app.Service
import android.content.Intent
import android.os.IBinder

class MyService : Service() {

    override fun onBind(intent: Intent): IBinder {
        return binder
    }

    private val binder = object : RemoteService.Stub() {

        override fun getData(): MutableList<String> {
            return getListData()
        }

        override fun getCandy(): MutableList<Candy> {
            return getListCandy()
        }

        override fun sum(a: Int, b: Int): Int {
            return a + b
        }

    }

    fun getListData(): MutableList<String> {
        var strings = ArrayList<String>()
        strings.add("apple")
        strings.add("orange")
        strings.add("lemon")
        return strings
    }

    fun getListCandy(): MutableList<Candy> {
        val candys = ArrayList<Candy>()
        candys.add(Candy("candy 1"))
        candys.add(Candy("candy 2"))
        candys.add(Candy("candy 3"))
        return candys
    }
}