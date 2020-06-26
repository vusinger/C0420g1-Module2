package quan_ly_san_pham;

import java.io.Serializable;

public class Product implements Serializable {
    private static final long serialVersionUID = 1L;
    private int productId;
    private String productName;
    private String productMaker;
    private String productCost;

    public Product() {
    }

    public Product(int productId, String productName, String productMaker, String productCost) {
        super();
        this.productId = productId;
        this.productName = productName;
        this.productMaker = productMaker;
        this.productCost = productCost;
    }

    public int getProductId() {
        return productId;
    }

    public void setProductId(int productId) {
        this.productId = productId;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }

    public String getProductMaker() {
        return productMaker;
    }

    public void setProductMaker(String productMaker) {
        this.productMaker = productMaker;
    }

    public String getProductCost() {
        return productCost;
    }

    public void setProductCost(String productCost) {
        this.productCost = productCost;
    }

    @Override
    public String toString() {
        return "Product{" +
                "productId=" + productId +
                ", productName='" + productName + '\'' +
                ", productMaker='" + productMaker + '\'' +
                ", productCost='" + productCost + '\'' +
                '}';
    }
}
