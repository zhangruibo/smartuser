package util
import java.util.Calendar
import org.scalatest.{FlatSpec, Matchers}
/**
  * Created by C.J.YOU on 2016/1/16.
  */
class HdfsFileUtilTest extends FlatSpec with Matchers {

  /*
  "writeString method" should "work" in {
    val today = Calendar.getInstance.getTime
    HdfsFileUtil.setHdfsUri("hdfs://server:9000")
    HdfsFileUtil.setRootDir("smartuser")
    val currentPath = HdfsFileUtil.mkDir(HdfsFileUtil.getRootDir+"days")
    val file =  currentPath+System.currentTimeMillis()
    HdfsFileUtil.mkFile(file)
    val stri2 = "onetwothree"
    val stri = "one\ttwo\tthree"
    HdfsFileUtil.writeString(file,stri)
    HdfsFileUtil.writeString(file,stri2)

  }
  */

  "getDirectoryContentFromHdfs method" should "work" in {
    val today = Calendar.getInstance.getTime
    HdfsFileUtil.setHdfsUri("hdfs://server:9000")
    HdfsFileUtil.setRootDir("smartuser")
    val hashmap = HdfsFileUtil.getDirectoryContentFromHdfs("hdfs://server:9000/smartuser/days")
    val value = hashmap.get("file1")
    println(value)

  }
}
