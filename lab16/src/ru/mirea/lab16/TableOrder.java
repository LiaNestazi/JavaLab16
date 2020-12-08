package ru.mirea.lab16;

public class TableOrder implements Order {
    private int size;
    private MenuItem[] items;
    private Customer customer;
    public TableOrder(){
        size=0;
    }
    public int getSize() {
        return size;
    }

    public boolean add(MenuItem item){
        MenuItem []temp=new MenuItem[size+1];
        for (int i=0;i<size;i++){
            temp[i]=items[i];
        }
        items=temp;
        items[size]=item;
        size++;
        return true;
    }
    public String[] itemsNames(){
        String[] names = new String[size];
        for (int i=0;i<size;i++){
            names[i]=items[i].getName();
        }
        return names;
    }
    public int itemsQuantity(){
        return size;
    }
    public int itemQuantity(String itemName){
        int quantity=0;
        for (int i=0;i<size;i++){
            if (items[i].getName().equals(itemName)){
                quantity++;
            }
        }
        return quantity;
    }
    public int itemQuantity(MenuItem itemName){
        int quantity=0;
        for (int i=0;i<size;i++){
            if (items[i].equals(itemName)){
                quantity++;
            }
        }
        return quantity;
    }

    public MenuItem[] getItems(){
        MenuItem[] it = new MenuItem[size];
        for (int i=0;i<size;i++){
            it[i]=items[i];
        }
        return it;
    }
    public boolean remove (String itemName){
        boolean isDeleted = false;
        for (int i=0;i<size;i++){
            if (items[i].getName().equals(itemName)) {
                items[i]=null;
                isDeleted=true;
                size--;
                break;
            }
        }
        MenuItem[] temp=new MenuItem[size];
        int j=0;
        for (MenuItem it:items){
            if (it!=null){
                temp[j]=it;
                j++;
            }
        }
        if (isDeleted){
            items=temp;
        }
        return isDeleted;
    }
    public boolean remove (MenuItem itemName){
        boolean isDeleted = false;
        for (int i=0;i<size;i++){
            if (items[i].equals(itemName)) {
                items[i]=null;
                isDeleted=true;
                size--;
                break;
            }
        }
        MenuItem[] temp=new MenuItem[size];
        int j=0;
        for (MenuItem it:items){
            if (it!=null){
                temp[j]=it;
                j++;
            }
        }
        if (isDeleted){
            items=temp;
        }
        return isDeleted;
    }
    public int removeAll(String itemName){
        int newsize=0,count=0;
        MenuItem []newarr=new MenuItem[newsize];
        for (int i=0;i<size;i++){
            if (!itemName.equals(items[i].getName())){
                newsize++;
                MenuItem []temp=newarr;
                newarr=new MenuItem[newsize];
                for (int j=0;j<newsize-1;j++){
                    newarr[j]=temp[j];
                }
            }
            else{
                count++;
            }
        }
        size=newsize;
        items=newarr;
        return count;
    }
    public int removeAll(MenuItem itemName){
        int newsize=0,count=0;
        MenuItem []newarr=new MenuItem[newsize];
        for (int i=0;i<size;i++){
            if (!itemName.equals(items[i])){
                newsize++;
                MenuItem []temp=newarr;
                newarr=new MenuItem[newsize];
                for (int j=0;j<newsize-1;j++){
                    newarr[j]=temp[j];
                }
            }
            else{
                count++;
            }
        }
        size=newsize;
        items=newarr;
        return count;
    }
    private static void quickSort(MenuItem[] array, int low, int high) {
        if (array.length == 0)
            return;

        if (low >= high)
            return;

        int middle = low + (high - low) / 2;
        int supp = array[middle].getCost();

        int i = low, j = high;
        while (i <= j) {
            while (array[i].getCost() > supp) {
                i++;
            }

            while (array[j].getCost() < supp) {
                j--;
            }

            if (i <= j) {
                MenuItem temp = array[i];
                array[i] = array[j];
                array[j] = temp;
                i++;
                j--;
            }
        }

        if (low < j)
            quickSort(array, low, j);

        if (high > i)
            quickSort(array, i, high);
    }
    public MenuItem[] sortedItemsByCostDesc(){
        MenuItem[] it=getItems();
        quickSort(it,0,size-1);
        return it;
    }
    public int costTotal(){
        int total=0;
        for (int i=0;i<size;i++){
            total+=items[i].getCost();
        }
        return total;
    }
    public Customer getCustomer(){
        return customer;
    }
    public void setCustomer(Customer customer){
        this.customer=customer;
    }
    public void clear(){
        size=0;
        items=null;
    }
}
