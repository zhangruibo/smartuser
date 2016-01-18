package calculate
import stock.Stock

/**
  * Created by kerry on 16/1/16.
  * 一共分为三个时间:9:30-11:30  13:00-15:00  9:30-15:00
  * 假设开始时间全部买入,结束时间全部卖出.计算每个股票的回报率
  */
class StockStrategyOne extends RateOfReturnStrategy {

  override def calculate(t:Float, r:Float): Float = {
    1 * (r - t) / t
  }
}
