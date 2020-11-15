public class Product {
    private int productID;
    private String productType;
    private String productName;

    public Product(int i, String s, String x){
        this.productID = i;
        this.productType = s;
        this.productName = x;
    }
    public Product(){
        this.productID = -1;
        this.productType = null;
        this.productName = null;
    }
    public int getProductID() {
        return productID;
    }

    public void setProductID(int productID) {
        this.productID = productID;
    }

    public String getProductType() {
        return productType;
    }

    public void setProductType(String productType) {
        this.productType = productType;
    }

    public String getProductName() {
        return productName;
    }

    public void setProductName(String productName) {
        this.productName = productName;
    }
}
