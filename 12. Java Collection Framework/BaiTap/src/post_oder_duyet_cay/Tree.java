package post_oder_duyet_cay;

public interface Tree<E> {
//    Them phan tu vao tree
    boolean add(E e);
//    In phan tu trong tree
    void showPostOrder();
//    kich thuoc tree
    int size();
}
