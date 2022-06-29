package rlt.pkg1

object CollectionTest extends App {

  def test_var_set{
    var jetSet = Set("Boeing", "Airbus")
    jetSet += "Lear"

    println(jetSet)
    println(jetSet.contains("Cessna"))
    println(jetSet.contains("Airbus"))
    println("------------------------------------------ end of test_var_set")
  }

  def test_val_set{
    import scala.collection.mutable.Set
    val movieSet = Set("Hitch", "Poltergeist")
    movieSet += "Shrek"
    println(movieSet)
    println("------------------------------------------ end of test_val_set")
  }

  def test_hash_set{
    import scala.collection.immutable.HashSet
    val hashSet = HashSet("Tomatoes", "Chilies")
    println(hashSet + "Coriander")
    println("------------------------------------------ end of test_hash_set")
  }

  def test_map1 {
    import scala.collection.mutable.Map
    val treasureMap = Map[Int, String]()
    treasureMap += (1 -> "Go to island.")
    treasureMap += (2 -> "Find big X on ground.")
    treasureMap += (3 -> "Dig.")
    println(treasureMap(2))
    println("------------------------------------------ end of test_map1")
  }

  def test_map2 {
    val romanNumeral = Map(
        1 -> "I"
      , 2 -> "II"
      , 3 -> "III"
      , 4 -> "IV"
      , 5 -> "V"
      , 6 -> "VI"
      , 7 -> "VII"
    )

    println(romanNumeral(4))
    println("------------------------------------------ end of test_map2")
  }

  def test_array1 {
    val my_array = new Array[String](3)
    my_array(0) = "1234"
    my_array(1) = "abcd"
    my_array(2) = "11aa"

    my_array.foreach( elem => println(elem))
    println("------------------------------------------ end of test_array1")
  }

  def test_array2 {
    val my_array = Array (1.1, 2.3, 4.4)
    my_array.foreach( elem => println(elem))  // ---> NOTE
    println("------------------------------------------ end of test_array2")
  }

  test_var_set
  test_val_set
  test_hash_set
  test_map1
  test_map2
  test_array1
  test_array2
}
