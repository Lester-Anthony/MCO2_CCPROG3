public class Main {
    public static void main(String[] args) {
        
        // Create initial instance of RegularVM class
        RegularVM vm = new RegularVM("VendingMachine");

        // Creating instances of different denominations based on Filipino currency and adding it to vending machine's balance
        // int denominations[] = {1000, 500, 200, 100, 50, 20, 10, 5, 1};

        // for(int denomination : denominations) {
        //     vm.addDenomination(new Denomination("PHP " + denomination, denomination, 100));
        // }

        // for(Denomination d : vm.getBalance()) {
        //     System.out.println(d.getValue());
        // }
        // System.out.println(vm.getBalance().size());

        Controller controller = new Controller();
    }
}
