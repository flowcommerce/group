package db

import io.flow.group.v0.models.Group
import io.flow.postgresql.{Query, OrderBy}
import play.api.db._
import play.api.Play.current
import play.api.libs.json._

object GroupsDao {

  private[this] val BaseQuery = Query(s"""
    select id,
      name
    from groups
  """)

  def findAll(
   ids: Option[Seq[String]] = None,
   name: Option[String] = None,
   isDeleted: Option[Boolean] = Some(false),
   limit: Long = 25,
   offset: Long = 0,
   orderBy: OrderBy = OrderBy("-created_at", Some("groups"))
  ): Seq[Group] = {
    DB.withConnection { implicit c =>
      Standards.query(
        BaseQuery,
        tableName = "groups",
        ids = ids,
        isDeleted = isDeleted,
        orderBy = orderBy.sql,
        limit = Some(limit),
        offset = offset
      ).
        text(
          "groups.name",
          name,
          columnFunctions = Seq(Query.Function.Lower),
          valueFunctions = Seq(Query.Function.Lower, Query.Function.Trim)
        ).
        as(
          io.flow.group.v0.anorm.parsers.Group.table("groups").*
        )
    }
  }
}
