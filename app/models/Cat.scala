package models

import anorm._
import anorm.SqlParser._
import anorm.RowParser
// import controllers.CreateCatForm

import play.api.db._
import play.api.Play.current
import play.api.libs.json.Json

/**
 * Created by Kaitsu on 26/07/15.
 */

/*
Details of the cats (Name, color, picture, race, gender)
*/
case class Cat (id: Option[Long] = None, name: String, color: String, race: String, gender: String)

object Cat {


  val listForm = {
    get[Option[Long]]("id") ~
    get[String]("name") ~
    get[String]("color") ~
    get[String]("race") ~
    get[String]("gender") map {
      case id~name~color~race~gender => Cat(id, name, color, race, gender)
    }
  }

  def all(): List[Cat] = DB.withConnection { implicit c =>
    SQL("select * from cat").as(listForm *)
  }

  def create(name: String, color: String, race: String, gender: String) {
    DB.withConnection { implicit c =>
      SQL("insert into cat (name, color, race, gender) values ({name}, {color}, {race}, {gender})").on(
        'name -> name,
        'color -> color,
        'race -> race,
        'gender -> gender
      ).executeUpdate()
    }
  }

  def delete(id: Long) {
    DB.withConnection { implicit c =>
      SQL("delete from cat where id = {id}").on(
        'id -> id
      ).executeUpdate()
    }
  }

  def findById(id: Long):Option[Cat] = {
    DB.withConnection { implicit c =>
      SQL("select * from cat where id = {id}").on (
        'id -> id).as(Cat.listForm.singleOpt)
    }
  }

  def update(id: Long, kisu: Cat) {
    DB.withConnection { implicit c =>
      SQL("update cat set name = {name}, color = {color}, race = {race}, gender = {gender} where id = {id}").on(
        'id -> id,
        'name -> kisu.name,
        'color -> kisu.color,
        'race -> kisu.race,
        'gender -> kisu.gender
      ).executeUpdate()
    }
  }
}
