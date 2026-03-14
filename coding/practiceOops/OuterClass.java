package practiceOops;

public class OuterClass {
    private String str = "neelam";
    public void outerMethod(){
        System.out.println("This is outer method");
    }

    public class InnerClass{
        public void display(){
            System.out.println("This is inner class");
            System.out.println(str);
        }

        public void outerMethod(){
            System.out.println("Override outer method");
        }
    }
    public static void main(String[] args){
        OuterClass outerObj = new OuterClass();
        outerObj.outerMethod();
        InnerClass innerObj = outerObj.new InnerClass();
        innerObj.display();
        innerObj.outerMethod();

    }
}
