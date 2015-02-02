package demo

import java.util.regex.Pattern

import syntax.Scala

/**
 * Created by kasonchan on 2/1/15.
 */
object Demo extends Scala {
  def main(args: Array[String]) {
    val notA = """[^aApple]\w*""".r
    
    val words = "Apple, Watermelon, Banana, Dragonfruit, Starfruit, Grape"
    
    val results = notA.findFirstMatchIn(words)
    
    results.foreach(println)
    
    // Print failure
    println(parseAll(plainid, "IDontKnow"))
  }
}
