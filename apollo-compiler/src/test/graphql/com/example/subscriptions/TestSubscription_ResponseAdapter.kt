// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.subscriptions

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import kotlin.Array
import kotlin.Int
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestSubscription_ResponseAdapter : ResponseAdapter<TestSubscription.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forObject("commentAdded", "commentAdded", mapOf<String, Any>(
      "repoFullName" to mapOf<String, Any>(
        "kind" to "Variable",
        "variableName" to "repo")), true, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestSubscription.Data {
    return reader.run {
      var commentAdded: TestSubscription.CommentAdded? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> commentAdded = readObject<TestSubscription.CommentAdded>(RESPONSE_FIELDS[0]) { reader ->
            TestSubscription_ResponseAdapter.CommentAdded_ResponseAdapter.fromResponse(reader)
          }
          else -> break
        }
      }
      TestSubscription.Data(
        commentAdded = commentAdded
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: TestSubscription.Data) {
    if(value.commentAdded == null) {
      writer.writeObject(RESPONSE_FIELDS[0], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
        TestSubscription_ResponseAdapter.CommentAdded_ResponseAdapter.toResponse(writer, value.commentAdded)
      }
    }
  }

  object CommentAdded_ResponseAdapter : ResponseAdapter<TestSubscription.CommentAdded> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forInt("id", "id", null, false, null),
      ResponseField.forString("content", "content", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?):
        TestSubscription.CommentAdded {
      return reader.run {
        var __typename: String? = __typename
        var id: Int? = null
        var content: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> id = readInt(RESPONSE_FIELDS[1])
            2 -> content = readString(RESPONSE_FIELDS[2])
            else -> break
          }
        }
        TestSubscription.CommentAdded(
          __typename = __typename!!,
          id = id!!,
          content = content!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestSubscription.CommentAdded) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeInt(RESPONSE_FIELDS[1], value.id)
      writer.writeString(RESPONSE_FIELDS[2], value.content)
    }
  }
}
