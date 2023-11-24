package services;

public class DataInit {
    public static void main(String[] args) {
        ClientService clientService = new ClientService();
        System.out.println(clientService.create("John Deer"));
        System.out.println(clientService.getById(20));
        clientService.setName(20, "petya");
        clientService.deleteById(20);
        System.out.println(clientService.listAll());
    }
}
