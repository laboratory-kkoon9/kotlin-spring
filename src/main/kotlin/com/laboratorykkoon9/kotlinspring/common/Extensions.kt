package com.laboratorykkoon9.kotlinspring.common

import javax.crypto.Cipher
import javax.crypto.spec.SecretKeySpec

fun String.encrypt(key: String): ByteArray {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    val secretKey = SecretKeySpec(key.toByteArray(), "AES")
    cipher.init(Cipher.ENCRYPT_MODE, secretKey)
    return cipher.doFinal(this.toByteArray())
}

fun ByteArray.decrypt(key: String): String {
    val cipher = Cipher.getInstance("AES/ECB/PKCS5Padding")
    val secretKey = SecretKeySpec(key.toByteArray(), "AES")
    cipher.init(Cipher.DECRYPT_MODE, secretKey)
    return String(cipher.doFinal(this))
}
