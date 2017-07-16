/**
  * Created by HWILKHU on 16/07/2017.
  */
import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object sparkWordCount{
  def main(args: Array[String]): Unit = {

    val conf = new SparkConf()
      .setMaster("local")
      .setAppName("word count")

    val sc = new SparkContext(conf)

    val input = args.length match {
      case x: Int if x > 0 => sc.textFile(args(0))
    }

    val output = args.length match {
      case x: Int if x > 1 => args(1)
    }

    val words = input.flatMap(line => line.split(" "))

    val counts = words.map(word => (word,1)).reduceByKey{case (x, y) => x + y}

    counts.saveAsTextFile(output)

  }
}



