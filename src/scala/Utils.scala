
import org.apache.spark.sql.types.{IntegerType, StringType, StructField, StructType}

object Utils {

  val productpath = "E:\\PersonalProjects\\FirstExperiment\\inputData\\Product.txt"
  val customerpath = "E:\\PersonalProjects\\FirstExperiment\\inputData\\Product.txt"
  val refundpath =  "E:\\PersonalProjects\\FirstExperiment\\inputData\\Product.txt"
  val salespath = "E:\\PersonalProjects\\FirstExperiment\\inputData\\Product.txt"

  val productschema = StructType(Array
  (StructField("product_id",IntegerType),
    StructField("product_name",StringType),
    StructField("product_type",StringType),
    StructField("product_version",StringType),
    StructField("product_price",StringType)))

  val salesschema = StructType(Array
  (StructField("transaction_id",IntegerType),
    StructField("customer_id",StringType),
    StructField("product_id",StringType),
    StructField("timestamp",StringType),
    StructField("total_amount",StringType),
    StructField("total_quantity",IntegerType)))


}
