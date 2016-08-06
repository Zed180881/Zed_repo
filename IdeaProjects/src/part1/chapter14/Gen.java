package part1.chapter14;

class Gen<T> {
    T ob;

    Gen(T ob) {
        this.ob = ob;
    }

    /*Gen(){
        ob = new T();
    }*/

    T getOb() {
        System.out.print("Method getOb() from Gen class: ");
        return ob;
    }

    void showType() {
        System.out.println("Type T is " + ob.getClass().getName());
    }
}
