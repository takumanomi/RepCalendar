package com.example.repcalendar
import io.realm.kotlin.types.RealmObject
import io.realm.kotlin.types.annotations.PrimaryKey
import java.io.Serializable //クラスのままデータを保存できる

open class Realmfile(): RealmObject, Serializable { //openつけると他アプリから参照Ok

    var name: String = ""
    var size: String = ""
    var number: Int = 0
    @PrimaryKey
    var id: Long = 0


    constructor(name: String) : this() {
        this.name = this.name
    }
}
// Realmにデータを保存するためのクラス