package com.baidyanath.utils.api

/**
 * A value which says if a request was successful or not
 */
enum class MessageType(name: String) {
    /**
     * A message type when a request succeeds for an instance
     */
    SUCCESS("Success"),

    /**
     * A message type when a request fails for an instance
     */
    FAILED("Failed")
}