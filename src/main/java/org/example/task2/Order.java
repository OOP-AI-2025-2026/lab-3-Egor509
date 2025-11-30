package org.example.task2;

public class Order {

    private long id;
    private String customer;

    public Order(long id, String customer) {
        this.id = id;
        this.customer = customer;
    }

    public String formOrderBill(Cart cart) {

        StringBuilder builder = new StringBuilder();
        builder.append("Order number ").append(this.id).append(" for customer ").append(this.customer);
        builder.append("\n------------------\n");

        double sum = 0.0;

        for (int i = 0; i < cart.getCurrentSize(); i++) {

            // Отримуємо item безпечно
            Item currentItem = cart.getItemAtIndex(i);

            sum += currentItem.getPrice(); // .getPrice() замість .price

            builder.append("Item id: ");
            builder.append(currentItem.getId());
            builder.append(" name: ");
            builder.append(currentItem.getName());
            builder.append(" price: ");
            builder.append(currentItem.getPrice());
            builder.append("\n");
        }

        builder.append("------------------\n");
        builder.append("Total sum: ");
        builder.append(sum);

        return builder.toString();
    }
}