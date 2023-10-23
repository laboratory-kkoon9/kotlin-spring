package com.laboratorykkoon9.kotlinspring.cafe.domain

import jakarta.persistence.*

@Entity
@Table(name = "options")
class Option(
    name: String,
    price: Int? = null,
    soldOut: Boolean,
) {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null

    @Column(name = "name")
    var name: String = name
        private set

    @Column(name = "price")
    var price: Int? = price
        private set

    @Column(name = "sold_out")
    var soldOut: Boolean = soldOut
        private set
}
