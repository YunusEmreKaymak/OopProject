public interface MyIterator {
    boolean isNotDone();
    Parent next();
    void add(Parent e);
    void reset();
}
