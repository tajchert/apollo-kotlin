// AUTO-GENERATED FILE. DO NOT MODIFY.
//
// This class was automatically generated by Apollo GraphQL plugin from the GraphQL queries it found.
// It should not be modified by hand.
//
package com.example.fragment_friends_connection.fragment

import com.apollographql.apollo.api.GraphqlFragment
import com.apollographql.apollo.api.internal.ResponseFieldMapper
import com.apollographql.apollo.api.internal.ResponseFieldMarshaller
import com.apollographql.apollo.api.internal.ResponseReader
import kotlin.Int
import kotlin.String
import kotlin.Suppress
import kotlin.collections.List

/**
 * A character from the Star Wars universe
 */
@Suppress("NAME_SHADOWING", "UNUSED_ANONYMOUS_PARAMETER", "LocalVariableName",
    "RemoveExplicitTypeArguments", "NestedLambdaShadowedImplicitParameter", "PropertyName",
    "RemoveRedundantQualifierName")
interface HeroDetails : GraphqlFragment {
  val __typename: String

  /**
   * The name of the character
   */
  val name: String

  /**
   * The friends of the character exposed as a connection with edges
   */
  val friendsConnection: FriendsConnection

  /**
   * A character from the Star Wars universe
   */
  interface Node {
    val __typename: String

    /**
     * The name of the character
     */
    val name: String

    fun marshaller(): ResponseFieldMarshaller
  }

  /**
   * An edge object for a character's friends
   */
  interface Edge {
    val __typename: String

    /**
     * The character represented by this friendship edge
     */
    val node: Node?

    fun marshaller(): ResponseFieldMarshaller
  }

  /**
   * A connection object for a character's friends
   */
  interface FriendsConnection {
    val __typename: String

    /**
     * The total number of friends
     */
    val totalCount: Int?

    /**
     * The edges for each of the character's friends.
     */
    val edges: List<Edge?>?

    fun marshaller(): ResponseFieldMarshaller
  }

  /**
   * A character from the Star Wars universe
   */
  data class Node1(
    override val __typename: String = "Character",
    /**
     * The name of the character
     */
    override val name: String
  ) : Node {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        HeroDetails_ResponseAdapter.Node1_ResponseAdapter.toResponse(writer, this)
      }
    }
  }

  /**
   * An edge object for a character's friends
   */
  data class Edge1(
    override val __typename: String = "FriendsEdge",
    /**
     * The character represented by this friendship edge
     */
    override val node: Node1?
  ) : Edge {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        HeroDetails_ResponseAdapter.Edge1_ResponseAdapter.toResponse(writer, this)
      }
    }
  }

  /**
   * A connection object for a character's friends
   */
  data class FriendsConnection1(
    override val __typename: String = "FriendsConnection",
    /**
     * The total number of friends
     */
    override val totalCount: Int?,
    /**
     * The edges for each of the character's friends.
     */
    override val edges: List<Edge1?>?
  ) : FriendsConnection {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        HeroDetails_ResponseAdapter.FriendsConnection1_ResponseAdapter.toResponse(writer, this)
      }
    }
  }

  /**
   * A character from the Star Wars universe
   */
  data class DefaultImpl(
    override val __typename: String = "Character",
    /**
     * The name of the character
     */
    override val name: String,
    /**
     * The friends of the character exposed as a connection with edges
     */
    override val friendsConnection: FriendsConnection1
  ) : HeroDetails {
    override fun marshaller(): ResponseFieldMarshaller {
      return ResponseFieldMarshaller { writer ->
        HeroDetails_ResponseAdapter.toResponse(writer, this)
      }
    }
  }

  companion object {
    val FRAGMENT_DEFINITION: String = """
        |fragment HeroDetails on Character {
        |  __typename
        |  name
        |  friendsConnection {
        |    __typename
        |    totalCount
        |    edges {
        |      __typename
        |      node {
        |        __typename
        |        name
        |      }
        |    }
        |  }
        |}
        """.trimMargin()

    operator fun invoke(reader: ResponseReader): HeroDetails {
      return HeroDetails_ResponseAdapter.fromResponse(reader)
    }

    fun Mapper(): ResponseFieldMapper<HeroDetails> {
      return ResponseFieldMapper { reader ->
        HeroDetails_ResponseAdapter.fromResponse(reader)
      }
    }
  }
}
