import org.apache.spark.sql.{DataFrame, SparkSession}

class NotSold {

  def getNotSold(spark: SparkSession): DataFrame = {

    val salesDf = spark.read.option("delimiter", "|").schema(Utils.salesschema).csv(Utils.salespath)
    salesDf.createOrReplaceTempView("sales")

    val productDf = spark.read.option("delimiter", "|").schema(Utils.productschema).csv(Utils.productpath)
    productDf.createOrReplaceTempView("product")

    val notSoldStem = spark
      .sql("Select product_name from Product p left outer join sales s on p.product_id = s.product_id where s.product_id is null")

    notSoldStem
  }
}

object NotSold {

  def apply(): NotSold = new NotSold()
}