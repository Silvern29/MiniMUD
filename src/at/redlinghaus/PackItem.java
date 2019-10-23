package at.redlinghaus;

public class PackItem {
    private Item packedItem;
    private int amount;

    public Item getPackedItem() {
        return packedItem;
    }

    public void setPackedItem(Item packedItem) {
        this.packedItem = packedItem;
    }

    public int getAmount() {
        return amount;
    }

    public void setAmount(int amount) {
        this.amount = amount;
    }
}
