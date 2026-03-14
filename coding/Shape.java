public sealed class Shape permits Circle, Rectangle, Square {}

// 1️⃣ final: no one else can extend Circle
final class Circle extends Shape {}

// 2️⃣ sealed: Rectangle can be extended, but only by specific classes
sealed class Rectangle extends Shape permits FilledRectangle, EmptyRectangle {}
final class FilledRectangle extends Rectangle {}
final class EmptyRectangle extends Rectangle {}

// 3️⃣ non-sealed: anyone can extend Square (restriction removed)
non-sealed class Square extends Shape {}

//final class  FilledRectangle extends Shape{}

 class P extends Square {}