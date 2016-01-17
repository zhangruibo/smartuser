package scheduler

import java.text.SimpleDateFormat
import java.util.Calendar

import analysis.TableOneHbase
import net.SinaRequest
import org.apache.spark.{SparkConf, SparkContext}
import util.HdfsFileUtil

import scala.collection.mutable

/**
  * Created by yangshuai on 2016/1/16.
  */
object Scheduler extends App {

  def writeSth(str: String): Unit = {
    val today = Calendar.getInstance.getTime
    val format = new SimpleDateFormat("HH-mm-ss")
    val timeStr = format.format(today)

    HdfsFileUtil.setHdfsUri("hdfs://server:9000")
    HdfsFileUtil.setRootDir("smartuser")
    val currentPath = HdfsFileUtil.mkDir(HdfsFileUtil.getRootDir+"test")
    HdfsFileUtil.mkFile(currentPath + timeStr)
    HdfsFileUtil.writeString(currentPath + timeStr, str)
  }

  def validCode(code: String): Boolean = {
    if (code.length == 0)
      return false
    val head = code.charAt(0)
    if (head == '0' || head == '3' || head == '6' || head == '9')
      return true
    false
  }

//  SinaRequest.sendRequest(mutable.HashMap("list" -> "sh601006"))

  val conf =  new SparkConf().setMaster("local").setAppName("su")
  val sc = new SparkContext(conf)
  val table = new TableOneHbase
  val stockList = table.dataAnalysis(conf, sc, 1)
//  val lines = sc.wholeTextFiles("hdfs://server:9000/smartuser/hbasedata/2016-01-16_21/")
//  lines.values.flatMap(_.split("\n")).map((_, 1)).reduceByKey(_+_).sortByKey(ascending = true).keys.filter(validCode).saveAsTextFile("hdfs://server:9000/smartuser/hbasedata/stockCodes")
  sc.stop
}