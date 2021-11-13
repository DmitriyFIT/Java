public class Printer {

    private String quene = "";
    private String text = "";
    private String name = "";
    private int pagesCount = 0;
    private int totalPagesCount = 0;

    public Printer(){
        quene = "\nИнформация о документах поступивших в принтер:\n";
    }
    public Printer(String text, String name, int pagesCountDocument){
        this.text = text;
        this.name = name;
    }

    public void add(String text){
        quene += "Текс документа - " + text + "\n";
        pagesCount += 1;
    }

    public void add(String text, String name){
        quene += "Текс документа - " + text + ", Имя документа - " + name + "\n";
        pagesCount += 1;
    }

    public void add(String text, String name, int pagesCountDocument){
        quene += "Текс документа - " + text + ", Имя документа - " + name + ", Количество страниц: " + pagesCountDocument + "\n";
        pagesCount += pagesCountDocument;
    }

    public void print(){
        System.out.println(quene + "\nОбщее число страниц поступивших на печать: " + getPendingPagesCount());
        clear();
    }

    public void clear(){
        quene = "";
        totalPagesCount += pagesCount;
        pagesCount = 0;
        System.out.println("Информация о напечатанных документах очищена.");
        System.out.println("Общее количество страниц распечатанных за все время: " + getAllPagesCount() + "\n");
    }

    public int getPendingPagesCount(){
        return pagesCount;
    }

    public int getAllPagesCount(){
        return totalPagesCount;
    }
}
