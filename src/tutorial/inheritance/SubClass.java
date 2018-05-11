package tutorial.inheritance;

public class SubClass extends SuperClass {

    public void modify (int one, int two) {
        super.setIntOne(one);
        super.setIntTwo(two);
    }

    public void print () {
        System.out.println(super.getIntOne() + " " + super.getIntTwo());
    }

}
