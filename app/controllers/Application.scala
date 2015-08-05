package controllers

import javax.inject.Inject

import models.Cat
import play.api.data.Form
import play.api.data.Forms._
import play.api.mvc._

import play.api.i18n.{I18nSupport, MessagesApi}

// class Application extends Controller {


class Application @Inject() (val messagesApi: MessagesApi) extends Controller with I18nSupport {


  val catForm = Form {
    mapping(
      "id" -> ignored(None:Option[Long]),
      "name" -> nonEmptyText,
      "color" -> nonEmptyText,
      "race" -> nonEmptyText,
      "gender" -> nonEmptyText
    )(Cat.apply)(Cat.unapply)
  }

  def index = Action {
    Redirect(routes.Application.cats)
  }

  def createCat = Action {
      // Display New Cat form
      Ok(views.html.createCat("Add a new cat", catForm))
  }

  def saveCat = Action { implicit request =>
    // Bind the form first, then fold the result, passing a function to handle errors, and a function to handle succes.
    catForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.index(Cat.all))
      },
      CreateCatForm => {
        models.Cat.create(CreateCatForm.name, CreateCatForm.color, CreateCatForm.race, CreateCatForm.gender)
        Redirect (routes.Application.cats())
      }
    )
  }

  def editCat(id: Long) = Action {
    models.Cat.findById(id).map { cat =>
      //CreateCatForm.apply(Cat.unapply())
      Ok(views.html.editCat("Editing cat", id, catForm.fill(cat)))
    }.getOrElse(NotFound)
  }

  def updateCat(id: Long) = Action { implicit request =>
    catForm.bindFromRequest.fold(
      formWithErrors => {
        BadRequest(views.html.index(Cat.all))
      },
      kisu => {
        models.Cat.update(id, kisu)
        Redirect (routes.Application.cats())
      }
    )
  }

  def deleteCat(id: Long) = Action {
    models.Cat.delete(id)
    Redirect(routes.Application.cats())

  }

  def cats = Action {
    Ok(views.html.index(models.Cat.all()))
  }

}
