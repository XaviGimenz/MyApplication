package com.example.myapplication.Models

import android.os.Parcel
import android.os.Parcelable

// Parcel es un contenedor para un mensaje
// Puede ser usado para mandar un objeto serializado a traves de Intent
// Mejora el rendimiendo ante Serializer
data class Student(var name: String?, var lastName: String?, var age: Int, var isDeveloper: Boolean = true) :
    Parcelable {
    constructor(parcel: Parcel) : this(
        // Leer en el mismo orden que las declaramos
        parcel.readString(),
        parcel.readString(),
        parcel.readInt(),
        parcel.readByte() != 0.toByte()
    )

    override fun writeToParcel(parcel: Parcel, flags: Int) {
        // Escribir en el mismo orden que el constructor
        parcel.writeString(name)
        parcel.writeString(lastName)
        parcel.writeInt(age)
        parcel.writeByte(if (isDeveloper) 1 else 0)
    }
    // Describe el tipo de contenido del objeto Parceable
    // 0 siempre se usa, el otro valor es 1 o CONTENTS_FILES_DESCRIPTOR, para tipos de obketos que implementan un File Descriptor
    override fun describeContents(): Int {
        return 0
    }

    companion object CREATOR : Parcelable.Creator<Student> {
        // Esto creara el objeto desde el parcel llamando al constructor SECUNDARIO
        override fun createFromParcel(parcel: Parcel) = Student(parcel)
        // Esto ayudara a serializar arrays del mismo tipo que esta clase (Student)
        override fun newArray(size: Int) = arrayOfNulls<Student?>(size)
    }
}