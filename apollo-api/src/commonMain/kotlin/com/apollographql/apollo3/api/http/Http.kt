package com.apollographql.apollo3.api.http

import okio.BufferedSink
import okio.BufferedSource
import okio.ByteString
import okio.ByteString.Companion.encodeUtf8

enum class HttpMethod {
  Get, Post
}

interface HttpBody {
  val contentType: String
  val contentLength: Long

  /**
   * This can be called several times
   */
  fun writeTo(bufferedSink: BufferedSink)
}

class HttpRequest(
    val url: String,
    val headers: Map<String, String>,
    val method: HttpMethod,
    val body: HttpBody?,
)

class HttpResponse(
    val statusCode: Int,
    val headers: Map<String, String>,
    /**
     * The actual body
     * It must always be closed if not null
     */
    val body: BufferedSource?,
)

fun HttpBody(
    contentType: String,
    byteString: ByteString,
) = object : HttpBody {
  override val contentType
    get() = contentType
  override val contentLength
    get() = byteString.size.toLong()

  override fun writeTo(bufferedSink: BufferedSink) {
    bufferedSink.write(byteString)
  }
}

fun HttpBody(
    contentType: String,
    string: String,
): HttpBody = HttpBody(contentType, string.encodeUtf8())
