package quan_ly_san_pham;

import java.util.Comparator;

public class SortProduct extends Product implements Comparator<Product> {
    @Override
    public int compare(Product o1, Product o2) {
        return o1.cost-o2.cost;
    }
}
