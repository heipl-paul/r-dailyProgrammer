package tutorial.inheritance;

public class SuperClass {

    private Integer intOne;
    private Integer intTwo;

    public SuperClass () {}

    public SuperClass(Integer intOne, Integer intTwo) {
        this.intOne = intOne;
        this.intTwo = intTwo;
    }

    public Integer getIntOne() { return intOne; }

    public void setIntOne(Integer intOne) { this.intOne = intOne; }

    public Integer getIntTwo() { return intTwo; }

    public void setIntTwo(Integer intTwo) { this.intTwo = intTwo; }
}