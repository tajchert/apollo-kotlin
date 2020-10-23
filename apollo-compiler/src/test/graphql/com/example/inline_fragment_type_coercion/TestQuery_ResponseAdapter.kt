// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.inline_fragment_type_coercion

import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.internal.ResponseAdapter
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.ResponseWriter
import kotlin.Array
import kotlin.String
import kotlin.Suppress

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
object TestQuery_ResponseAdapter : ResponseAdapter<TestQuery.Data> {
  private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
    ResponseField.forObject("foo", "foo", null, true, null)
  )

  override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Data {
    return reader.run {
      var foo: TestQuery.Foo? = null
      while(true) {
        when (selectField(RESPONSE_FIELDS)) {
          0 -> foo = readObject<TestQuery.Foo>(RESPONSE_FIELDS[0]) { reader ->
            TestQuery_ResponseAdapter.Foo_ResponseAdapter.fromResponse(reader)
          }
          else -> break
        }
      }
      TestQuery.Data(
        foo = foo
      )
    }
  }

  override fun toResponse(writer: ResponseWriter, value: TestQuery.Data) {
    if(value.foo == null) {
      writer.writeObject(RESPONSE_FIELDS[0], null)
    } else {
      writer.writeObject(RESPONSE_FIELDS[0]) { writer ->
        TestQuery_ResponseAdapter.Foo_ResponseAdapter.toResponse(writer, value.foo)
      }
    }
  }

  object Bar_ResponseAdapter : ResponseAdapter<TestQuery.Bar> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("foo", "foo", null, false, null),
      ResponseField.forString("bar", "bar", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Bar {
      return reader.run {
        var __typename: String? = __typename
        var foo: String? = null
        var bar: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> foo = readString(RESPONSE_FIELDS[1])
            2 -> bar = readString(RESPONSE_FIELDS[2])
            else -> break
          }
        }
        TestQuery.Bar(
          __typename = __typename!!,
          foo = foo!!,
          bar = bar!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Bar) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.foo)
      writer.writeString(RESPONSE_FIELDS[2], value.bar)
    }
  }

  object OtherFoo_ResponseAdapter : ResponseAdapter<TestQuery.OtherFoo> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("foo", "foo", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.OtherFoo {
      return reader.run {
        var __typename: String? = __typename
        var foo: String? = null
        while(true) {
          when (selectField(RESPONSE_FIELDS)) {
            0 -> __typename = readString(RESPONSE_FIELDS[0])
            1 -> foo = readString(RESPONSE_FIELDS[1])
            else -> break
          }
        }
        TestQuery.OtherFoo(
          __typename = __typename!!,
          foo = foo!!
        )
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.OtherFoo) {
      writer.writeString(RESPONSE_FIELDS[0], value.__typename)
      writer.writeString(RESPONSE_FIELDS[1], value.foo)
    }
  }

  object Foo_ResponseAdapter : ResponseAdapter<TestQuery.Foo> {
    private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
      ResponseField.forString("__typename", "__typename", null, false, null),
      ResponseField.forString("foo", "foo", null, false, null)
    )

    override fun fromResponse(reader: ResponseReader, __typename: String?): TestQuery.Foo {
      val typename = __typename ?: reader.readString(RESPONSE_FIELDS[0])
      return when(typename) {
        "BarObject" -> TestQuery_ResponseAdapter.Bar_ResponseAdapter.fromResponse(reader, typename)
        "FooBar" -> TestQuery_ResponseAdapter.Bar_ResponseAdapter.fromResponse(reader, typename)
        else -> TestQuery_ResponseAdapter.OtherFoo_ResponseAdapter.fromResponse(reader, typename)
      }
    }

    override fun toResponse(writer: ResponseWriter, value: TestQuery.Foo) {
      when(value) {
        is TestQuery.Bar -> TestQuery_ResponseAdapter.Bar_ResponseAdapter.toResponse(writer, value)
        is TestQuery.OtherFoo -> TestQuery_ResponseAdapter.OtherFoo_ResponseAdapter.toResponse(writer, value)
      }
    }
  }
}
