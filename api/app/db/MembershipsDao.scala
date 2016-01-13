package db

import io.flow.group.v0.models.{UserReference, User, Membership, Group}
import io.flow.postgresql.{Query, OrderBy}
import play.api.db._
import play.api.Play.current
import play.api.libs.json._

object MembershipsDao {

  private[this] val BaseQuery = Query(s"""
    select id,
      group_id,
      user_id
    from memberships
  """)

  def findAllExpanded(
     ids: Option[Seq[String]] = None,
     name: Option[String] = None,
     isDeleted: Option[Boolean] = Some(false),
     limit: Long = 25,
     offset: Long = 0,
     orderBy: OrderBy = OrderBy("-created_at", Some("memberships"))
   ): Option[Seq[Membership]] = {
    /*DB.withConnection { implicit c =>
      Standards.query(
        BaseQuery,
        tableName = "memberships",
        ids = ids,
        isDeleted = isDeleted,
        orderBy = orderBy.sql,
        limit = Some(limit),
        offset = offset
      ).
        text(
          "memberships.name",
          name,
          columnFunctions = Seq(Query.Function.Lower),
          valueFunctions = Seq(Query.Function.Lower, Query.Function.Trim)
        ).
        as(
          io.flow.group.v0.anorm.parsers.Membership.table("memberships").*
        )
      }*/
    Some(Seq(Membership("1", Group("1", "g1"), User("1", Some("test@test.com")))))
  }

  def findAll(
                       ids: Option[Seq[String]] = None,
                       name: Option[String] = None,
                       isDeleted: Option[Boolean] = Some(false),
                       limit: Long = 25,
                       offset: Long = 0,
                       orderBy: OrderBy = OrderBy("-created_at", Some("memberships"))
                     ): Option[Seq[Membership]] = {
    /*DB.withConnection { implicit c =>
      Standards.query(
        BaseQuery,
        tableName = "memberships",
        ids = ids,
        isDeleted = isDeleted,
        orderBy = orderBy.sql,
        limit = Some(limit),
        offset = offset
      ).
        text(
          "memberships.name",
          name,
          columnFunctions = Seq(Query.Function.Lower),
          valueFunctions = Seq(Query.Function.Lower, Query.Function.Trim)
        ).
        as(
          io.flow.group.v0.anorm.parsers.Membership.table("memberships").*
        )
      }*/
    Some(Seq(Membership.apply("1", Group.apply("1", "g1"), UserReference.apply("usr-20160110-103"))))
  }
}
