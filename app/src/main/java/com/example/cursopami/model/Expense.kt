package com.example.cursopami.model

data class Expense(
    var description: String,
    var inputSource: String,
    var kind: String,
    var value: Double

) {
    override fun equals(other: Any?): Boolean {
        if (this === other) return true
        if (javaClass != other?.javaClass) return false

        other as Expense

        if (description != other.description) return false
        if (inputSource != other.inputSource) return false
        if (kind != other.kind) return false
        if (value != other.value) return false

        return true
    }

    override fun hashCode(): Int {
        var result = description.hashCode()
        result = 31 * result + inputSource.hashCode()
        result = 31 * result + kind.hashCode()
        result = 31 * result + value.hashCode()
        return result
    }
}