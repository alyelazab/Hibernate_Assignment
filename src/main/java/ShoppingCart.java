import javax.persistence.Entity;
import javax.persistence.ManyToOne;

@Entity
public class ShoppingCart {
    public ShoppingCart(int i, int x, int z){
        this.id = i;
        this.customer_id = x;
        this.product_id = z;
    }
    public ShoppingCart(){
        this.id=-1;
        this.customer_id=-1;
        this.product_id=-1;
    }
    private int id;

    private int customer_id;
    private int product_id;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getCustomer_id() {
        return customer_id;
    }

    public void setCustomer_id(int customer_id) {
        this.customer_id = customer_id;
    }

    public int getProduct_id() {
        return product_id;
    }

    public void setProduct_id(int product_id) {
        this.product_id = product_id;
    }
}
