package com.sikander.presentation.base

interface RecyclerItem {
    val id: Int?
    override fun equals(other: Any?): Boolean
    override fun hashCode(): Int
}