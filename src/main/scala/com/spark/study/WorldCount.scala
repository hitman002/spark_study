package com.spark.study

import org.apache.spark.SparkConf
import org.apache.spark.SparkContext

object WorldCount {
  
  def main(args: Array[String]): Unit = {
    val inputFile  = "D:\\scala\\spark_study\\src\\main\\resources\\input.txt";
    val outputFile = "D:\\scala\\spark_study\\src\\main\\resources\\output";
    
    val conf = new SparkConf().setAppName("wordCount")  
    val sc = new SparkContext(conf)
    val input = sc.textFile(inputFile);
    val words = input.flatMap { line => line.split(" ") }
    val counts = words.map( word => (word,1) ).reduceByKey{case (x,y) => x + y}
    counts.saveAsTextFile(outputFile)
    
  }
}