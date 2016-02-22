package db

import io.flow.postgresql.Query

/**
  * Provides docuemntation and implementation for the key attributes we
  * want on all of our findAll methods - implementing a common
  * interface to the API when searching resources.
*/
private[db] case object Standards {

  /**
    * Returns query object decorated with standard attributes in this
    * project.
    */
  def query(
   query: Query,
   tableName: String,
   ids: Option[Seq[String]],
   isDeleted: Option[Boolean],
   orderBy: Option[String],
   limit: Long,
   offset: Long
  ): Query = {
    query.
      optionalIn(
        s"$tableName.id",
        ids,
        valueFunctions = Seq(Query.Function.Lower, Query.Function.Trim)
      ).
      nullBoolean(s"$tableName.deleted_at", isDeleted).
      orderBy(orderBy).
      limit(limit).
      offset(offset)
  }

}
