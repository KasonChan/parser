package syntax

import com.sun.tools.javac.parser.JavaTokenizer

import scala.util.parsing.combinator.JavaTokenParsers

/**
 * Created by kasonchan on 2/1/15.
 */
class Scala extends JavaTokenParsers {
  def letter: Parser[Any] = upper | lower

  def upper: Parser[Any] = """[A-Z$_]""".r

  def lower: Parser[Any] = """[a-z]"""

  def digit: Parser[Any] = """[0-9]""".r

  def opchar: Parser[Any] = """[^A-Z$_a-z]""".r


  def op: Parser[Any] = opchar ~ rep(opchar)

  def varid: Parser[Any] = lower ~ idrest

  def plainid: Parser[Any] = upper ~ idrest | varid | op

  def id: Parser[Any] = plainid | "`" ~ stringLiteral ~ "`"

  def idrest: Parser[Any] = JavaTokenizer.rep(letter | digit) ~ opt("_" ~ op)

  //  TODO: Finish grammar
}
