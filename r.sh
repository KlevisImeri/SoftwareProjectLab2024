clear
# mvn exec:java 
mvn -q exec:java < Tests/TestsIn/test1.in
# mvn exec:java < Tests/TestsIn/test0.in 2> Tests/Out/out0.in  
# diff Tests/Out/out0.out Tests/TestsOut/test0.out