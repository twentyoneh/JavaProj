package ru.kalinin.adapter;

public class CardReader implements IUsb{

    private MemoryCard memoryCard;

    public CardReader(MemoryCard memoryCard) {
        this.memoryCard = memoryCard;
    }

    @Override
    public void connectWithUsbCable() {
        memoryCard.insert();
        memoryCard.copyData();
    }
}
