import org.apache.spark.sql.SparkSession

object DriverClass {

  def main(args: Array[String]): Unit = {
    val spark = SparkSession.builder().master("local[*]").appName("Final").getOrCreate()

    val notSoldDf = NotSold().getNotSold(spark)
    notSoldDf.show(2,false)



  }

}
