package lw01.prelab;

public abstract class PrintJob implements Chargeable{
    private String id;
    private int pages;

    public PrintJob(String id, int pages) {
        if (pages <= 0){
            throw new IllegalArgumentException("Jumlah halaman harus bernilai positif.");
        }
        this.id = id;
        this.pages = pages;
    }

    public String getId() {
        return id;
    }

    public int getPages() {
        return pages;
    }

    public String label(){
        return "Print";
    }

    public abstract int calculateCharge();

    public int calculateCharge(int copies){
        if(copies <= 0){
            throw new IllegalArgumentException("Jumlah salinan harus bernilai positif.");
        }
        return copies * calculateCharge();
    }

    public String summary(){
        return id + " | " + label() + " | " + calculateCharge();
    }
}
