/**
 * @author Francisco Miguel Arámburo Torres - atfm05@gmail.com
 */

package controllers

import play.api.libs.ws.Response

object DB extends Neo4j

/**
 * Class that handles the Neo4j http queries.
 */
class Neo4j extends WebService {

  var tag: String = null

  /**
   * Queries through http to the registered Neo4j
   * server.
   *
   * @param query string (cypher).
   * @param callback (Response, Boolean)=>Unit callback with 
   *                 second parameter 'true' if there was an error.
   * @return a future that handles the response.
   */
  def query (query: String, callback: (Response, Boolean)=>Unit): Unit = {
    post("/db/data/cypher", Json.obj("query" -> query), callback)   
  }

}