// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.introspection_query

import com.apollographql.apollo.api.Operation
import com.apollographql.apollo.api.OperationName
import com.apollographql.apollo.api.Query
import com.apollographql.apollo.api.Response
import com.apollographql.apollo.api.ResponseField
import com.apollographql.apollo.api.ScalarTypeAdapters
import com.apollographql.apollo.api.ScalarTypeAdapters.Companion.DEFAULT
import com.apollographql.apollo.api.internal.QueryDocumentMinifier
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import com.apollographql.apollo.api.internal.SimpleOperationResponseParser
import com.apollographql.apollo.api.internal.Throws
import kotlin.Array
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List
import okio.BufferedSource
import okio.IOException

@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter")
class TestQuery : Query<TestQuery.Data, TestQuery.Data, Operation.Variables> {
  override fun operationId(): String = OPERATION_ID
  override fun queryDocument(): String = QUERY_DOCUMENT
  override fun wrapData(data: Data?): Data? = data
  override fun variables(): Operation.Variables = Operation.EMPTY_VARIABLES
  override fun name(): OperationName = OPERATION_NAME
  override fun responseFieldMapper(): ResponseFieldMapper<Data> = ResponseFieldMapper.invoke {
    Data(it)
  }

  @Throws(IOException::class)
  override fun parse(source: BufferedSource, scalarTypeAdapters: ScalarTypeAdapters): Response<Data>
      = SimpleOperationResponseParser.parse(source, this, scalarTypeAdapters)

  @Throws(IOException::class)
  override fun parse(source: BufferedSource): Response<Data> = parse(source, DEFAULT)

  data class QueryType(
    val __typename: String = "__Type",
    val name: String?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@QueryType.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@QueryType.name)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): QueryType = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])
        QueryType(
          __typename = __typename,
          name = name
        )
      }
    }
  }

  data class Type(
    val __typename: String = "__Type",
    val name: String?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@Type.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@Type.name)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): Type = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])
        Type(
          __typename = __typename,
          name = name
        )
      }
    }
  }

  data class __Schema(
    val __typename: String = "__Schema",
    /**
     * The type that query operations will be rooted at.
     */
    val queryType: QueryType,
    /**
     * A list of all types supported by this server.
     */
    val types: List<Type>
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@__Schema.__typename)
      writer.writeObject(RESPONSE_FIELDS[1], this@__Schema.queryType.marshaller())
      writer.writeList(RESPONSE_FIELDS[2], this@__Schema.types) { value, listItemWriter ->
        value?.forEach { value ->
          listItemWriter.writeObject(value?.marshaller())}
      }
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forObject("queryType", "queryType", null, false, null),
          ResponseField.forList("types", "types", null, false, null)
          )

      operator fun invoke(reader: ResponseReader): __Schema = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val queryType = readObject<QueryType>(RESPONSE_FIELDS[1]) { reader ->
          QueryType(reader)
        }!!
        val types = readList<Type>(RESPONSE_FIELDS[2]) { reader ->
          reader.readObject<Type> { reader ->
            Type(reader)
          }
        }!!.map { it!! }
        __Schema(
          __typename = __typename,
          queryType = queryType,
          types = types
        )
      }
    }
  }

  data class __Type(
    val __typename: String = "__Type",
    val name: String?
  ) {
    fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeString(RESPONSE_FIELDS[0], this@__Type.__typename)
      writer.writeString(RESPONSE_FIELDS[1], this@__Type.name)
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forString("__typename", "__typename", null, false, null),
          ResponseField.forString("name", "name", null, true, null)
          )

      operator fun invoke(reader: ResponseReader): __Type = reader.run {
        val __typename = readString(RESPONSE_FIELDS[0])!!
        val name = readString(RESPONSE_FIELDS[1])
        __Type(
          __typename = __typename,
          name = name
        )
      }
    }
  }

  data class Data(
    val __schema: __Schema,
    val __type: __Type?
  ) : Operation.Data {
    override fun marshaller(): ResponseFieldMarshaller = ResponseFieldMarshaller.invoke { writer ->
      writer.writeObject(RESPONSE_FIELDS[0], this@Data.__schema.marshaller())
      writer.writeObject(RESPONSE_FIELDS[1], this@Data.__type?.marshaller())
    }

    companion object {
      private val RESPONSE_FIELDS: Array<ResponseField> = arrayOf(
          ResponseField.forObject("__schema", "__schema", null, false, null),
          ResponseField.forObject("__type", "__type", mapOf<String, Any>(
            "name" to "Vehicle"), true, null)
          )

      operator fun invoke(reader: ResponseReader): Data = reader.run {
        val __schema = readObject<__Schema>(RESPONSE_FIELDS[0]) { reader ->
          __Schema(reader)
        }!!
        val __type = readObject<__Type>(RESPONSE_FIELDS[1]) { reader ->
          __Type(reader)
        }
        Data(
          __schema = __schema,
          __type = __type
        )
      }
    }
  }

  companion object {
    const val OPERATION_ID: String =
        "08518fde8892d59c699c4d48f384d7199d933a5846e6936d910cb492b8f84684"

    val QUERY_DOCUMENT: String = QueryDocumentMinifier.minify(
          """
          |query TestQuery {
          |  __schema {
          |    __typename
          |    queryType {
          |      __typename
          |      name
          |    }
          |    types {
          |      __typename
          |      name
          |    }
          |  }
          |  __type(name: "Vehicle") {
          |    __typename
          |    name
          |  }
          |}
          """.trimMargin()
        )

    val OPERATION_NAME: OperationName = object : OperationName {
      override fun name(): String = "TestQuery"
    }
  }
}
