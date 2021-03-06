package log

import org.apache.log4j.{BasicConfigurator, PropertyConfigurator, Logger}

/**
  * Created by yangshuai on 2016/1/26.
  */
object SILogger {

  val logger = Logger.getLogger("STOCK_INFO")
  BasicConfigurator.configure()
  PropertyConfigurator.configure("/home/smartuser/conf/stockinfo_log4j.properties")

  def debug(msg: String): Unit = {
    logger.debug(msg)
  }

  def info(msg: String): Unit = {
    logger.info(msg)
  }

  def warn(msg: String): Unit = {
    logger.warn(msg)
  }

  def error(msg: String): Unit = {
    logger.error(msg)
  }

  def exception(e: Exception): Unit = {
    logger.error(e.printStackTrace())
  }

}
