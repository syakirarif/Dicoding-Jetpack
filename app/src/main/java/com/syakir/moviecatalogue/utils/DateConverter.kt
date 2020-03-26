package com.syakir.moviecatalogue.utils

import java.text.DateFormat
import java.text.ParseException
import java.text.SimpleDateFormat
import java.util.*

object DateConverter {
    fun formatDate(date: String, format: String): String? {
        var result = ""
        val old: DateFormat = SimpleDateFormat("yyyy-MM-dd", Locale.getDefault())
        try {
            val oldDate: Date = old.parse(date)
            val newFormat: DateFormat = SimpleDateFormat(format)
            result = newFormat.format(oldDate)
        } catch (e: ParseException) {
            e.printStackTrace()
        }
        return result
    }

    fun getLongDate(date: String): String? {
        return formatDate(date, "EEEE, MMM d, yyyy")
    }
}