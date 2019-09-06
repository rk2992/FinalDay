import org.apache.spark.sql.{DataFrame, SparkSession}

class DistributionSales {

  def getDistributionSales(spark: SparkSession): DataFrame = {

    val productDf = spark.read.option("Delimiter","|").schema(Utils.productschema).csv(Utils.productpath)
    productDf.createOrReplaceTempView("product")

    val salesDf = spark.read.option("Delimiter","|").schema(Utils.salesschema).csv(Utils.salespath)
    salesDf.createOrReplaceTempView("sales")

    val distSale = spark.sql("select st.product_id, product_type, sum(st.total_quantity)" +
        "from sales st join product pt on st.product_id=pt.product_id group by st.product_id,product_type"
}
}
object  DistributionSales {

  def apply(): DistributionSales = new DistributionSales()
}
