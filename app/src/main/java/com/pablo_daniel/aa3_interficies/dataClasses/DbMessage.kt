package com.pablo_daniel.aa3_interficies.dataClasses

import com.google.firebase.firestore.ServerTimestamp
import java.util.Date

data class DbMessage(
    override var id:String?=null,
    var userId:String?=null,
    var message: String?=null,
    var image: String?=null,

    @ServerTimestamp var createDate: Date?=null,
):DbBaseData{
    override fun getTable() = "Messages"
}
