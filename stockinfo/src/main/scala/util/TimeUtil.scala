package util

import java.math.BigInteger
import java.text.SimpleDateFormat
import java.util.{Calendar, Date}

/**
  * Created by yangshuai on 2016/1/26.
  * 格式化时间的工具类
  */
object TimeUtil {

  def getTime(timeStamp: String): String = {
    val sdf: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd_HH:mm:ss")
    val bigInt: BigInteger = new BigInteger(timeStamp)
    val date: String = sdf.format(bigInt)
    date
  }

  def getDay: String = {
    val sdf: SimpleDateFormat = new SimpleDateFormat("yyyy-MM-dd")
    val date: String = sdf.format(new Date())
    date
  }

  def getCurrentHour: Int = {
    val calendar = Calendar.getInstance
    calendar.setTime(new Date)
    calendar.get(Calendar.HOUR_OF_DAY)
  }

}
