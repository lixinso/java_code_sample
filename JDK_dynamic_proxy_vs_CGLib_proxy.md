# JDK dynamic proxy vs CGLib proxy in Spring


|Key      | JDK dynamic proxy | CGLib proxy |
| ---     | ---               | ---         |
| Basic   | It can be only proxy by interface so target class needs to implement interface | It create proxy by subclassing | 
| Package | It is available with the Java | It is a thrid party | 
| Performance | It is a bit slow than CGLib proxy | It is faster than JDK dynamic proxy|
| Final | Final class and Final method can be proxy | Final class and Final method can not be proxy |
| Use case | Spring uses JDK proxy when is class is implementing one or mor interfaces | Spring uses CGLib proxy when class in not implementing interface |






- https://www.tutorialspoint.com/difference-between-jdk-dynamic-proxy-and-cglib-proxy-in-spring
