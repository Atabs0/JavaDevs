public class Customer {
    int id;
    int priority;
    int ordertime;
    int distance;
    int inclock=0;
    int wait;
    Customer(int id,int p, int o,int d){
        this.id = id;
        priority=p;
        ordertime=o;
        distance= d;

    }
    public Customer() {
        // TODO Auto-generated constructor stub
    }
    static void printC(Customer[] c) {
        for (int i = 1; i < c.length; i++) {
            System.out.println();
            System.out.println("id " + c[i].id);
            System.out.println("priority " + c[i].priority);
            System.out.println("ordertime " + c[i].ordertime);
            System.out.println("distance " + c[i].distance);
        }
    }
}
