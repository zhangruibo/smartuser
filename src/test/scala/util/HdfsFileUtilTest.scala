package util

import analysis.DataAnalysis
import org.scalatest.{FlatSpec, Matchers}

import scala.collection.mutable

/**
  * Created by C.J.YOU on 2016/1/16.
  */
class HdfsFileUtilTest extends FlatSpec with Matchers {

  "writeString method" should "work" in {
    HdfsFileUtil.setHdfsUri("hdfs://server:9000")
    HdfsFileUtil.setRootDir("smartuser")
    val currentPath = HdfsFileUtil.mkDir(HdfsFileUtil.getRootDir+"days")
    HdfsFileUtil.mkFile(currentPath+"file5")
    val stri2 = "onetwothree"
    val stri = "one\ttwo\tthree"
    HdfsFileUtil.writeString(currentPath +"file5",stri)
    HdfsFileUtil.writeString(currentPath +"file5",stri2)

  }
}
